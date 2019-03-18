package dev.ulman.fizzbuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

	FizzBuzz fizzBuzz;
	
	@Before
	public void setUp() {
		fizzBuzz = new FizzBuzz();
	}

	@Test
	public void testFizz() {
		Assert.assertEquals("Fizz", fizzBuzz.fizzBuzz(3));
	}
	
	@Test
	public void testNoFizz() {
		Assert.assertNotEquals("Fizz", fizzBuzz.fizzBuzz(4));
	}
	
	@Test
	public void testBuzz() {
		Assert.assertEquals("Buzz", fizzBuzz.fizzBuzz(5));
	}
	
	@Test
	public void testNoBuzz() {
		Assert.assertNotEquals("Buzz", fizzBuzz.fizzBuzz(4));
	}
	
	@Test
	public void testFizzBuzz() {
		Assert.assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15));
	}
	
	@Test
	public void testNoFizzBuzz() {
		Assert.assertNotEquals("FizzBuzz", fizzBuzz.fizzBuzz(4));
	}
	
	@Test
	public void testFizzForAllScope() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 != 0) {
				Assert.assertEquals("Fizz", fizzBuzz.fizzBuzz(3));
			}
		}
	}

	@Test
	public void testBuzzForAllScope() {
		for (int i = 1; i <= 100; i++) {
			if (i % 5 == 0 && i % 3 != 0) {
				Assert.assertEquals("Buzz", fizzBuzz.fizzBuzz(i));
			}
		}
	}

	@Test
	public void testFizzBuzzForAllScope() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				Assert.assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(i));
			}
		}
	}

	@Test
	public void testNumberPrint() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 != 0 && i % 5 != 0) {
				Assert.assertEquals(i + "", fizzBuzz.fizzBuzz(i));
			}
		}
	}

}
