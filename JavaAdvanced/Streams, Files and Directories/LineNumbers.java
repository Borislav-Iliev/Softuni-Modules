package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _05LineNumbers {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputLineNumbers.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(path)));

        PrintStream printStream = new PrintStream(new FileOutputStream("line-numbers-output.txt"));

        String line = bufferedReader.readLine();
        int lineCounter = 1;

        while (line != null) {
            printStream.printf("%d. %s%n", lineCounter++, line);
            line = bufferedReader.readLine();
        }
    }
}
