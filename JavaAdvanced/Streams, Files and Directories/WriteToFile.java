package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class _02WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        String outputPath = "D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        Set<Character> punctuation = Set.of(',', '.', '!', '?');

        int ascii = inputStream.read();

        while (ascii != -1) {
            char symbol = (char) ascii;
            if (!punctuation.contains(symbol)) {
                outputStream.write(symbol);
            }
            ascii = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
