package org.epam.learn.java.fundamentals.maintask;

import java.util.Random;

public class MainTask3 {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        Random random = new Random();
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = random.nextInt();
        }

        for (int i = 0; i < number; i++) {
            System.out.println(array[i]);
        }

        for (int i = 0; i < number; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
