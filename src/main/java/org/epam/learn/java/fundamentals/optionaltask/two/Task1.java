package org.epam.learn.java.fundamentals.optionaltask.two;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        SquareMatrix matrix = new SquareMatrix();
        Random random = new Random();

        matrix.print();
        sortByLines(matrix.getSquareMatrix(), random.nextInt(matrix.getSquareMatrix().length - 1));
//        sortByRows(matrix.getSquareMatrix(), random.nextInt(matrix.getSquareMatrix().length - 1));
        matrix.print();
    }

    public static void sortByLines(int[][] matrix, int n) {
        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (matrix[n][i] > matrix[n][j]) {
                    for (int k = 0; k < length; k++) {
                        int temp = matrix[k][i];
                        matrix[k][i] = matrix[k][j];
                        matrix[k][j] = temp;
                    }
                }
            }
        }

        System.out.println("\nn = " + n + "\n");
    }
    public static void sortByRows(int[][] matrix, int n) {
        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (matrix[i][n] > matrix[i][j]) {
                    for (int k = 0; k < length; k++) {
                        int temp = matrix[i][k];
                        matrix[i][k] = matrix[j][k];
                        matrix[j][k] = temp;
                    }
                }
            }
        }

        System.out.println("\nn = " + n + "\n");
    }
}
