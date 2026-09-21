package edu.course.lab01;

import java.util.Scanner;

class CLI {

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.print("test menu:\n1. isEven\n2. isPrime\n3. isPalindrome\n4. average\n\ninput: ");
        int num = in.nextInt();

        switch (num) {
            case 1 -> {
                System.out.print("number: ");
                int n = in.nextInt();
                System.out.println("result: " + CourseToolkit.isEven(n));
            }
            case 2 -> {
                System.out.print("number: ");
                int n = in.nextInt();
                System.out.println("result: " + CourseToolkit.isPrime(n));
            }
            case 3 -> {
                System.out.print("text: ");
                String text = in.next();
                System.out.println("result: " + CourseToolkit.isPalindrome(text));
            }
            case 4 -> {
                System.out.print("how many numbers? ");
                int count = in.nextInt();

                int[] arr = new int[count];
                for (int i = 0; i < count; i++) {
                    System.out.print("number " + (i + 1) + ": ");
                    arr[i] = in.nextInt();
                }

                System.out.println("result: " + CourseToolkit.average(arr));
            }
        }
    }
}