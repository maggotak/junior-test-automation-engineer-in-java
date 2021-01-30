package org.epam.learn.java.fundamentals.maintask;

public class MainTask4 {
    public static void main(String[] args) {
        int sum = 0;
        int multiply = 1;

        for (int i = 0; i < args.length; i++) {
            int temp = Integer.parseInt(args[i]);
            sum += temp;
            multiply *= temp;
        }

        System.out.println("Sum of numbers = " + sum);
        System.out.println("Multiplication of numbers = " + multiply);
    }
}
