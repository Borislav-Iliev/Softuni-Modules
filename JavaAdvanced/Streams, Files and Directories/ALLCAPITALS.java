package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class _03ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int value = bufferedReader.read();

        while (value != -1) {
            char symbol = (char) value;

            if (Character.isLowerCase(symbol)) {
                symbol = Character.toUpperCase(symbol);
            }

            bufferedWriter.write(symbol);
            value = bufferedReader.read();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
