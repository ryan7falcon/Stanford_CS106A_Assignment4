/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		this.removeAll();
		drawScaffold();
		wrongGuess="";
		guesses = 8;
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		
		if(guessWord!=null)
			remove(guessWord);
		guessWord = new GLabel(word, 40, getHeight()/4*3 + LEG_LENGTH/2); 
		guessWord.setFont("sans-20");
		add(guessWord);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		if (wrongGuessLabel!=null)
			remove(wrongGuessLabel);
		wrongGuess+= letter;
		wrongGuessLabel = new GLabel(wrongGuess, 40, getHeight()/4*3 + LEG_LENGTH/2 + 50); 
		wrongGuessLabel.setFont("sans-14");
		add(wrongGuessLabel);
		guesses--;
		switch (guesses)
		{
			case 7:
				add(head);
				break;
			case 6:
				add(body);
				break;
			case 5:
				add(leftShoulder);
				add(leftArm);
				break;
			case 4:
				add(rightShoulder);
				add(rightArm);
				break;
			case 3:
				add(leftHip);
				add(leftLeg);
				break;
			case 2:
				add(rightHip);
				add(rightLeg);
				break;
			case 1:
				add(leftFoot);
				break;
			case 0:
				add(rightFoot);
				break;
		}
		
		
	}

	private void drawScaffold()
	{
		scaffold = new GLine (getWidth()/2 - BEAM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS * 2 - ROPE_LENGTH, getWidth()/2 - BEAM_LENGTH , getHeight()/2 - BODY_LENGTH - HEAD_RADIUS * 2 - ROPE_LENGTH + SCAFFOLD_HEIGHT);
		beam = new GLine (getWidth()/2 - BEAM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS * 2 - ROPE_LENGTH, getWidth()/2 ,getHeight()/2 - BODY_LENGTH - HEAD_RADIUS * 2 - ROPE_LENGTH);
		rope = new GLine (getWidth()/2,getHeight()/2 - BODY_LENGTH - HEAD_RADIUS * 2 - ROPE_LENGTH,getWidth()/2, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS * 2);
		head = new GOval(getWidth()/2 - HEAD_RADIUS, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS * 2, HEAD_RADIUS * 2, HEAD_RADIUS * 2); 
		body = new GLine (getWidth()/2, getHeight()/2 - BODY_LENGTH, getWidth()/2, getHeight()/2);
		leftShoulder = new GLine (getWidth()/2 - UPPER_ARM_LENGTH,  getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD, getWidth()/2, getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD);
		leftArm = new GLine (getWidth()/2 - UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD, getWidth()/2 - UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		rightShoulder = new GLine (getWidth()/2 + UPPER_ARM_LENGTH,  getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD, getWidth()/2, getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD);
		rightArm = new GLine (getWidth()/2 + UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD, getWidth()/2 + UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		leftHip = new GLine (getWidth()/2, getHeight()/2, getWidth()/2 - HIP_WIDTH/2, getHeight()/2);
		rightHip = new GLine (getWidth()/2, getHeight()/2, getWidth()/2 + HIP_WIDTH/2, getHeight()/2);
		leftLeg = new GLine (getWidth()/2 - HIP_WIDTH/2, getHeight()/2, getWidth()/2 - HIP_WIDTH/2, getHeight()/2 + LEG_LENGTH);
		rightLeg = new GLine (getWidth()/2 + HIP_WIDTH/2, getHeight()/2, getWidth()/2 + HIP_WIDTH/2, getHeight()/2 + LEG_LENGTH);
		leftFoot = new GLine (getWidth()/2 - HIP_WIDTH/2, getHeight()/2 + LEG_LENGTH, getWidth()/2 - HIP_WIDTH/2 - FOOT_LENGTH, getHeight()/2 + LEG_LENGTH);
		rightFoot = new GLine (getWidth()/2 + HIP_WIDTH/2, getHeight()/2 + LEG_LENGTH, getWidth()/2 + HIP_WIDTH/2 + FOOT_LENGTH, getHeight()/2 + LEG_LENGTH);
		add(scaffold);
		add(beam);
		add(rope);
		
		
		
		
		
		
		
		
	}
/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 260;
	private static final int BEAM_LENGTH = 114;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 18;
	private static final int BODY_LENGTH = 100;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 36;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 80;
	private static final int FOOT_LENGTH = 28;

/*private instance variables*/
	private GLabel guessWord;
	private GLabel wrongGuessLabel;
	private String wrongGuess = "";
	private GLine scaffold;
	private GLine beam;
	private GLine rope;
	private GOval head;
	private GLine body;
	private GLine leftArm;
	private GLine rightArm;
	private GLine leftShoulder;
	private GLine rightShoulder;
	private GLine leftHip;
	private GLine rightHip;
	private GLine leftLeg;
	private GLine rightLeg;
	private GLine leftFoot;
	private GLine rightFoot;
	private int guesses = 8;
}
