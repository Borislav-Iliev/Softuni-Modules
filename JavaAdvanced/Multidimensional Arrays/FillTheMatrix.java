package MultidimensionalArraysExercise;

import java.util.Scanner;

public class _01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(",\\s+");
        int size = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            fillMatrixWithPatternA(matrix, size);
        } else if (pattern.equals("B")) {
            fillMatrixWithPatternB(matrix, size);
        }

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixWithPatternB(int[][] matrix, int size) {
        int startingNumber = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startingNumber++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = startingNumber++;
                }
            }
        }
    }

    private static void fillMatrixWithPatternA(int[][] matrix, int size) {
        int startingNumber = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = startingNumber++;
            }
        }
    }
}
