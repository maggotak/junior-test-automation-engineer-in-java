package org.epam.learn.java.fundamentals.optionaltask.one;

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUMBER = scanner.nextInt();
        String[] array = new String[NUMBER];
        String increase = "";

        for (int i = 0; i < NUMBER; i++) {
            array[i] = scanner.next();
        }

        for (int i = 0; i < NUMBER; i++) {
            if (isIncrease(array[i])) {
                increase = array[i];
                break;
            }
        }

        if (!increase.isEmpty()) {
            System.out.println("All number in increase " + increase);
        } else {
            System.out.println("No numbers with all increase");
        }
    }

    private static boolean isIncrease(String string) {
        int[] tempArray = new int[string.length()];
        int[] sortedTempArray = new int[string.length()];
        boolean incr;

        for (int i = 0; i < string.length(); i++) {
            tempArray[i] = Integer.parseInt(String.valueOf(string.charAt(i)));
        }

        sortedTempArray = tempArray.clone();
        Arrays.sort(sortedTempArray);

        for (int i = 0; i < string.length(); i++) {
            if (tempArray[i] != sortedTempArray[i]) {
                return false;
            }
        }
        return true;
    }
}
