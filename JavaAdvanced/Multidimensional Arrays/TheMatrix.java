package MultidimensionalArraysExercise;

import java.util.Scanner;

public class _12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimension = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        char[][] matrix = readMatrix(scanner, rows, cols);

        char fillChar = scanner.nextLine().charAt(0);

        String[] startDimension = scanner.nextLine().split("\\s+");
        int startRow = Integer.parseInt(startDimension[0]);
        int startCol = Integer.parseInt(startDimension[1]);
        char startChar = matrix[startRow][startCol];

        fillMatrixWithFillChar(startRow, startCol, fillChar, startChar, matrix);

        printMatrix(matrix);
    }

    public static void printMatrix(char[][] outputMatrix) {
        for (int row = 0; row < outputMatrix.length; row++) {
            for (int col = 0; col < outputMatrix[row].length; col++) {
                System.out.print(outputMatrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void fillMatrixWithFillChar(int startRow, int startCol, char fillChar, char startChar, char[][] matrix) {
        if (matrix[startRow][startCol] != startChar) {
            return;
        }

        matrix[startRow][startCol] = fillChar;

        if (startRow - 1 >= 0) {
            fillMatrixWithFillChar(startRow - 1, startCol, fillChar, startChar, matrix); //up
        }
        if (startRow + 1 < matrix.length) {
            fillMatrixWithFillChar(startRow + 1, startCol, fillChar, startChar, matrix); // down
        }
        if (startCol - 1 >= 0) {
            fillMatrixWithFillChar(startRow, startCol - 1, fillChar, startChar, matrix); // left
        }
        if (startCol + 1 < matrix[startRow].length) {
            fillMatrixWithFillChar(startRow, startCol + 1, fillChar, startChar, matrix); // right
        }
    }

    public static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < elements.length; col++) {
                char currentSymbol = elements[col].charAt(0);
                matrix[row][col] = currentSymbol;
            }
        }
        return matrix;
    }
}
