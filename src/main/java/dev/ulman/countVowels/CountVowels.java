package dev.ulman.countVowels;

import java.util.HashMap;
import java.util.Map;

public class CountVowels {

	private String vowels = "euioaEUIOA";

	public Map<Character, Integer> coutVowels(String text) {
		Map<Character, Integer> counterdVowels = new HashMap<Character, Integer>();

		for (int i = 0; i < text.length(); i++) {
			Character c = text.charAt(i);
			if (isVowel(c)) {
				if (counterdVowels.containsKey(c)) {
					int temp = counterdVowels.get(c) + 1;
					counterdVowels.put(c, temp);
				} else {
					counterdVowels.put(c, 1);
				}
			}
		}
		return counterdVowels;
	}

	public boolean isVowel(char c) {
		return (vowels.indexOf(c) != -1);
	}

	public static void main(String[] args) {
		CountVowels cv = new CountVowels();
		String text = "mama ola tata";
		System.out.println(cv.coutVowels(text));
	}
}
