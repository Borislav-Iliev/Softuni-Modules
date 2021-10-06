package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class _04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(path)));

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');

        int asciiValue = bufferedReader.read();
        int vowelsCounter = 0;
        int consonantsCounter = 0;
        int punctuationCounter = 0;

        while (asciiValue != -1) {
            char symbol = (char) asciiValue;
            if (vowels.contains(symbol)) {
                vowelsCounter++;
            } else if (punctuation.contains(symbol)) {
                punctuationCounter++;
            } else if (!Character.isWhitespace(symbol)) {
                consonantsCounter++;
            }
            asciiValue = bufferedReader.read();
        }

        System.out.println("Vowels: " + vowelsCounter);
        System.out.println("Consonants: " + consonantsCounter);
        System.out.println("Punctuation: " + punctuationCounter);
    }
}
