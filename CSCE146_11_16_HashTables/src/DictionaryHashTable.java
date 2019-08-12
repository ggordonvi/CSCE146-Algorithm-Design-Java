import java.util.*;

public class DictionaryHashTable {
	
	private class WordAndDef
	{
		private String word;
		private String def;
		
		public WordAndDef (String aWord, String aDef)
		{
			word = aWord;
			def = aDef;
		}
	}
	
	private ArrayList<WordAndDef>[] table;
	private static final int CAP_A = 'A';
	
	public DictionaryHashTable()
	{
		table = new ArrayList[26];
		
		for (int i = 0; i < table.length; i++)
		{
			table[i] = new ArrayList<WordAndDef>();
		}
	}
	
	/*
	 * All characters are integers
	 * A - A = 0, and so on.
	 */
	private int calcIndex (String aWord)
	{
		return aWord.toUpperCase().charAt(0) - CAP_A;
	}
	
	public void add (String aWord, String aDef)
	{
		WordAndDef newWord = new WordAndDef(aWord,aDef);
		table[calcIndex(aWord)].add(newWord);
	}
	
	public String lookUp(String aWord)
	{
		int index = calcIndex(aWord);
		for(WordAndDef word : table[index])
		{
			if (word.word.equals(aWord))
			{
				return word.def;
			}
		}
		return null;
	}

}
