package _20February2021;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",+");
        char[][] matrix = readMatrix(scanner, rows, rows);

        ArrayDeque<Integer> sapperDimension = findStartingPoint(matrix);
        int bombCounter = countBombs(matrix);
        int sapperCurrentRow = sapperDimension.poll();
        int sapperCurrentCol = sapperDimension.poll();

        for (String currentCommand : commands) {

            switch (currentCommand) {
                case "left":
                    matrix[sapperCurrentRow][sapperCurrentCol] = '+';
                    sapperCurrentCol--;
                    if (sapperCurrentCol < 0) {
                        sapperCurrentCol = 0;
                        continue;
                    }

                    if (matrix[sapperCurrentRow][sapperCurrentCol] == 'e') {
                        System.out.println("END! " + bombCounter + " bombs left on the field");
                        return;
                    } else if (matrix[sapperCurrentRow][sapperCurrentCol] == 'B') {
                        matrix[sapperCurrentRow][sapperCurrentCol] = 's';
                        System.out.println("You found a bomb!");
                        bombCounter--;
                    } else {
                        matrix[sapperCurrentRow][sapperCurrentCol] = 's';
                    }

                    break;
                case "right":
                    matrix[sapperCurrentRow][sapperCurrentCol] = '+';
                    sapperCurrentCol++;
                    if (sapperCurrentCol >= matrix[sapperCurrentRow].length) {
                        sapperCurrentCol = matrix[sapperCurrentRow].length - 1;
                        continue;
                    }

                    if (matrix[sapperCurrentRow][sapperCurrentCol] == 'e') {
                        System.out.println("END! " + bombCounter + " bombs left on the field");
                        return;
                    } else if (matrix[sapperCurrentRow][sapperCurrentCol] == 'B') {
                        matrix[sapperCurrentRow][sapperCurrentCol] = 's';
                        System.out.println("You found a bomb!");
                        bombCounter--;
                    } else {
                        matrix[sapperCurrentRow][sapperCurrentCol] = 's';
                    }
                    break;
                case "up":
                    matrix[sapperCurrentRow][sapperCurrentCol] = '+';
                    sapperCurrentRow--;
                    if (sapperCurrentRow < 0) {
                        sapperCurrentRow = 0;
                        continue;
                    }

                    if (matrix[sapperCurrentRow][sapperCurrentCol] == 'e') {
                        System.out.println("END! " + bombCounter + " bombs left on the field");
                        return;
                    } else if (matrix[sapperCurrentRow][sapperCurrentCol] == 'B') {
                        matrix[sapperCurrentRow][sapperCurrentCol] = 's';
                        System.out.println("You found a bomb!");
                        bombCounter--;
                    } else {
                        matrix[sapperCurrentRow][sapperCurrentCol] = 's';
                    }
                    break;
                case "down":
                    matrix[sapperCurrentRow][sapperCurrentCol] = '+';
                    sapperCurrentRow++;
                    if (sapperCurrentRow >= matrix.length) {
                        sapperCurrentRow = matrix.length - 1;
                        continue;
                    }

                    if (matrix[sapperCurrentRow][sapperCurrentCol] == 'e') {
                        System.out.println("END! " + bombCounter + " bombs left on the field");
                        return;
                    } else if (matrix[sapperCurrentRow][sapperCurrentCol] == 'B') {
                        matrix[sapperCurrentRow][sapperCurrentCol] = 's';
                        System.out.println("You found a bomb!");
                        bombCounter--;
                    } else {
                        matrix[sapperCurrentRow][sapperCurrentCol] = 's';
                    }
                    break;

            }

            if (bombCounter == 0) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
        }

        System.out.println(bombCounter + " bombs left on the field. Sapper position: (" + sapperCurrentRow + "," + sapperCurrentCol + ")");
    }


    public static int countBombs(char[][] matrix) {
        int bombCounter = 0;
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == 'B') {
                    bombCounter++;
                }
            }
        }
        return bombCounter;
    }

    public static ArrayDeque<Integer> findStartingPoint(char[][] matrix) {
        ArrayDeque<Integer> playerDimensions = new ArrayDeque<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 's') {
                    playerDimensions.offer(row);
                    playerDimensions.offer(col);
                    return playerDimensions;
                }
            }
        }
        return playerDimensions;
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
