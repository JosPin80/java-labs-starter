package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForZeroNumber(){
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result); // можно было догадаться что 0 % 2 == 0 (0 чётное, трижды ура)
    }

    @Test
    void returnsTrueForNegativeEvenNumber(){
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForIsPrime() {
        boolean result = CourseToolkit.isPrime(2);

        assertFalse(result);
    }

    @Test
    void returnsTrueForIsPrime() {
        boolean result = CourseToolkit.isPrime(5);

        assertTrue(result);
    }


    @Test
    void returnsTrueForIsPalindrome() {
        boolean result = CourseToolkit.isPalindrome("12321");

        assertTrue(result);
    }

    @Test
    void returnsTrueForIsPalindromeAverage() {
//        int[] arr = {1, 2, 3};
        double result = CourseToolkit.average(new int[] {1, 2, 3, 4});

        assertEquals(2.5, result);
    }
}
