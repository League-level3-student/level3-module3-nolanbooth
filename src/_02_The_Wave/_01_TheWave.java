package _02_The_Wave;

import java.util.ArrayList;

public class _01_TheWave {
	/*
	 * Background: https://en.wikipedia.org/wiki/Wave_%28audience%29
	 * 
	 * Task: Your task is to create a function that turns a string into a Wave. You
	 * will be passed a string and you must return that string in an ArrayList where
	 * an uppercase letter is a person standing up. Example: wave("hello") =>
	 * "Hello", "hEllo", "heLlo", "helLo", "hellO"
	 * 
	 * 1. The input string will always be lower case but maybe empty. 2. If the
	 * character in the string is whitespace then pass over it as if it was an empty
	 * seat.
	 */

	public static ArrayList<String> wave(String str) {
		String withoutSpace = str.trim();
		//System.out.println(withoutSpace);	
		
		withoutSpace = withoutSpace.replace(" ", "");
		//System.out.println(withoutSpace);
		//System.out.println(withoutSpace.length());
		//System.out.println("Trimmed and spaces removed: " + withoutSpace);
		
		ArrayList<String> nooo = new ArrayList<String>();
		ArrayList<String> yesss = new ArrayList<String>();
		// making all the values the string value
		//System.out.println(withoutSpace.length()+1);
		for (int i = 0; i < withoutSpace.length()+1; i++) {
			nooo.add(str);
		}
		//System.out.println("Size of arraylist should be the length of withoutSpace. ArrayList: " + nooo.size()
		//		+ "  withoutSpace: " + withoutSpace.length());
		for (int i = 0; i < nooo.size()-1; i++) {
			if(nooo.get(i).charAt(i) != ' ') {
				String theWord = nooo.get(i);
				StringBuilder bob = new StringBuilder(theWord);
				
				//System.out.println(Character.toUpperCase(theWord.charAt(i)));
				
				bob.replace(i, i+1, Character.toUpperCase(theWord.charAt(i))+ "");
				theWord = bob.toString();
				
				//System.out.println(theWord);
				yesss.add(theWord);
			}
			
		}
		
		for(int i = 0; i < yesss.size(); i++) {
			System.out.println(yesss.get(i));
		}

		return yesss;
	}
}
