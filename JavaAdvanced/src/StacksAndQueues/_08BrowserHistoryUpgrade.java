package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String currentUrl = "";

        while (!command.equals("Home")) {

            currentUrl = command;

            if (command.equals("back")) {
                if (browserHistory.isEmpty() || browserHistory.size() == 1) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    forwardHistory.addFirst(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            } else if (command.equals("forward")) {
                if (forwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardHistory.peek());
                    browserHistory.push(forwardHistory.pop());
                }
            } else {
                System.out.println(currentUrl);
                browserHistory.push(currentUrl);
                forwardHistory.clear();
            }
            command = scanner.nextLine();
        }
    }
}
