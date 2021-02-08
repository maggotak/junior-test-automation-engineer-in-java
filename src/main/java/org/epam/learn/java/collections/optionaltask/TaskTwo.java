package org.epam.learn.java.collections.optionaltask;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String number = scan.nextLine();
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        String[] numberAsArray = number.split("");

        for (String s : numberAsArray) {
            numbersStack.push(Integer.valueOf(s));
        }

        while (!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop());
        }
    }
}
