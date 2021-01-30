package org.epam.learn.java.fundamentals.optionaltask.two;

public class Task2 {
    public static void main(String[] args) {
        SquareMatrix matrix = new SquareMatrix();

        matrix.print();
        increase(matrix.getSquareMatrix());
        decrease(matrix.getSquareMatrix());
//        increase(new int[][]{{1,2,3,4},
//                             {5,6,7,6},
//                             {1,2,3,4},
//                             {5,6,7,8}});
    }

    public static void increase(int[][] matrix) {
        int length = matrix.length;
        int count = 1;
        int max = 1;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (matrix[i][j] < matrix[i][j + 1]) {
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    count = 1;
                }
            }

            if (i < length - 1 && matrix[i][length - 1] < matrix[i + 1][0]) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 1;
            }
        }

        if (max == 1) {
            max = count;
        }

        System.out.println("max count increase = " + max);
    }
    public static void decrease(int[][] matrix) {
        int length = matrix.length;
        int count = 1;
        int max = 1;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (matrix[i][j] > matrix[i][j + 1]) {
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    count = 1;
                }
            }

            if (i < length - 1 && matrix[i][length - 1] > matrix[i + 1][0]) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 1;
            }
        }

        if (max == 1) {
            max = count;
        }

        System.out.println("max count decrease = " + max);
    }
}
