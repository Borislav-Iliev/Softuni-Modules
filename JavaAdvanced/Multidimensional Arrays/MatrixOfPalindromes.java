package MultidimensionalArraysExercise;

import java.util.Scanner;

public class _02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = readMatrix(rows, cols);

        printMatrix(matrix);
    }

    public static void printMatrix(String[][] outputMatrix) {
        for (int row = 0; row < outputMatrix.length; row++) {
            for (int col = 0; col < outputMatrix[row].length; col++) {
                System.out.print(outputMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] readMatrix(int rows, int cols) {
        char letter = 'a';
        char currentElement = 'a';
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String letterAsString = letter + "";
                matrix[row][col] = letterAsString + currentElement + letterAsString;
                currentElement++;
            }
            letter++;
            currentElement = letter;
        }
        return matrix;
    }
}
