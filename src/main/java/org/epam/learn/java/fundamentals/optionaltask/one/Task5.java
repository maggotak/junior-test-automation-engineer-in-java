package org.epam.learn.java.fundamentals.optionaltask.one;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUMBER = scanner.nextInt();
        String[] array = new String[NUMBER];
        int onlyEven = 0;
        int equalEvenAndOdd = 0;

        for (int i = 0; i < NUMBER; i++) {
            array[i] = scanner.next();
        }

        for (int i = 0; i < NUMBER; i++) {
            int temp = countEvenNumbers(array[i]);
            if (temp == 0) {
                onlyEven++;
            }
            if (temp == 1) {
                equalEvenAndOdd++;
            }
        }
        System.out.println("Only even numbers = " + onlyEven);
        System.out.println("Equal even and odd numbers = " + equalEvenAndOdd);
    }

    private static int countEvenNumbers(String string) {
        int counter = 0;

        for (int i = 0; i < string.length(); i++) {
            int number = Integer.parseInt(String.valueOf(string.charAt(i)));
            if (number % 2 == 0) {
                counter++;
            }
        }
        if (counter == string.length()) {
            return 0;
        } else if (2 * counter == string.length()) {
            return 1;
        }
        return -1;
    }
}
