package bobertz_p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


//the file needs to be placed in the project directory for it to pull the file. I couldn't specify another file directory as the ta will have
//a different directory they are working with on their computer
public class DuplicateRemover {
   private Set<String> uniqueWords;
   public void remove(String dataFile) throws FileNotFoundException
   {
       String word;
       uniqueWords = new HashSet<String>();
       Scanner scan=new Scanner(new File(dataFile));
       while(scan.hasNext())
       {
           word=scan.next();
           uniqueWords.add(word);
       }
       scan.close();
   }
   public void Write(String outputFile) throws IOException
   {
	File file;
	FileWriter fw = null;
	file = new File(outputFile);
	if(file.exists()) {
		fw=new FileWriter(file,true);
		Iterator itr=uniqueWords.iterator();
		while(itr.hasNext())
		{
		   String str=(String)itr.next();
		   fw.write(str+"\n");     
		}
	fw.close();
	System.out.println("Data Written to File");
	}
	else
	{
	file.createNewFile();
	fw=new FileWriter(file);
	Iterator itr=uniqueWords.iterator();
	while(itr.hasNext())
	{
	   String str=(String)itr.next();
	   fw.write(str+"\n");     
	}
	fw.close();
	System.out.println("Data Written to File");
	}
   }
}