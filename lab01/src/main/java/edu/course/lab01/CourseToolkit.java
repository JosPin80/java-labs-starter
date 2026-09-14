package edu.course.lab01;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * Небольшие методы для первой лабораторной работы.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }

    /**
     * Возвращает true, если число четное.
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        if (number <= 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("[Error] IllegalArgumentException");
        }

        int lenText = text.length();
        int doLen = (lenText / 2) - 1;

        for (int i = 0; i < doLen; i++) {
            if (text.charAt(i) != text.charAt(lenText - 1)) {
                return false;
            }
            i++;
            lenText--;
        }
        return true;
    }

    public static double average(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("[Error] IllegalArgumentException");
        }
//        double sum = Arrays.stream(values).sum();
        OptionalDouble sum = Arrays.stream(values).average();
        return sum.getAsDouble();
    }

}
