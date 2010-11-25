Program Name: CMIS440 Lab 1 Word Counter
Author Brandon R Russell
Course CMIS440
Date: Nov 15,2010
IDE: NetBeans 6.9.1
OS: Windows 7
Java: JDK 1.6.0_22
Files: LabMainWindow.java, ThreadControl.java, WordCounter.java,
       FileResults.java, TotalResults.java, WordCounterInterface.java

Program Requirements: GUI Based, include JFileChooser, use atleast 4 different
UI controls from Chp. 14, include a menu, use a generic Map, including reading
and/or writing to a text file, use two methods from Chp. 16, use StringBuilder
class, and handle file related exceptions as a minimum.

Program Design: I designed this program so one can, from the main form, choose
either one or multiple text files, or an entire directory that contains the
text files, and the program will determine how many unique words are found in
the files and give a count of how often the words were used. It will display
this information on the main form and also to 'output.txt'. There are options
on where one can decide to make the search case sensitive and also to change
the delimiter. When program starts it will create a separate thread for each
text file being processed and will save this information in individual
FileResult objects and also into the shared TotalResults object.

Things you what me to know before I grade your work: I used the NetBeans
Graphic designer to create the GUI portion of this program. Also, for some
reason after my SwingWorker Thread, ThreadControl class, is done it hangs for
a few seconds before the GUI actually indicates it is done. I did some
exhaustive research on this, but could not determine a fix. Also, on the
ThreadControl class in the doInBackground method I did not throw my exceptions
, rather I caught them right there. I am able to throw them in the constructor
of this class and they are caught in the EDT, but for some reason this is not
the case for the doInBackground method of this SwingWorker. I initially found
through research that it was because I was not calling get() in my done method
, however I tried this and it did not work. The exceptions are being handled,
however, just not in the way I wanted them to. At this point, however, I just
don't have enough time to figure it out. Also, my output sent to the textarea
is limited to 15 characters per word. I set this hard limit so that the output
would have a more consistent look. I decided on 15 after researching some of
the bigger words in the English language and decided 15 would fit most words.
