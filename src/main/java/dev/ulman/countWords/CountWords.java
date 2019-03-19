package dev.ulman.countWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWords {

	public Map<String, Integer> countWords(String text, int minWoldLenth) {
		text = text.replaceAll("[^a-z A-Z ęóśłżźćńĘÓŚŁŻŹĆŃ]", "").toLowerCase();
		Map<String, Integer> wordsCounter = new HashMap<String, Integer>();
		String[] words = text.split(" ");

		for (String word : words) {
			if (word.length() > minWoldLenth) {
				if (wordsCounter.containsKey(word)) {
					int temp = wordsCounter.get(word) + 1;
					wordsCounter.put(word, temp);
				} else {
					wordsCounter.put(word, 1);
				}
			}
		}
		return wordsCounter;
	}

	public Map<String, Integer> sortMapByValues(Map<String, Integer> map) {

		Comparator<String> compar = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (map.get(o1) > map.get(o2)) {
					return -1;
				} else {
					return 1;
				}
			}
		};
		TreeMap<String, Integer> sortedMap = new TreeMap<>(compar);
		sortedMap.putAll(map);

		return sortedMap;
	}

	public static void main(String[] args) {
		int minWoldLenth = 5;
		StringBuilder text = new StringBuilder();
		try (Scanner in = new Scanner(new FileReader(new File(".").getCanonicalPath()
				+ "/src/main/resources/dev/ulman/countWords/AdamMickiewicz_PanTadeusz.txt"))) {
			while (in.hasNext()) {
				text.append(in.next()).append(" ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		CountWords wordsCounter = new CountWords();
		Map<String, Integer> map = wordsCounter.sortMapByValues(wordsCounter.countWords(text.toString(), minWoldLenth));
		System.out.println(map);

	}

}
