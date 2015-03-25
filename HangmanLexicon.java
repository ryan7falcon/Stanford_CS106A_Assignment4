/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import java.util.*;
public class HangmanLexicon {

	public HangmanLexicon()
	{
		rd = openFile("HangmanLexicon.txt");
		getListFromBuffer();
	}
	
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return list.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return list.get(index);
	};
	
	/**Opens a file for reading*/
	private BufferedReader openFile(String filename)
	{
		BufferedReader rd = null;
		while (rd == null)
		{
			try {
				rd = new BufferedReader(new FileReader(filename));
			}
			catch (IOException ex) {
				throw new ErrorException("that file doesn't exists");
			}
		}
		
		return rd;
	}
	
	/**Reads strings from buffer to array list*/
	private void getListFromBuffer(){
		rd = openFile("ShorterLexicon.txt");	
		int i=0;
		try {
			while (true)
			{
				list.add(rd.readLine());
				if (list.get(i++) == null)
					break;
			}
			rd.close();
		}
		catch (IOException ex)
		{ 
			throw new ErrorException(ex);
		}
	}
	
	/*private instance variables*/
	private BufferedReader rd;
	ArrayList <String> list = new ArrayList<String>();
}
