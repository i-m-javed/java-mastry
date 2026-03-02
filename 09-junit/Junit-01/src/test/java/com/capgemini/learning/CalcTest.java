package com.capgemini.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalcTest {

    public Calc c;

    @BeforeEach
    @DisplayName("Setup")
    void setup() {
        c = new Calc();
    }

    @Test
    @DisplayName("Addition Test")
    void addition() {
        assertEquals(2, c.addition(1, 1));
    }

    @Test
    @DisplayName("Subtraction Test")
    void subtraction() {
        assertEquals(2, c.subtraction(4, 2));
    }

    @Test
    @DisplayName("Multiplication Test")
    void multiply() {
        assertEquals(2, c.multiply(2, 1));
    }

    @Test
    @DisplayName("Division Test")
    void divide() {
        assertEquals(2, c.divide(4, 2));
    }
}




	

