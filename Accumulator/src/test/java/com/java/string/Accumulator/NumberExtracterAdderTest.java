package com.java.string.Accumulator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit test for NumberExtracterAdder.
 */
public class NumberExtracterAdderTest {
	@InjectMocks
	NumberExtracterAdder adder;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddSuccessScenerioEmptyString() throws NegativeNumberException {
		int acutalResult = adder.add("");
		int expectedResult = 0;
		assertTrue(acutalResult == expectedResult);
	}

	@Test
	public void testAddSuccessScenerioOneString() throws NegativeNumberException {
		int acutalResult = adder.add("1");
		int expectedResult = 1;
		assertTrue(acutalResult == expectedResult);
	}

	@Test
	public void testAddSuccessScenerioTwoString() throws NegativeNumberException {
		int acutalResult = adder.add("1,2");
		int expectedResult = 3;
		assertTrue(acutalResult == expectedResult);
	}

}
