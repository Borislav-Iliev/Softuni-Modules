package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class _07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path firstPath = Paths.get("D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt");
        Path secondPath = Paths.get("D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("merge-files-output.txt"));

        Scanner scanner = new Scanner(new FileReader(String.valueOf(firstPath)));

        while (scanner.hasNextLine()) {
            bufferedWriter.write(scanner.nextLine() + System.lineSeparator());
        }

        scanner = new Scanner(new FileReader(String.valueOf(secondPath)));

        while (scanner.hasNextLine()) {
            bufferedWriter.write(scanner.nextLine() + System.lineSeparator());
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
