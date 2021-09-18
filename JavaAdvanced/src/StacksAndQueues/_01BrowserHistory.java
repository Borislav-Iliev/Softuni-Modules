package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String currentUrl = "";

        while (!command.equals("Home")) {

            currentUrl = command;

            if (command.equals("back")) {
                if (browserHistory.isEmpty() || browserHistory.size() == 1) {
                    System.out.println("no previous URLs");
                } else {
                    browserHistory.pop();
                    currentUrl = browserHistory.peek();
                    System.out.println(currentUrl);
                }
            } else {
                browserHistory.push(currentUrl);
                System.out.println(currentUrl);
            }


            command = scanner.nextLine();
        }
    }
}
