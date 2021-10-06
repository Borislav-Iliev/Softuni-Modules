package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06WordCount {
    public static void main(String[] args) throws IOException {
        Path firstPath = Paths.get("D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt");
        Path secondPath = Paths.get("D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\text.txt");

        BufferedReader firstBufferedReader = new BufferedReader(new FileReader(String.valueOf(firstPath)));
        BufferedReader secondBufferedReader = new BufferedReader(new FileReader(String.valueOf(secondPath)));

        String[] words = firstBufferedReader.readLine().split("\\s+");
        String line = secondBufferedReader.readLine();
        String[] wordsFromLine = line.split("\\s+");

        Map<String, Integer> wordsCounter = new LinkedHashMap<>();

        while (line != null) {
            for (String s : wordsFromLine) {
                for (String word : words) {
                    if (s.equals(word)) {
                        wordsCounter.putIfAbsent(word, 0);
                        wordsCounter.put(word, wordsCounter.get(word) + 1);
                    }
                }
            }
            line = secondBufferedReader.readLine();
        }
        firstBufferedReader.close();
        secondBufferedReader.close();

        PrintStream printStream = new PrintStream(new FileOutputStream("word-count-output.txt"));

        wordsCounter.entrySet()
                .stream()
                .sorted((w1, w2) -> Integer.compare(w2.getValue(), w1.getValue()))
                .forEach(entry -> printStream.printf("%s - %d%n", entry.getKey(), entry.getValue()));
    }
}
