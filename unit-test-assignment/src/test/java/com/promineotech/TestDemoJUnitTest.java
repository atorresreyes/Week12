package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoJUnitTest {

	// add a private instance variable of type TestDemo named testDemo.  
	//Remember that instance variables are non-static variables which are defined in a class,
	//but outside of any method, constructor or a block.
	private TestDemo testDemo;
	
	
	//In the setUp() method, create the TestDemo object. 
	//This will ensure that a new TestDemo object is created before each test. 
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	
	//  Change "@Test" to "@ParameterizedTest". 
	//Add the import statement for org.junit.jupiter.params.ParameterizedTest

	@ParameterizedTest
	// Just below the @ParameterizedTest annotation, add the annotation @MethodSource. Pass a single parameter to @MethodSource. It must be the fully-qualified (includes package) class name of the test followed by a # sign followed by the name of the method that supplies the parameters. Remember that the test is in the com.promineotech package. So, the package name needs to be in the following annotation:
	//package.Class#name of method
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	//Change the name of method "test" to "assertThatTwoPositiveNumbersAreAddedCorrectly". 
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		// remove the "fail("Not yet implemented");"
		
		//Test the value of expectException. 
		//If it is false, assert that when TestDemo.addPositive is called with values a and b,
		//that the result is the same as the parameter expected. 
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			
		// Add the test for the thrown exception in an else clause. 
			//Use assertThatThrownBy for this. 
		// As a parameter to assertThatThrownBy, 
			//add a Lambda expression with no parameters. 
			//The Lambda body should be the method call to testDemo.addPositive. 
		// Use the assertion isInstanceOf(IllegalArgumentException.class) 
			//to ensure that the correct exception is thrown. 
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class); 
			}
		}
	
	@Test 
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
		assertThat(testDemo.addPositive(1, 2)).isEqualTo(3);
	}
	
		
	static Stream<Arguments> argumentsForAddPositive() {
		// method should return a Stream.of()
		// formatter: off
		return Stream.of(
				// So, if you are adding 2 and 4 to get the value of 6 and are not expecting an exception, you need to do: 
				arguments(2, 4, 6, false),
				arguments(0, 5, 5, true),
				arguments(2, -1, 1, true)
				);
	}
	
	// Testing for addStarsToWordsInList
	// Testing to see if when given a list of words, when the method is called, 
		// then a list is returned with the same words but with * added to both sides of each word
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddStarsToWordsInList")
	void assertThatStarsAreAdded(List<String> given, List<String> expected) {
			assertThat(testDemo.addStarsToWordsInList(given)).isEqualTo(expected);
		}
	
	static Stream<Arguments> argumentsForAddStarsToWordsInList() {
		// @formatter: off
		return Stream.of(
				arguments(List.of("hi"), List.of("*hi*")),
				arguments(List.of("sun", "moon", "star"), List.of("*sun*", "*moon*", "*star*")),
				arguments(List.of(), List.of())
				);
		// @formatter: on
	}
	
	
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	

	
	
}
