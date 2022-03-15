package MultidimensionalArraysExercise;

import java.util.Scanner;

public class _05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimension = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        String[][] matrix = readMatrix(scanner, rows, cols);

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            if (commandIsValid(command, matrix, rows, cols)) {
                String[] tokens = command.split("\\s+");
                int firstRowIndex = Integer.parseInt(tokens[1]);
                int firstColIndex = Integer.parseInt(tokens[2]);
                int secondRowIndex = Integer.parseInt(tokens[3]);
                int secondColIndex = Integer.parseInt(tokens[4]);

                String swapValue = " ";
                swapValue = matrix[firstRowIndex][firstColIndex];
                matrix[firstRowIndex][firstColIndex] = matrix[secondRowIndex][secondColIndex];
                matrix[secondRowIndex][secondColIndex] = swapValue;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static boolean commandIsValid(String command, String[][] matrix, int rows, int cols) {
        String[] tokens = command.split("\\s+");
        if (!tokens[0].equals("swap")) {
            return false;
        }

        if (tokens.length != 5) {
            return false;
        }

        int firstRowIndex = Integer.parseInt(tokens[1]);
        int firstColIndex = Integer.parseInt(tokens[2]);
        int secondRowIndex = Integer.parseInt(tokens[3]);
        int secondColIndex = Integer.parseInt(tokens[4]);

        if (firstRowIndex < 0 || firstRowIndex >= rows ||
                firstColIndex < 0 || firstColIndex >= cols ||
                secondRowIndex < 0 || secondRowIndex >= rows ||
                secondColIndex < 0 || secondColIndex >= cols) {
            return false;
        }

        return true;
    }

    public static String[][] readMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}
