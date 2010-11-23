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

/** This class holds Total word and count in a map. This class will be a
* shared resource that numerous threads access to keep a accurate count of the
* unique words in all of the files processed. The myTotalWordMap Map is
* marked as volatile to help ensure proper synchronization across all
* threads that will access this shared resource.
*|----------------------------------------------------------------------------|
*|                                CRC: TotalResults                           |
*|----------------------------------------------------------------------------|
*|Set/Retrieve unique word in a map                            ThreadControl  |
*|Set/Retrieve unique word count in a map                        WordCounter  |
*|----------------------------------------------------------------------------|
*
* @TheCs Cohesion - All methods in this class work together on similar task.
* Completeness - Completely holds Map of total unique words w/ count.
* Convenience - There are sufficient methods and variables to complete the
*                required task.
* Clarity - The methods and variables are distinguishable and work in a
*           uniform manner to provide clarity to other programmers.
* Consistency - All names,parameters ,return values , and behaviors follow
*               the same basic rules.
*/

public class TotalResults {


    private volatile Map< String, Integer > myTotalWordMap =
            new HashMap< String, Integer >();
    private StringBuilder myTotalFormattedResults = new StringBuilder();

    /**Constructor for TotalResults class.
    * @TheCs Cohesion - The Constructor.
    * Completeness - Every class should have a constructor, even if it is
    *                blank.
    * Convenience - It simply initializes the class.
    * Clarity - It is simple to understand that this is the constructor.
    * Consistency - It uses the same syntax rules as the rest of the class and
    *               continues to use proper casing and indentation.
    */
    public TotalResults(){

    }

    /** Updates the total word map words and count.
    * @TheCs Cohesion - Updates the total word map words and count.
    * Completeness - Completely updates the total word map words and count.
    * Convenience - Simply updates the total word map words and count.
    * Clarity - It is simple to understand that this updates the total word map
    *           words and count.
    * Consistency - It uses the same syntax rules as the rest of the class and
    *               continues to use proper casing and indentation.
    * @param aFileMap contains unique words/count from FileResult objects.
    */
    public void setTotalWordMap(Map aFileMap){
        Set< String > keys = aFileMap.keySet();
        TreeSet < String > sortedKeys = new TreeSet< String >( keys );

        for (String key : sortedKeys){
            if (myTotalWordMap.containsKey(key)){
                Integer countOneFile = (Integer) aFileMap.get(key);
                Integer countTotal = myTotalWordMap.get(key) + countOneFile;
                myTotalWordMap.put(key, countTotal);

            }
            else{
                Integer countOneFile = (Integer) aFileMap.get(key);
                //Integer countTotal = myTotalWordMap.get(key) + countOneFile;
                myTotalWordMap.put(key, countOneFile);
            }
        }
    }

    /** Retrieves the myTotalWordMap Map
    * @TheCs Cohesion - Retrieves the amount of unique words/count.
    * Completeness - Completely retrieves the amount of unique words/count.
    * Convenience - Simply retrieves the amount of unique words/count.
    * Clarity - It is simple to understand that this retrieves the amount of
    *           unique words/count.
    * Consistency - It uses the same syntax rules as the rest of the class and
    *               continues to use proper casing and indentation.
    */
    public Map getTotalWordMap(){
        return myTotalWordMap;
    }

    /** Overrides the toString method to provide more meaningful content. I
    * decided to print a table format of the unique word and count to
    * give a good picture of the data being processed.
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

        myTotalFormattedResults.append("-----------------------------------\n");
        formattedLine = String.format(format,"Word","Total Count");
        myTotalFormattedResults.append(formattedLine);
        formattedLine = String.format(format,"---------------",
                "---------------");
        myTotalFormattedResults.append(formattedLine);

        Set< String > keys = myTotalWordMap.keySet();
        TreeSet < String > sortedKeys = new TreeSet< String >( keys );
        for (String key : sortedKeys){
            formattedLine = String.format(format,key.length() <= maxLength ?
                key : key.substring(0, maxLength),myTotalWordMap.get(key));
            myTotalFormattedResults.append(formattedLine);
            numberOfWords += myTotalWordMap.get(key);
        }

        myTotalFormattedResults.append("-----------------------------------\n");
        formattedLine = "Total number of unique words found: " + keys.size() + 
                "\n" + "Total number of words found: " + numberOfWords + "\n\n";
        myTotalFormattedResults.append(formattedLine);

        return myTotalFormattedResults.toString();
    }

    

}
