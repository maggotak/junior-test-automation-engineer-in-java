package org.epam.learn.java.fundamentals.optionaltask.two;

public class Task3 {
    public static void main(String[] args) {
        SquareMatrix matrix = new SquareMatrix();

        matrix.print();
        findSum(matrix.getSquareMatrix());
    }

    public static void findSum(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            int firstPositiveNumber = 0;
            int sum = 0;

            for (int j = 0; j < length; j++) {
                if (matrix[i][j] > 0) {
                    if (firstPositiveNumber == 0) {
                        firstPositiveNumber = matrix[i][j];
                    } else {
                        break;
                    }
                } else if (firstPositiveNumber != 0){
                    sum += matrix[i][j];
                } else {
                    continue;
                }
            }
            System.out.println("Sum of the line " + i + " = " + sum);
        }
    }
}
