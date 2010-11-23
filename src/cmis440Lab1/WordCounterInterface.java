package cmis440Lab1;


/**
* Program Name: CMIS440 Lab 1 Word Counter
* @author Brandon R Russell
* @Course CMIS440
*/

/** The Interface that defines the methods of the WordCounter class.
*|----------------------------------------------------------------------------|
*|                                CRC: WordCounterInterface                   |
*|----------------------------------------------------------------------------|
*|Interface for WordCounter                                       WordCounter |
*|----------------------------------------------------------------------------|
*
* @TheCs Cohesion - All methods in this class work together on similar task.
* Completeness - Completely defines interface for WordCounter class.
* Convenience - There are sufficient methods and variables to complete the
*                required task.
* Clarity - The methods and variables are distinguishable and work in a
*           uniform manner to provide clarity to other programmers.
* Consistency - All names,parameters ,return values , and behaviors follow
*               the same basic rules.
*/


public interface WordCounterInterface extends Runnable{

/** Only method in Runnable Interface.
* @TheCs Cohesion - run method from the runnable interface.
* Completeness - Completely specifies the run method from Runnable.
* Convenience - Simply specifies the run method from Runnable.
* Clarity - It is simple to understand that this specifies the run method
*           from Runnable.
* Consistency - It uses the same syntax rules as the rest of the class and
*               continues to use proper casing and indentation.
*/
public void run();

/** Returns the execution results.
* @TheCs Cohesion - Returns the execution results.
* Completeness - Completely returns the execution results.
* Convenience - Simply returns the execution results.
* Clarity - It is simple to understand that this returns the execution
*           results.
* Consistency - It uses the same syntax rules as the rest of the class and
*               continues to use proper casing and indentation.
*/
FileResults getFileResults();

}
