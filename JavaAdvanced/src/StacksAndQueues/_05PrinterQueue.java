package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();

        String currentFile = "";

        while (!command.equals("print")) {

            if (command.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String cancelledFile = queue.poll();
                    System.out.println("Canceled " + cancelledFile);
                }
            } else {
                currentFile = command;
                queue.offer(currentFile);
            }
            command = scanner.nextLine();
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
