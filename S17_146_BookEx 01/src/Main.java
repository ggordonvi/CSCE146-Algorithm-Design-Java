import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static void main (String[] args)
	{
		final String TAG = "Main: ";
		String fileName ="mydata";
		Scanner inFile = null;
		ArrayList<Record> phonebook = null;
		
		try
		{
			inFile = new Scanner(new File(fileName));
		}
		 catch (FileNotFoundException ex)
		{
			 System.out.println(TAG + "Error opening inFile " + fileName);
			 System.out.println(ex.getMessage());
			 System.out.println("in " + System.getProperty("user.dir"));
			 System.out.flush();
			 System.exit(1);
		}
		
		phonebook = new ArrayList<Record>();
		while (inFile.hasNext())
		{
			Record rec = new Record();
			rec.readRecord(inFile);
			phonebook.add(rec);
		}
		
		for (int i = 0; i < phonebook.size(); i++)
		{
			System.out.println(phonebook.get(i));
		}
		System.out.println("Record count: " + phonebook.size());
		
		inFile.close();
	}
}
