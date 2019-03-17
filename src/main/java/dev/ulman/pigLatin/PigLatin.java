package dev.ulman.pigLatin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PigLatin {

	private String vowels = "euioaEUIOA";
	private String sufixAY = "ay";
	private String sufixWAY = "way";

	public String makeLatin(String orginalText) {
		if (orginalText.isEmpty()) {
			return " ";
		}
		String[] words = orginalText.split(" ");

		StringBuilder translatedText = new StringBuilder();

		for (String word : words) {
			translatedText.append(translate(word)).append(" ");
		}
		return translatedText.toString();
	}
	
	public String translate(String word) {
		char firstChar = word.charAt(0);
		if (!((firstChar >= 65 && firstChar <= 90) || (firstChar >= 97 && firstChar <=122))){
			throw new IllegalArgumentException();
		}
		if (vowels.indexOf(firstChar) != -1) {
			return vowelsTranslate(word);
		} else {
			char secendChar = word.charAt(1);
			if (vowels.indexOf(secendChar) != -1) {
				return consonantTranslate(word);
			} else {
				return clustersTranslate(word);
			}
		}
	}

	public String clustersTranslate(String word) {
		StringBuilder translatedWord = new StringBuilder(word.substring(2));
		translatedWord.append(word.substring(0, 2)).append(sufixAY);
		return translatedWord.toString();
	}

	public String consonantTranslate(String word) {
		StringBuilder translatedWord = new StringBuilder(word.substring(1));
		translatedWord.append(word.charAt(0)).append(sufixAY);
		return translatedWord.toString();
	}

	public String vowelsTranslate(String word) {
		return word + sufixWAY;
	}

	public static void main(String[] args) throws IOException {

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		System.out.println("enter text:");
		String text = br.readLine();

		PigLatin pigLarin = new PigLatin();
		String latinText = pigLarin.makeLatin(text);
		System.out.println(latinText);
	}
}
