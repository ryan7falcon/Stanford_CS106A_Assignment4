import java.io.BufferedReader;

import acm.program.*;
import acm.util.*;
import java.io.*;

public class ReadFile extends ConsoleProgram{
	
	public void run()
	{
		BufferedReader rd = openFile("Please enter a filename: ");
		
		try {
			while (true)
			{
				String line = rd.readLine();
				if (line == null)
					break;
				println("Read line: [" + line + "]");
			}
			rd.close();
		}
		catch (IOException ex)
		{ 
			throw new ErrorException(ex);
		}
	}
	
	private BufferedReader openFile(String prompt)
	{
		BufferedReader rd = null;
		while (rd == null)
		{
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));
			}
			catch (IOException ex) {
				println("that file doesn't exists");
			}
		}
		
		return rd;
	}
}
