package StreamsFilesAndDirectories;

import java.io.*;

public class _05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader reader = new BufferedReader(inputStreamReader);

        String outputPath = "D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        BufferedWriter writer = new BufferedWriter(new PrintWriter(outputPath));

        String line = reader.readLine();

        int counter = 1;
        while (line != null) {
            if (counter % 3 == 0) {
                writer.write(line + System.lineSeparator());
            }
            line = reader.readLine();
            counter++;
        }
        writer.flush();
    }
}
