package org.epam.learn.java.fundamentals.optionaltask.two;

import java.util.Random;
import java.util.Scanner;

public class SquareMatrix {
    private final int M = 10;
    private int[][] squareMatrix;

    public SquareMatrix() {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = scanner.nextInt();
        squareMatrix = new int[matrixSize][matrixSize];
        Random random = new Random();

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                squareMatrix[i][j] = random.nextInt(M) - random.nextInt(M);
            }
        }


    }
    public void print() {
        for (int i = 0; i < squareMatrix.length; i++) {
            for (int j = 0; j < squareMatrix.length; j++) {
                System.out.print(squareMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getSquareMatrix() {
        return squareMatrix;
    }
}
