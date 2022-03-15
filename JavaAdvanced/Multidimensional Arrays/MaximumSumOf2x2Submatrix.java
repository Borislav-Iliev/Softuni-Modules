package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = readMatrix(scanner, rows, cols);

        int bestSum = Integer.MIN_VALUE;
        int[][] bestMatrix = new int[2][2];
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int currentElement = matrix[r][c];
                int inRight = matrix[r][c + 1];
                int inLeft = matrix[r + 1][c];
                int leftRight = matrix[r + 1][c + 1];

                int sum = currentElement + inRight + inLeft + leftRight;

                if (sum > bestSum) {
                    bestSum = sum;
                    bestMatrix = new int[][]{
                            {currentElement, inRight},
                            {inLeft, leftRight}
                    };
                }
            }
        }
        printMatrix(bestMatrix);
        System.out.println(bestSum);
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
