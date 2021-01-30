package org.epam.learn.java.fundamentals.optionaltask.two;

public class Task4 {
    public static void main(String[] args) {
        SquareMatrix matrix = new SquareMatrix();

        matrix.print();
        findAndDeleteMaximum(matrix.getSquareMatrix());

    }

    public static void findAndDeleteMaximum(int[][] matrix) {
        int length = matrix.length;
        int max = 0;
        int maxLine = 0;
        int maxRow = 0;
        int[][] arrayWithoutMaxValue = new int[length - 1][length - 1];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxLine = i;
                    maxRow = j;
                }
            }
        }
        System.out.println();
        System.out.println("max line = " + maxLine);
        System.out.println("max row = " + maxRow);

        for (int i = 0, k = 0; k < length - 1;) {
            if (i != maxLine) {
                for (int j = 0, m = 0;m < length - 1; j++, m++) {
                    if (j == maxRow) {
                        j++;
                    }
                    arrayWithoutMaxValue[k][m] = matrix[i][j];
                }
                i++;
                k++;
            } else {
                i++;
            }
        }

        System.out.println("Max = " + max);
        System.out.println("\nNew matrix:");
        for (int i = 0; i < arrayWithoutMaxValue.length; i++) {
            for (int j = 0; j < arrayWithoutMaxValue.length; j++) {
                System.out.print(arrayWithoutMaxValue[i][j] + " ");
            }
            System.out.println();
        }
    }
}
