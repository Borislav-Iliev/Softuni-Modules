package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotTokens = scanner.nextLine().split(";+");
        Map<String, Integer> robots = getRobotMap(robotTokens);
        Map<String, Integer> robotsWorkingTime = getRobotWorkingTimeMap(robotTokens);

        String startTime = scanner.nextLine();
        String product = scanner.nextLine();

        int startTimeInSeconds = getStartTimeInSeconds(startTime);

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!product.equals("End")) {
            queue.offer(product);
            product = scanner.nextLine();
        }

        while (!queue.isEmpty()) {
            String currentProduct = queue.poll();
            startTimeInSeconds++;
            decreaseRobotsWorkingTime(robotsWorkingTime);
            boolean isTaken = false;
            for (Map.Entry<String, Integer> entry : robotsWorkingTime.entrySet()) {
                if (entry.getValue() == 0) {
                    System.out.println(entry.getKey() + " - " + currentProduct + " [" + getStartTime(startTimeInSeconds) + "]");
                    robotsWorkingTime.put(entry.getKey(), robots.get(entry.getKey()));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                queue.offer(currentProduct);
            }
        }
    }

    private static void decreaseRobotsWorkingTime(Map<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> entry : robotsWorkingTime.entrySet()) {
            if (entry.getValue() > 0) {
                robotsWorkingTime.put(entry.getKey(), entry.getValue() - 1);
            }
        }
    }

    private static int getStartTimeInSeconds(String startTime) {
        String[] startTimeTokens = startTime.split(":+");
        int hours = Integer.parseInt(startTimeTokens[0]);
        int minutes = Integer.parseInt(startTimeTokens[1]);
        int seconds = Integer.parseInt(startTimeTokens[2]);

        return (hours * 3600) + (minutes * 60) + seconds;
    }

    private static String getStartTime(int startTimeInSeconds) {
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static Map<String, Integer> getRobotWorkingTimeMap(String[] robotTokens) {
        LinkedHashMap<String, Integer> robotsWorkingTime = new LinkedHashMap<>();
        for (int i = 0; i < robotTokens.length; i++) {
            String robotName = robotTokens[i].split("-")[0];
            robotsWorkingTime.put(robotName, 0);
        }

        return robotsWorkingTime;
    }

    private static LinkedHashMap<String, Integer> getRobotMap(String[] robotTokens) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < robotTokens.length; i++) {
            String robotName = robotTokens[i].split("-")[0];
            int processTime = Integer.parseInt(robotTokens[i].split("-")[1]);
            robots.put(robotName, processTime);
        }
        return robots;
    }
}
