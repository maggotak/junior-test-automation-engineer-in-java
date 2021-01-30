package org.epam.learn.java.fundamentals.optionaltask.one;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUMBER = scanner.nextInt();
        long[] array = new long[NUMBER];

        for (int i = 0; i < NUMBER; i++) {
            array[i] = scanner.nextLong();
        }

        Arrays.sort(array);

        System.out.println("The shortest number is " + array[0]);
        System.out.println("The longest number is " + array[NUMBER - 1]);

    }
}
