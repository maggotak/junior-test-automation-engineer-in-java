package org.epam.learn.java.fundamentals.optionaltask.one;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int allLength = 0;
        Scanner scanner = new Scanner(System.in);
        final int NUMBER = scanner.nextInt();
        String[] array = new String[NUMBER];

        for (int i = 0; i < NUMBER; i++) {
            array[i] = scanner.next();
            allLength += array[i].length();
        }

        int averageLength = allLength / NUMBER;

        System.out.println("More than average length = " + averageLength);
        for (int i = 0; i < NUMBER; i++) {
            if (array[i].length() > averageLength) {
                System.out.println(array[i] + " with length = " + array[i].length());
            }
        }

        System.out.println("\nLess than average length = " + averageLength);
        for (int i = 0; i < NUMBER; i++) {
            if (array[i].length() < averageLength) {
                System.out.println(array[i] + " with length = " + array[i].length());
            }
        }
    }
}
