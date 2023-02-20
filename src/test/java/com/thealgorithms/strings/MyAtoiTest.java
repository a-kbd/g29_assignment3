package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyAtoiTest {
	
    @Test
    void testOne() {
        assertEquals(42, MyAtoi.myAtoi("42"));
    }
  
    @Test
    void testTwo() {
        assertEquals(-42, MyAtoi.myAtoi("   -42"));
    }
  
    @Test
    void testThree() {
        assertEquals(4193, MyAtoi.myAtoi("4193 with words"));
    }
    
    /*
     * Requirement: MyAtoi.myAtoi should return the correct integer that is represented in the string while discarding leading and trailing whitespace.
     * Tests the case for the string being zero without leading or trailing spaces.
     */
    @Test
    void testFour() {
        assertEquals(0, MyAtoi.myAtoi("0"));
    }

    /*
     * Requirement: MyAtoi.myAtoi should return the correct integer that is represented in the string while discarding leading and trailing whitespace.
     * Tests the case for the string "5678" to cover the respective switch cases.
     */
    @Test
    void testFive() {
        assertEquals(5678, MyAtoi.myAtoi("5678"));
    }

    /*
     * Requirement: MyAtoi.myAtoi should return the correct integer that is represented in the string while discarding leading and trailing whitespace.
     * Tests the case for a string with a leading plus sign.
     */
    @Test
    void testSix() {
        assertEquals(42, MyAtoi.myAtoi("+42"));
    }
    
    /*
     * Requirement: MyAtoi.myAtoi should return the correct integer that is represented in the string while discarding leading and trailing whitespace.
     * Tests the case for the string being zero with a positive sign a trailing and leading whitespace.
     */
    @Test
    void testSeven() {
        assertEquals(0, MyAtoi.myAtoi("  +0   "));
    }
}
