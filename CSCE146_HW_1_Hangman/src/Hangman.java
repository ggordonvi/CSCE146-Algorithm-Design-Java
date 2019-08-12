import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class Hangman {
	
	//Member variables
	private char[] secretWord;
	private char[] disguisedWord;
	private int numGuesses;
	private int numIncorrectGuesses;
	private String[] dictionary;
	
	
	//Constructor
	public Hangman ()
	{

	}
	
	//Build dictionary
	public void loadDictionary (String fileName)
	{
		if (fileName == null)
			return;
		try 
		{
			Scanner inFile = new Scanner(new File(fileName));
			int arraySize = 0;
			while(inFile.hasNextLine())
			{
				inFile.nextLine();
				arraySize++;
			}
			if (arraySize <= 0)
			{
				inFile.close();
				return;
			}
			dictionary = new String[arraySize];
			inFile = new Scanner(new File(fileName));
			int currIndex = 0;
			while(inFile.hasNextLine())
			{
				String word = inFile.nextLine();
				dictionary[currIndex] = new String(word.toLowerCase());
				currIndex++;
			}
			inFile.close();
			//Check to see if dictionary loads correctly
			//for (int i = 0; i < dictionary.length; i++)
			//{
			//	if (i < 0)
			//	{
			//		System.out.println(", ");
			//	}
			//	System.out.println(dictionary[i]);
			//}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	//Accessors
	public String getSecretWord ()
	{
		if(secretWord != null)
			return new String(secretWord);
		else
			return null;
	}
	public String getDisguisedWord ()
	{
		if(disguisedWord != null)
			return new String(disguisedWord);
		else
			return null;
	}
	public int getNumGuesses ()
	{
		if(numGuesses >= 0)
			return numGuesses;
		else
			return -1;
	}
	public int getNumIncorrectGuesses ()
	{
		if(numIncorrectGuesses >= 0)
			return numIncorrectGuesses;
		else
			return -1;
	}
	
	//Pick a new word, reset values
	public void resetGame ()
	{
		Random rand = new Random();
		int pos = rand.nextInt(25143) + 0;
		//Take a random word from the dictionary
		String word = dictionary[pos];
		//Add word to char array
		secretWord = word.toCharArray();
		//Make disguised word
		disguisedWord = word.replaceAll(".", "?").toCharArray();
		//Reset guesses
		numGuesses = numIncorrectGuesses = 0;
	}
	
	//Checks user input character against secret word
	public boolean makeGuess (char guess)
	{
		boolean found = false;
		//Keep formality, lower case
		guess = Character.toLowerCase(guess);
		//Check guess to secret word, if yes then add letter to disguised word
		for (int i = 0; i < secretWord.length; i++)
		{
			if(secretWord[i] == guess && disguisedWord[i] == '?')
			{
				disguisedWord[i] = guess;
				found = true;
			}
		}
		//Add guesses
		numGuesses++;
		//If not found, add to incorrect guesses
		if (!found)
		{
			numIncorrectGuesses++;
		}
		//Return result
		return found;
	}
	
	//Returns true if the hidden word has been completely uncovered
	public boolean isFound ()
	{
		//Check to see if disguised word is completed
		for (int i = 0; i < disguisedWord.length; i++)
		{
			//If the word still isnt complete, return false
			if (disguisedWord[i] == '?')
			{
				return false;
			}
		}
		//Otherwise, the word has been completed
		return true;
	}
}
