package MultidimensionalArraysExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replace("(", "").replace(")", "").replace("Rotate", "");
        int rotationDegree = Integer.parseInt(input);
        String element = scanner.nextLine();

        ArrayDeque<String> elements = new ArrayDeque<>();
        int biggestLength = Integer.MIN_VALUE;
        while (!element.equals("END")) {
            int currentLength = element.length();
            elements.offer(element);

            if (currentLength > biggestLength) {
                biggestLength = currentLength;
            }

            element = scanner.nextLine();
        }

        while (rotationDegree >= 360) {
            rotationDegree = rotationDegree % 360;
        }

        if (rotationDegree == 0) {
            readAndPrint360DegreeMatrix(elements.size(), biggestLength, elements);
        } else if (rotationDegree == 90) {
            readAndPrint90DegreeMatrix(biggestLength, elements.size(), elements);
        } else if (rotationDegree == 180) {
            readAndPrint180DegreeMatrix(elements.size(), biggestLength, elements);
        } else if (rotationDegree == 270) {
            readAndPrint270DegreeMatrix(biggestLength, elements.size(), elements);
        }
    }

    public static void printMatrix(char[][] outputMatrix) {
        for (int row = 0; row < outputMatrix.length; row++) {
            for (int col = 0; col < outputMatrix[row].length; col++) {
                System.out.print(outputMatrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void readAndPrint360DegreeMatrix(int rows, int cols, ArrayDeque<String> elements) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String currentElement = elements.poll();
            for (int col = 0; col < cols; col++) {
                if (col >= currentElement.length()) {
                    matrix[row][col] = ' ';
                } else {
                    char currentSymbol = currentElement.charAt(col);
                    matrix[row][col] = currentSymbol;
                }
            }
        }
        printMatrix(matrix);
    }

    public static void readAndPrint270DegreeMatrix(int rows, int cols, ArrayDeque<String> elements) {
        char[][] matrix = new char[rows][cols];
        for (int col = 0; col < cols; col++) {
            String currentElement = elements.poll();
            int currentRow = 0;
            for (int row = rows - 1; row >= 0; row--) {
                if (row >= currentElement.length()) {
                    matrix[currentRow++][col] = ' ';
                } else {
                    char currentSymbol = currentElement.charAt(row);
                    matrix[currentRow++][col] = currentSymbol;
                }
            }
        }
        printMatrix(matrix);
    }

    public static void readAndPrint180DegreeMatrix(int rows, int cols, ArrayDeque<String> elements) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String currentElement = elements.removeLast();
            int currentCol = 0;
            for (int col = cols - 1; col >= 0; col--) {
                if (col >= currentElement.length()) {
                    matrix[row][currentCol++] = ' ';
                } else {
                    char currentSymbol = currentElement.charAt(col);
                    matrix[row][currentCol++] = currentSymbol;
                }
            }
        }
        printMatrix(matrix);
    }

    public static void readAndPrint90DegreeMatrix(int rows, int cols, ArrayDeque<String> elements) {
        char[][] matrix = new char[rows][cols];
        for (int col = 0; col < cols; col++) {
            String currentElement = elements.removeLast();
            for (int row = 0; row < rows; row++) {
                if (row >= currentElement.length()) {
                    matrix[row][col] = ' ';
                } else {
                    char currentSymbol = currentElement.charAt(row);
                    matrix[row][col] = currentSymbol;
                }
            }
        }
        printMatrix(matrix);
    }
}
