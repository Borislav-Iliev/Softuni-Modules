package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotTokens = scanner.nextLine().split(";+");
        Map<String, Integer> robots = getRobotsMap(robotTokens);
        Map<String, Integer> robotsWorkingTime = getRobotsWorkingTimeMap(robotTokens);

        String startTime = scanner.nextLine();
        int startTimeInSeconds = getStartTimeInSeconds(startTime);

        String product = scanner.nextLine();
        ArrayDeque<String> productQueue = new ArrayDeque<>();

        while (!product.equals("End")) {
            productQueue.offer(product);
            product = scanner.nextLine();
        }

        while (!productQueue.isEmpty()) {
            String currentProduct = productQueue.poll();
            startTimeInSeconds++;
            decreaseWorkingTime(robotsWorkingTime);
            boolean isTaken = false;
            for (Map.Entry<String, Integer> entry : robotsWorkingTime.entrySet()) {
                if (entry.getValue() == 0) {
                    System.out.println(entry.getKey() + " - " + currentProduct + " [" + getStartTimeOutput(startTimeInSeconds) + "]");
                    robotsWorkingTime.put(entry.getKey(), robots.get(entry.getKey()));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                productQueue.offer(currentProduct);
            }
        }
    }

    private static int getStartTimeInSeconds(String startTime) {
        String[] tokens = startTime.split(":+");
        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);

        return (hours * 3600) + (minutes * 60) + seconds;
    }

    private static String getStartTimeOutput(int startTimeInSeconds) {
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = (startTimeInSeconds % 3600) / 60;
        int seconds = startTimeInSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static void decreaseWorkingTime(Map<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> entry : robotsWorkingTime.entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
            }
        }
    }

    private static Map<String, Integer> getRobotsWorkingTimeMap(String[] robotTokens) {
        LinkedHashMap<String, Integer> robotsWorkingTime = new LinkedHashMap<>();
        for (int i = 0; i < robotTokens.length; i++) {
            String robotsName = robotTokens[i].split("-+")[0];
            robotsWorkingTime.put(robotsName, 0);
        }
        return robotsWorkingTime;
    }

    private static Map<String, Integer> getRobotsMap(String[] robotTokens) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < robotTokens.length; i++) {
            String robotsName = robotTokens[i].split("-+")[0];
            int robotsWorkingTime = Integer.parseInt(robotTokens[i].split("-+")[1]);
            robots.put(robotsName, robotsWorkingTime);
        }
        return robots;
    }
}
