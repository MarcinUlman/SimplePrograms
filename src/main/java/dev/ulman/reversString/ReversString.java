package dev.ulman.reversString;

import java.util.Scanner;

public class ReversString {

	public String reversString(String text) {
		StringBuilder reversString = new StringBuilder();
		for (int i = text.length() - 1; i >= 0; i--) {
			reversString.append(text.charAt(i));
		}
		return reversString.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String text = in.next();
		in.close();

		ReversString revStr = new ReversString();

		System.out.println(revStr.reversString(text));

	}

}
