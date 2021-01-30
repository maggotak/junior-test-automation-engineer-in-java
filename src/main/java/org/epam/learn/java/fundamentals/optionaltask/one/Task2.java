package org.epam.learn.java.fundamentals.optionaltask.one;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUMBER = scanner.nextInt();
        long[] array = new long[NUMBER];

        for (int i = 0; i < NUMBER; i++) {
            array[i] = scanner.nextLong();
        }

        Arrays.sort(array);

        for (int i = 0; i < NUMBER; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        for (int i = NUMBER - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }

    }
}
