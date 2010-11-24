package cmis440Lab1;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
/**
* Program Name: CMIS440 Lab 1 Word Counter
* @author Brandon R Russell
* @Course CMIS440
* Date: Nov 15, 2010
*/

/** The Results class holds the Filename and Word count Map for a given File.
*|----------------------------------------------------------------------------|
*|                                CRC: FileResults                            |
*|----------------------------------------------------------------------------|
*|Set/Retrieve Filename                                        ThreadControl  |
*|Set/Retrieve Word Map                                          WordCounter  |
*|                                                                            |
*|----------------------------------------------------------------------------|
*
* @TheCs Cohesion - All methods in this class work together on similar task.
* Completeness - Completely holds map of unique words w/ count.
* Convenience - There are sufficient methods and variables to complete the
*                required task.
* Clarity - The methods and variables are distinguishable and work in a
*           uniform manner to provide clarity to other programmers.
* Consistency - All names,parameters ,return values , and behaviors follow
*               the same basic rules.
*/

public class FileResults {
    private String myFileName;
    private Map< String, Integer > myWordMap = new HashMap< String, Integer >();
    private StringBuilder myFormattedResults = new StringBuilder();

    /** All Data Fields of the Results class are initialized here.
    * @TheCs Cohesion - The Constructor.
    * Completeness - Every class should have a constructor, even if it is
    *                blank.
    * Convenience - It simply initializes the class.
    * Clarity - It is simple to understand that this is the constructor.
    * Consistency - It uses the same syntax rules as the rest of the class and
    *               continues to use proper casing and indentation.
    * @param aFileName contains name of file to be counted.
    */
    public FileResults(String aFileName){
        myFileName = aFileName;
    }

    /** Sets the name of the file to be counted.
    * @TheCs Cohesion - Sets the name of the file to be counted.
    * Completeness - Completely sets the name of the file to be counted.
    * Convenience - Simply sets the name of the file to be counted.
    * Clarity - It is simple to understand that this sets the name of the file
    *           to be counted.
    * Consistency - It uses the same syntax rules as the rest of the class and
    *               continues to use proper casing and indentation.
    * @param aFileName contains name of file to be counted.
    */
    public void setFileName(String aFileName){
        myFileName = aFileName;
    }

    /** Gets the name of the file to be counted.
    * @TheCs Cohesion - Gets the name of the file to be counted.
    * Completeness - Completely gets the name of the file to be counted.
    * Convenience - Simply gets the name of the file to be counted.
    * Clarity - It is simple to understand that this gets the name of the file
    *           to be counted.
    * Consistency - It uses the same syntax rules as the rest of the class and
    *               continues to use proper casing and indentation.
    */
    public String getFileName(){
        return myFileName;
    }

    /** Updates the unique word count in the word map
    * @TheCs Cohesion - Updates the unique word count in the word map
    * Completeness - Completely updates the unique word count in the word map
    * Convenience - Simply updates the unique word count in the word map
    * Clarity - It is simple to understand that this Updates the unique word
    *           count in the word map
    * Consistency - It uses the same syntax rules as the rest of the class and
    *               continues to use proper casing and indentation.
    * @param aWord contains the word to be added and counted to the map.
    */
    public void addWordToMap(String aWord){
        if (myWordMap.containsKey(aWord)){
            int count = myWordMap.get(aWord);
            myWordMap.put(aWord, count+1); //Not a new word; increase count by 1
        }
        else{
            myWordMap.put(aWord, 1); //New word; put in map and start count at 1
        }
    }

    /** Returns the current word map with unique words and count
    * @TheCs Cohesion - Returns the current word map with unique words and count
    * Completeness - Completely returns the current word map with unique words
    *                and count.
    * Convenience - Simply returns the current word map with unique words and
    *               count.
    * Clarity - It is simple to understand that this returns the current word
    *           map with unique words and count.
    * Consistency - It uses the same syntax rules as the rest of the class and
    *               continues to use proper casing and indentation.
    */
    public Map<String, Integer> getWordMap(){
        return myWordMap;
    }


    /** Overrides the toString method to provide more meaningful content. I
    * decided to print the FileName followed by a table format of word and then
    * count as well as totals at the bottom to give a good picture of what
    * the file contained.
    * @TheCs Cohesion - Overrides the toString method to provide more meaningful
    *                   content.
    * Completeness - Completely overrides the toString method to provide more
    *                meaningful content.
    * Convenience - Simply overrides the toString method to provide more
    *               meaningful content.
    * Clarity - It is simple to understand that this overrides the toString
    *           method to provide more meaningful content.
    * Consistency - It uses the same syntax rules as the rest of the class and
    *               continues to use proper casing and indentation.
    */
    @Override
    public String toString(){
        String formattedLine = "";
        int maxLength = 15;
        int numberOfWords = 0;
        String format = "|%1$-"+ maxLength +"s | %2$"+ maxLength +"s|\n";

        formattedLine = "FileName: " + this.getFileName().substring(
                this.getFileName().lastIndexOf("\\") + 1) + " contains:";
        myFormattedResults.append(formattedLine);
        myFormattedResults.append("\n-----------------------------------\n");
        formattedLine = String.format(format,"Word","Total Count");
        myFormattedResults.append(formattedLine);
        formattedLine = String.format(format,"---------------",
                "---------------");
        myFormattedResults.append(formattedLine);

        Set< String > keys = getWordMap().keySet();
        TreeSet < String > sortedKeys = new TreeSet< String >( keys);

        for (String key : sortedKeys){
            formattedLine = String.format(format,key.length() <= maxLength ?
                key : key.substring(0, maxLength),getWordMap().get(key));
            myFormattedResults.append(formattedLine);
            numberOfWords += getWordMap().get(key);
        }

        myFormattedResults.append("-----------------------------------\n");
        formattedLine = "Total number of unique words found: " + keys.size() +
                "\n" + "Total number of words found: " + numberOfWords + "\n\n";
        myFormattedResults.append(formattedLine);

        return myFormattedResults.toString();
    }

}
