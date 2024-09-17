package com.knowthyselfweb.Know_Thyself_WEB.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.knowtheyselfweb.Know_Thyself_WEB.models.*;

@Service
public class StoryTrackerService {
	// TODO implement achievement system into this version
	//final static AccomplishmentTracker TRACKER = new AccomplishmentTracker(AccomplishmentBuilder.copStoryAccomps);
	//final static List<Scenario> STORY_SCENES = ScenarioBuilder.copStory;
	
	// Keeps track of the choices made and scenarios experienced
	static List<String> userTags = new ArrayList<String>();
			
	// Keeps track of points earned for each alignment, where the index is represented by the Alignment enum
	static Integer[] chart = new Integer[] {0,0,0,0,0,0,0,0,0};
	
	// String representations of each alignment.
	final static String[] alignments = new String[] {
			"LG", "NG", "CG", "LN", "TN", "CN", "LE", "NE", "CE" };
	
	final static String[] alignmentsFull = new String[] {
			"Lawful Good", "Neutral Good", "Chaotic Good", 
			"Lawful Neutral", "True Neutral", "Chaotic Neutral", 
			"Lawful Evil", "Neutral Evil", "Chaotic Evil" };
	
	// Game vars
	List<Scenario> curStory;
	boolean end = false;
	//String endingId = "";
	int index;	
	
	// Per Scenario vars
	Scenario 	 curScene;
	List<Option> availOptions;
	
	Option chosenOp;
	String nextSceneID;
	boolean onlyTransition = false;
	
	public StoryTrackerService( ArrayList<Scenario> scenes) {
		curStory = scenes;
		index = 0;
		curScene = curStory.get(0);
		availOptions = curScene.getOptions();
		onlyTransition = false;
	}
	
	public Scenario GetCurrentScene() {
		return curScene;
	}
	
	public List<Option> GetAvailOptions() {
		return availOptions;
	}
	
	public boolean IsStoryOver() {
		return end;
	}
	
	public boolean IsOnlyTransition() {
		return onlyTransition;
	}
	
	public void NextScene(int optionIndex) {
		
		// Store chosen option and where to go next
		chosenOp = availOptions.get(optionIndex);
		nextSceneID = chosenOp.getPointsToID();
		
		// Store  option values to keep track of if not transition
		if(!onlyTransition) {
			
			if(chosenOp.getTagsRequired() != null) {
				//accomps.addAchievement(chosenOp.getTagsRequired().get(0));
			}
			
			if(chosenOp.getTags() != null) 
				AddTagsToUser(chosenOp.getTags());
			
			if(chosenOp.getAlignment() != null)
				IncrementAlignment(chosenOp.getAlignment()); // If -1 is returned there is a problem!
			
			// TODO display this differently somehow
			if(chosenOp.getResultDesc() != "")
				System.out.println("\n" + chosenOp.getResultDesc() + "\n");
			
		}
		
		// Change scenario
		int tempInd = index;
		if(!nextSceneID.equals("")) {
			for(int i = index; i < curStory.size(); i++) {
				if(curStory.get(i).getId().equals(nextSceneID)) {
					index = i;
					curScene = curStory.get(index);
					break;
				}
			}
		}
		
		/* Don't end the game if there is a tie of alignments! 
		 * Instead, the game must play through the final and special tie breaker scenario 
		 * (stored in the last spot of the scenes list)
		 */
		if(tempInd == index && index != curStory.size() - 1 && CheckForAlignTies()) {
			index = curStory.size() - 1;
			curScene = curStory.get(index);
		}
		// End if the index did not change
		end = tempInd == index;
		//endingId = curScene.getId();

		if(end) {
			onlyTransition = true;
			availOptions = null;
			return;
		}

		// Fetch options, and check if these are transition options
		// there SHOULDN'T be any non-transitional options if the first option is
		for(Option op : curScene.getOptions()) {
			
			// Transition option
			// Empty tags on transition option means this is the only option anyway
			boolean conditionsMet = op.getTagsRequired() == null || DoesUserTagsContains(op.getTagsRequired());
			if(!op.isShown() && conditionsMet) 
			{
				availOptions.add(op);
				onlyTransition = true;
				break;
			}
			// Regular options
			else if(conditionsMet) {
				availOptions.add(op);
				onlyTransition = false;
			}				
		}
	}
	
	/* Uses int value of Alignment enum to increment chart score.
	 * Success: return 1 else -1 */
	private static int IncrementAlignment(Alignment align) {
		
		if(align == null)
			return -1;
		
		chart[align.ordinal()]++; 
		return 1;
	}
	
	// Iterates through chart array to search for ties in values
	// Adds associated alignment tie tags to userTags if ties
	// This will be used to know which of tie breaker scenario options should be available at the end of the game.
	private static boolean CheckForAlignTies() {
		
		// Get max alignment score
		int max = 0;
		for(int i = 0; i < chart.length; i++) {
			if(chart[i] > max) {
				max = chart[i];
			}
		}
		
		List<String> ties = new ArrayList<String>();
		// Loop again to find any ties and store their alignment.
		for(int i = 0; i < chart.length; i++) {
			if(chart[i] == max) {
				ties.add("tie_" + alignments[i]);
			}
		}
		
		// If there are ties, add the appropriate tie tag for each tied alignment
		if(ties.size() < 2) 
			return false;
		
		for(String s : ties) { userTags.add(s); }
		return true;
	}
	
	private static boolean DoesUserTagsContains(List<String> tags) {
		
		for(String tag : tags) {
			if(!userTags.contains(tag))
				return false;
		}
		return true;
	}
	
	private static void AddTagsToUser(List<String> tags) {
		
		for(String tag : tags) {
			userTags.add(tag);
		}
	}	
	
	// These methods are only for easily getting a list of ending and tag string without having to do it manually. 
	//{~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static List<String> getEndings(List<Scenario> scenes) {
		List<String> ends = new ArrayList<String>();
		
		// Scenarios are endings when they have null options
		for(int i = scenes.size() -1; i >= 0; i--) {
			
			if(scenes.get(i).getOptions() != null) {continue;}
			
			ends.add(scenes.get(i).getId());
			
		}
		System.out.println(ends);
		return ends;
	}
	
	public static List<String> getSecretOptions(List<Scenario> scenes) {
		List<String> ops = new ArrayList<String>();
		
		// Secret option tags are from options required tags list that are shown and aren't in the tie breaker
		for(int i = 0; i < scenes.size() -2; i++) {
			Scenario curScene = scenes.get(i);
			
			if(curScene.getOptions() == null) {continue;}
				
			for(Option o : curScene.getOptions()) {
				
				if(o.getTagsRequired() == null || !o.isShown()) {continue;}
				
				ops.addAll(o.getTagsRequired());
			}
		}
		System.out.println(ops);
		return ops;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~}	
	
	
	
	private static void PlayScenario(List<Scenario> scenes) {
		
		while(true) {
			// Game vars
			boolean end = false;
			String endingId = "";
			int index   = 0;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			
			
			// Introduction
			System.out.println("Welcome to Know Thyself, Terminal Edition! \n\nYou will be playing through a short story "
					+ "and given options to progress as you like. This will appear as a description of what is happening "
					+ "followed by numbered options. \nAll you have to do is enter the number of the option you wish to choose! "
					+ "\nThen, at the end of the game, you will be given an Alignment that best describes the choices you have made. "
					+ "\nIf you somehow are a \"well rounded person\", an alignment tie-breaker scenario will be provided to make sure you "
					+ "get a specific alignment. \nThis is by no means an accurate experience, it is all just for fun! "
					+ "\n\nPlease enter anything to begin.");
			
			
			
			// Scenario vars
			Scenario 	 curScene;
			List<Option> availOptions;
			Option chosenOp;
			String nextSceneID;
			boolean onlyTransition;
		
			while(!end) {
				curScene 	   = scenes.get(index);
				availOptions   = new ArrayList<Option>();
				chosenOp       = null;
				nextSceneID    = "";
				onlyTransition = false;
				
				// Print info
				System.out.println(curScene.getDesc());
				
				// No options means end of story has been reached
				if(curScene.getOptions() != null) {
					// Fetch options, and check if these are transition options
					// there SHOULDN'T be any non-transitional options if the first option is
					for(Option op : curScene.getOptions()) {
						
						// Transition options, one option is automatically selected, no list required
						// Get option PointsID where conditions are met, or if there are no conditions
						// Empty tags on transition option means this is the only option anyway
						boolean conditionsMet = op.getTagsRequired() == null || DoesUserTagsContains(op.getTagsRequired());
						if(!op.isShown() && conditionsMet) 
						{
							nextSceneID = op.getPointsToID();
							onlyTransition = true;
							break;
						}
						// Regular options
						else if(conditionsMet){
							availOptions.add(op);
						}				
					}
				}
				else { onlyTransition = true; } 
				
				// User needs to choose an option, if applicable
				if(!onlyTransition) {
					
					int ind = 0;
					// Print available options
					for(Option op : availOptions) {
						ind++;
						System.out.println(ind + ". " + op.getDesc());
					}
					
					int input = -1;
					// Input and validation
					while(input < 0) {
						
						System.out.println("\nPlease enter a valid number associated with the above options.");
						//TODO input entry way
					}
					// Store chosen option and its values
					chosenOp = availOptions.get(input);
					
					nextSceneID = chosenOp.getPointsToID();
					
					if(chosenOp.getTagsRequired() != null) {
						//accomps.addAchievement(chosenOp.getTagsRequired().get(0));
					}
					
					if(chosenOp.getTags() != null) 
						AddTagsToUser(chosenOp.getTags());
					
					if(chosenOp.getAlignment() != null)
						IncrementAlignment(chosenOp.getAlignment()); // If -1 is returned there is a problem!
					
					if(chosenOp.getResultDesc() != "")
						System.out.println("\n" + chosenOp.getResultDesc() + "\n");
					
				}
				// User's choice has been determined already, this is a transition to the next scene
				else {
					System.out.println("\nPlease enter anything to continue");
					// TODO input entry way
				}
				
				// Change scenario
				int tempInd = index;
				if(!nextSceneID.equals("")) {
					for(int i = index; i < scenes.size(); i++) {
						if(scenes.get(i).getId().equals(nextSceneID)) {
							index = i;
							break;
						}
					}
				}
				
				/* Don't end the game if there is a tie of alignments! 
				 * Instead, the game must play through the final and special tie breaker scenario 
				 * (stored in the last spot of the scenes list)
				 */
				if(tempInd == index && index != scenes.size() - 1 && CheckForAlignTies()) 
					index = scenes.size() - 1;
	
				// End if the index did not change
				end = tempInd == index;
				endingId = curScene.getId();
			}
			// TODO entry point for results page
			//accomps.addAchievement(endingId);
			
			System.out.println("Story ended!\n");
			
			System.out.println("You're alignment is... ");
			
			// Get max alignment score
			int max = 0;
			int indexOfMaxAlign = 0;
			for(int i = 0; i < chart.length; i++) {
				if(chart[i] > max) {
					max = chart[i];
					indexOfMaxAlign = i;
				}
			}
			
			// Print alignment and short descriptor
			String playerAlign = alignmentsFull[indexOfMaxAlign];
			String msg = "";
			//accomps.addAlignment(playerAlign);
			
			System.out.print(playerAlign + ". This means you ");
			
			switch(playerAlign) {
			case "Lawful Good"    :
				msg = "stick to your strong values which includes putting others first.";
				break;
			case "Neutral Good"   :
				msg = "put others first as best as you can.";
				break;
			case "Chaotic Good"   :
				msg = "do whatever you like but still put others first.";
				break;
			case "Lawful Neutral" :
				msg = "believe rules are what keeps everything functioning.";
				break;
			case "True Neutral"   :
				msg = "don't have very strong opinions other than you prefer your life to be pleasant.";
				break;
			case "Chaotic Neutral": 
				msg = "value freedom above all else.";
				break;
			case "Lawful Evil"    :
				msg = "stick to your strong values, stepping on whomever gets in your way.";
				break;
			case "Neutral Evil"   :
				msg = "believe you are better than most, if not all people.";
				break;
			case "Chaotic Evil"   :
				msg = "believe you can get away with anything you want, when you want.";
				break;
			}
			System.out.print(msg + "\n\nEnter anything to see your accomplishments.\n");
			
			
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~Results~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
			
			//accomps.printAllObtainedAchievements();
			//accomps.printAllRatios();
			
			System.out.println("\nThanks for playing! :) "
					+ "You may now enter anything to play again or if you are done: type \"exit\" or close the terminal.");
			
			
		}
	}
	
	public void reset() {
		end = false;
		chart = new Integer[] {0,0,0,0,0,0,0,0,0};
		userTags.clear();
	}
}
