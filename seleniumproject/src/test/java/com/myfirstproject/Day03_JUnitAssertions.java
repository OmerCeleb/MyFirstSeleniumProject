package com.myfirstproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day03_JUnitAssertions {

    /*
        What is assertion?
        - Assertion is used to check the expected value against the actual value
        - Every test case MUST have an assertion
                     expected = actual ==> PASS
                     expected != actual ==> FAIL

        ***************************************************************************

        - In JUnit 5, we use Assertions class to verify the expected values against actual values
        - Assertions.assertEquals
        - Assertions.assertTrue
        - Assertions.assertFalse
        - Assertions.assertNull

        ****************************************************************************

        - These assertions are called HARD assertion.
        Because once assertion fails it STOPS executing the remaining steps of the test cases
     */

    @Test
    public void assertionsTest() {

        Assertions.assertEquals(5, 5);
        Assertions.assertEquals("Amazon", "Amazon");
        Assertions.assertEquals("amazon", "Amazon".toLowerCase());

        System.out.println("Line 34");

        Assertions.assertTrue(5 > 3);
        Assertions.assertTrue(true);
        Assertions.assertTrue("selenium".contains("e"));
        Assertions.assertTrue("apple".contains("a"));


        Assertions.assertFalse(4 > 9);
        Assertions.assertFalse("Java".contains("E"));

        String str = null; // this null means the string is empty
        Assertions.assertNull(str);

        String s = "123";
        Assertions.assertNotNull(s);


        char[] arr1 = {'j', 'a', 'v', 'a'};
        char[] arr2 = "java".toCharArray();
        Assertions.assertArrayEquals(arr2, arr1);





    }

}
