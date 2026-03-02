package com.capgemini.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Calc2Test {
	
	Calc2 c;
	
	
	@BeforeEach
	void setup() {
		c = new Calc2();
	}

	@Test
	@DisplayName("Method to test division")
	void test() {
		int result = c.divide(1, 1);
		assertEquals(1, result);
		
	}

}
