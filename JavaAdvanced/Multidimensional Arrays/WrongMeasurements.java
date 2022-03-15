package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, rows);

        int[] coordinates = readArray(scanner);

        int wrongNumberRow = coordinates[0];
        int wrongNumberCol = coordinates[1];
        int wrongNumber = matrix[wrongNumberRow][wrongNumberCol];

        List<int[]> valuesToUpdate = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    valuesToUpdate.add(new int[]{row, col, getClosestItemsSum(row, col, matrix, wrongNumber)});
                }
            }
        }
        for (int[] updatedValue : valuesToUpdate) {
            matrix[updatedValue[0]][updatedValue[1]] = updatedValue[2];
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

    public static int getClosestItemsSum(int row, int col, int[][] matrix, int wrongNumber) {
        int sum = 0;

        if (row - 1 >= 0 && matrix[row - 1][col] != wrongNumber) {
            sum += matrix[row - 1][col]; // up
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongNumber) {
            sum += matrix[row + 1][col]; // down
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongNumber) {
            sum += matrix[row][col - 1]; // left
        }
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongNumber) {
            sum += matrix[row][col + 1]; // right
        }

        return sum;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[][] readMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
