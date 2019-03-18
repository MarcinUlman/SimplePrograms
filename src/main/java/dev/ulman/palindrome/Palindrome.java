package dev.ulman.palindrome;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Palindrome {

	public boolean isPalindrome(String text) {
		text = text.replaceAll("[^a-zA-Z]", "");
		String tempText = reverseString(text);
		return text.equalsIgnoreCase(tempText);
	}

	public String reverseString(String text) {
		StringBuilder reverseedString = new StringBuilder();
		for (int i = text.length() - 1; i >= 0; i--) {
			reverseedString.append(text.charAt(i));
		}
		return reverseedString.toString();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Palindrome palindrome = new Palindrome();
		StringBuilder text = new StringBuilder();

		try (Scanner in = new Scanner(new FileReader(new File(".").getCanonicalPath()
				+ "/src/main/resources/dev/ulman/palindrome/ZARTEM_W_METRAZ.txt"))) {
			while (in.hasNext()) {
				text.append(in.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (palindrome.isPalindrome(text.toString())) {
			System.out.println("Text is a Palindrone");
		} else {
			System.out.println("Text is NOT a Palindrom");
		}
	}

}
