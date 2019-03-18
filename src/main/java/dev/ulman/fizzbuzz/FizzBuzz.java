package dev.ulman.fizzbuzz;

public class FizzBuzz {

	public String fizzBuzz(int i) {
		if (i % 3 == 0 && i % 5 == 0) {
			return "FizzBuzz";
		}

		if (i % 3 == 0) {
			return "Fizz";
		}
		
		if (i % 5 == 0) {
			return "Buzz";
		}
		return String.valueOf(i);
	}

	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz();
		for (int i = 0; i < 100; i++) {
			System.out.println(fizzBuzz.fizzBuzz(i));
		}
	}

}