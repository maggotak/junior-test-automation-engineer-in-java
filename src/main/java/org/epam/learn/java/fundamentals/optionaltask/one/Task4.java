package org.epam.learn.java.fundamentals.optionaltask.one;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUMBER = scanner.nextInt();
        String[] array = new String[NUMBER];
        String numberWithMinDiffNumbers = "";
        int minDiffNumbers = 11;

        for (int i = 0; i < NUMBER; i++) {
            array[i] = scanner.next();
        }

        for (int i = 0; i < NUMBER; i++) {
            int min = countDiffNumbers(array[i]);
            if (min < minDiffNumbers) {
                minDiffNumbers = min;
                numberWithMinDiffNumbers = array[i];
            }
        }
        System.out.println("Minimum different numbers in " + numberWithMinDiffNumbers + " with different numbers = " + minDiffNumbers);
    }

    private static int countDiffNumbers(String string) {
        int counter = 0;
        boolean isDifferent;

        for (int i = 0; i < string.length(); i++) {
            isDifferent = true;
            for (int j = 0; j < i; j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    isDifferent = false;
                }
            }
            if (isDifferent == true) {
                counter++;
            }
        }
        return counter;
    }
}
