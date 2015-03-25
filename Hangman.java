/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */


import acm.program.*;
import acm.util.*;



public class Hangman extends ConsoleProgram {
	
/**Game states*/
	private static final int NEW_GAME = 0;
	private static final int PLAY = 1;
	private static final int WIN = 2;
	private static final int LOOSE = 3;
	
	public static void main(String[] args)
	{
		new Hangman().start(args);
	}
	
    public void run() {
    	
    	while(true)
    	{
    		/**prepares a new game*/
    		setup();
    		
    		/**plays a game*/
    		while(gameState == PLAY)
    			play();
    		
    		/**messages if game is won or lost*/
    		gameOverMessage();
    		
    		/**waits for user to start a new game*/
    		readLine("press Enter to start a new game.");
    	}
	}
    
    /**prepares a new game*/
    private void setup()
    {
    	canvas.reset();
    	println("Welcome to Hangman!");
    	guesses = 8;
    	chooseWord();
    	makeSecret();
    	gameState = PLAY;
    }
    
    /**adds a canvas*/
    public void init()
    {
    	canvas = new HangmanCanvas ();
    	add(canvas);
    }
    
    /**plays a game*/
    private void play()
    {
    	
    	/**updates state info*/
    	canvas.displayWord(secret);
    	println("The word now looks like this: " + secret);
    	if (guesses == 1)
			println("You have only one guess left.");
    	else
    	println("You have " + guesses + " guesses left"); 
    	
    	/**prompts a guess*/
    	while (true)
    	{
    		String guessStr = readLine("Your guess: ");
    		if ((guessStr.length() > 1)||(guessStr.length() == 0))
    			{println("Enter only ONE letter");}
    		else
    		{
    			guessChar = guessStr.charAt(0);
    			if (!Character.isLetter(guessChar))
    			{
    				println("Enter only one LETTER");
    			}
    			else
    				{
    					checkGuess();
    					break;
    				}
    		}
    	}
    	
    	/**Checks if the game is over*/
    	if (secret.equals(word))
    		gameState = WIN;
    	if (guesses == 0)
    		gameState = LOOSE;
    }
    
    /**Chooses a word from lexicon*/
    private void chooseWord()
    {
    	word = lex.getWord(rgen.nextInt(lex.getWordCount()));
    }
    
    /**Makes dashes from word*/
    private void makeSecret()
    {
    	secret = "";
    	for (int i = 0; i < word.length(); i++)
    		secret += "."; 
    }

    /**returns index of the guess char in the word*/
    private void checkGuess()
    {
    	/**Converts a char to upper case*/
    	if (Character.isLowerCase(guessChar))
			guessChar = Character.toUpperCase(guessChar);
    	
    	int index = word.indexOf(guessChar);
    	
    	/**if a char is in the word, update in in the secret(replace that dash)*/
    	if (index >= 0)
    	{
    		secret = secret.substring(0, index) + guessChar + secret.substring(index+1);
    		
    		/**looks for that char in the rest of the word*/
    		while (true)
    			{
    			index = word.indexOf(guessChar, index+1);
    			if (index >= 0)
    				secret = secret.substring(0, index) + guessChar + secret.substring(index+1);
    			else break;
    			}
    		println("That guess is correct.");
       	}
    	/**if there is no such char in the word, reduce the number of guesses left*/ 
    	else 
    	{	
    		canvas.noteIncorrectGuess(guessChar);
    		println("There is no " + guessChar + "'s in the word.");
    		guesses--;
    	}
    }
    
    /**messages the end of the game*/
    private void gameOverMessage()
    {
    	canvas.displayWord(word);
    	if (gameState == WIN)
		{
			println("You guessed the word " + word + ".");
			println("You win.");
		}
		else
		{
			println("You are completely hung.");
			println("The word was " + word + ".");
			println("You loose.");
			println("try again");
		}
    }
   
    /*private instance variables*/
    private RandomGenerator rgen = new RandomGenerator();
    HangmanLexicon lex = new HangmanLexicon();
    private int guesses;
    private String word;
    private String secret;
    private char guessChar;
    private int gameState = NEW_GAME;
    private HangmanCanvas canvas;
}
