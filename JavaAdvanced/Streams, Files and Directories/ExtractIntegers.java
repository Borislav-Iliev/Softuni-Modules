package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class _04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        String outputPath = "D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        PrintStream out = new PrintStream(outputStream);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                out.println(scanner.nextInt());
            }
            scanner.next();
        }
        inputStream.close();
        outputStream.close();
    }
}
