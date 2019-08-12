import java.io.*;
import java.util.Scanner;

public class SimpleXMLTester {
	
	//Tag variables
	private static char START_TAG = '<';
	private static char END_TAG = '/';
	private static char CLOSE_TAG = '>';
	private static boolean startTag;
	ArrayStack stack = new ArrayStack();
	
	public String readTag (String line, int index)
	{
		StringBuffer name = new StringBuffer();
    	while (line.charAt(index) != CLOSE_TAG)
    	{
    		name.append(line.charAt(index));
    		index++;
    	}
    	return name.toString();
	}
	
	public int stackTag (String tagName, int index, boolean startTag) 
	{
    	//System.out.println(tagName);
    	//if start tag, push to stack
    	if(startTag == true)
    	{
      	   stack.push(tagName);
        }
    	else
    	{
    		String first = stack.peek();
    		//empty check
    		if(first == null)
    		{
    			return 1;
    		}
    		if(first.equals(tagName.toString()))
    		{
    			stack.pop();
    		}
    		else
    		{
    			return 1;
    		}
    	}
    	return 0;
	}
	
	public int checkTags (String line)
	{
		int errors = 0;
		int lineIndex = 0;
		//read line, iterate through
		while (lineIndex < line.length()) 
		{	          
			//is tag?
			//if at index = start tag
			//set to true
			//move
			int nextIndex = lineIndex+1;
			//check if end tag
				//set false
				//move
			//otherwise move
			//read the name of tag
	        String tagName = readTag(line, nextIndex);
	        //check for errors
	        errors += stackTag(tagName, nextIndex, startTag);
	        //else move
	       	lineIndex++;	
		}
		return errors;
	}
	
	//read file one line at a time
	public void readFile (String fileName) throws FileNotFoundException
	{
		int errors = 0;
		
		File aFile = new File(fileName);
		Scanner input = new Scanner(aFile);
		
		while (input.hasNextLine())
		{
			String line = input.nextLine();
			line.replaceAll("\\s+","");
			//System.out.println(line);
			errors += checkTags(line);
		}
		
		if (errors == 0)
		{
			System.out.println("This XML file was formatted correctly!");
		}
		else
		{
			System.out.println("This XML file was not formatted correctly!");
		}
	}
	
	public static void main(String args[])
	{
		SimpleXMLTester test = new SimpleXMLTester();
		
		Scanner inputFile = new Scanner(System.in);
		
		System.out.println("Welcome to the simple XML tester. Time to test simple XML's");
		System.out.println("Enter a file name:");
		
		String fileName = inputFile.nextLine();
		inputFile.close();
		
		try 
		{
			test.readFile(fileName);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found in source folder.");
		}
	}
}
