package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, size);

        int firstDiagonalSum = getFirstSum(matrix);

        int secondDiagonalSum = getSecondSum(matrix);

        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }

    private static int getSecondSum(int[][] matrix) {
        int currentRow = matrix.length - 1;
        int currentCol = 0;
        int sum = 0;
        while (currentRow >= 0 && currentCol < matrix.length) {
            sum += matrix[currentRow][currentCol];
            currentRow--;
            currentCol++;
        }
        return sum;
    }

    public static int getFirstSum(int[][] matrix) {
        int currentRowAndCol = 0;
        int sum = 0;
        while (currentRowAndCol < matrix.length) {
            sum += matrix[currentRowAndCol][currentRowAndCol];
            currentRowAndCol++;
        }
        return sum;
    }

    public static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
