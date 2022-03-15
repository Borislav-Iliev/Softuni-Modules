package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, rows);

        int currentRow = 0;
        int currentCol = 0;
        while (currentRow < matrix.length && currentCol < matrix.length) {
            int currentElement = matrix[currentRow][currentCol];
            System.out.print(currentElement + " ");
            currentRow++;
            currentCol++;
        }

        System.out.println();

        currentRow = matrix.length - 1;
        currentCol = 0;

        while (currentRow >= 0 && currentCol < matrix.length) {
            int currentElement = matrix[currentRow][currentCol];
            System.out.print(currentElement + " ");
            currentRow--;
            currentCol++;
        }
    }

    public static int[][] readMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
