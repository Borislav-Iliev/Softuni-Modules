package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArray(scanner.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] firstMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            firstMatrix[row] = readArray(scanner.nextLine());
        }

        rowsAndCols = readArray(scanner.nextLine());

        rows = rowsAndCols[0];
        cols = rowsAndCols[1];

        int[][] secondMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            secondMatrix[row] = readArray(scanner.nextLine());
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArray(String line) {
        return Arrays
                .stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
