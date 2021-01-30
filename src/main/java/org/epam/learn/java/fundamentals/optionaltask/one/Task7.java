package org.epam.learn.java.fundamentals.optionaltask.one;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUMBER = scanner.nextInt();
        String[] array = new String[NUMBER];
        String stringWithAllDiffNumbers = "";

        for (int i = 0; i < NUMBER; i++) {
            array[i] = scanner.next();
        }

        for (int i = 0; i < NUMBER; i++) {
            int diffNumbers = countDiffNumbers(array[i]);
            if (diffNumbers == array[i].length()) {
                stringWithAllDiffNumbers = array[i];
                break;
            }
        }
        if (!stringWithAllDiffNumbers.isEmpty()) {
            System.out.println("All with different numbers " + stringWithAllDiffNumbers);
        } else {
            System.out.println("No number with different numbers");
        }
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
