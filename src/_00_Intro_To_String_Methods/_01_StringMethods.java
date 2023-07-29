package _00_Intro_To_String_Methods;

import java.util.ArrayList;
import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		} else {
			return s2;
		}

	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {
		String sss = "";
		if (s.contains("underscores")) {
			sss = s.replace(' ', '_');

		} else {
			sss = s;
		}

		return sss;
	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {

		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();
		String[] s11 = s1.split(" ");
		String[] s22 = s2.split(" ");
		String[] s33 = s3.split(" ");

		String originalFirst = s1;
		String originalSecond = s2;
		String originalThird = s3;

		s1 = s11[1];
		s2 = s22[1];
		s3 = s33[1];
		String[] lastNames = { s1, s2, s3 };
		for (int i = 0; i < lastNames.length; i++) {
			// System.out.println(lastNames[i]);
		}

		for (int i = 0; i < lastNames.length; i++) {
			for (int k = 0; k < lastNames.length - 1; k++) {
				if (lastNames[k].compareToIgnoreCase(lastNames[k + 1]) > 0) {
					String bucket = lastNames[k];
					lastNames[k] = lastNames[k + 1];
					lastNames[k + 1] = bucket;

				}
			}
		}

		for (int i = 0; i < lastNames.length; i++) {
			// System.out.println(lastNames[i]);
		}
		String theGuy = "";
		for (int i = 0; i < lastNames.length; i++) {
			if (lastNames[0].equals(s1)) {
				theGuy = originalFirst;
			}
			if (lastNames[0].equals(s2)) {
				theGuy = originalSecond;
			}
			if (lastNames[0].equals(s3)) {
				theGuy = originalThird;
			}
		}
		// System.out.println(theGuy);

		return theGuy;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int addition = 0;
		int newNumber = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				String a = s.charAt(i) + "";
				newNumber = 0;
				newNumber = Integer.parseInt(a);
				addition = addition + newNumber;

			}
		}

		// System.out.println(addition);
		return addition;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int subLength = substring.length();
		int count = 0;
		for (int i = 0; i < (s.length() - subLength) + 1; i++) {
			String chunk = s.substring(i, i + subLength);
			if (chunk.equalsIgnoreCase(substring)) {
				count++;
			}
			System.out.println(chunk);
		}

		return count;
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {
		byte[] array = s.getBytes();

		byte copy = (byte) key;

		return Utilities.encrypt(array, copy);
	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {
		byte copy = (byte) key;

		return Utilities.decrypt(s, copy);

	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		String[] substrings = s.split(" ");
		int count = 0;
		for (int i = 0; i < substrings.length; i++) {
			String word = substrings[i];
			// word is now equal to a word
			// must check if word ends with substring
			if (word.endsWith(substring)) {
				count++;
			}

		}

		return count;
	}

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int subLength = substring.length();
		int beginning = 0;
		System.out.println("Searching for Distance Between Substrings");
		bill: for (int i = 0; i < (s.length() - subLength) + 1; i++) {
			String chunk = s.substring(i, i + subLength);
			if (chunk.equalsIgnoreCase(substring)) {
				beginning = i+subLength;
				System.out.println(chunk);
				break bill;
			}
			
		}
		return 0;
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
	}
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a
	// single byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
