package com.promineotech;

import java.util.List;
import java.util.Random;

public class TestDemo {

	// create an instance method (not static) named addPositive. 
	//take two int parameters and return an int
	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		} else {
			return a + b;
		}
	}	
	
	//each word in a list will have a * added to both sides of the word
	public List<String> addStarsToWordsInList(List<String> listOfWords) {
		return listOfWords.stream()
				.map((String word) -> {return "*" + word + "*"; })
				.toList();
	}
		
	public int randomNumberSquared() {
	//obtains random int between 1 and 10 and then returns the square of the number
		int squaredNumber = getRandomInt();
		return squaredNumber * squaredNumber;
	}
		
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	
} // end public class TestDemo
