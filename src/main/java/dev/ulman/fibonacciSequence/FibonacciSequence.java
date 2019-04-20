package dev.ulman.fibonacciSequence;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciSequence {

	private BigInteger fibonacci(int n) {
		if (n == 0)
			return new BigInteger("0");
		if (n == 1 || n == 2)
			return new BigInteger("1");

		BigInteger prev = new BigInteger("0");
		BigInteger next = new BigInteger("1");
		BigInteger result = new BigInteger("0");
		for (int i = 1; i < n; i++) {
			result = prev.add(next);
			prev = next;
			next = result;
		}
		return result;
	}

	public void printFibonacciNthElement(int n) {
		System.out.println(n + "-th element of Fibonacci Sequens is " + fibonacci(n));
	}

	public void printNElementsOfFibanacci(int n) {
		for (int i = 0; i <= n; i++) {
			System.out.println("Element no." + i + " is " + fibonacci(i));
		}
	}

	public static void main(String[] args) {

		String exitPoint = "";
		int n = 0, option = 0;
		Scanner in = new Scanner(System.in);
		do {
			try {
				System.out.println("Give integer number: ");
				n = Integer.parseInt(in.next());
				do {
					System.out.println("N-th element choose 1\nAll elements choose 2");
					option = Integer.parseInt(in.next());
				} while (option != 1 && option != 2);

				if (option == 1)
					new FibonacciSequence().printFibonacciNthElement(n);
				if (option == 2)
					new FibonacciSequence().printNElementsOfFibanacci(n);

				System.out.println("exit? y/n");
				exitPoint = in.next();

			} catch (Exception e) {
				System.out.println("Input excepion " + e);
			}
		} while (!exitPoint.equals("y"));
		in.close();
	}

}
