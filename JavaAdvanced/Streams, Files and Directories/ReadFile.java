package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _01ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = "D:\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            int value = inputStream.read();
            while (value != -1) {
                System.out.print(Integer.toBinaryString(value) + " ");
                value = inputStream.read();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
