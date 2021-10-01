package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> userInfo = new TreeMap<>();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String ip = tokens[0].replace("IP=", "");
            String user = tokens[2].replace("user=", "");

            userInfo.putIfAbsent(user, new LinkedHashMap<>());
            userInfo.get(user).putIfAbsent(ip, 0);
            userInfo.get(user).put(ip, userInfo.get(user).get(ip) + 1);

            input = scanner.nextLine();
        }

        userInfo.entrySet()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": ");
                    Map<String, Integer> innerMap = entry.getValue();
                    int counter = 1;
                    for (Map.Entry<String, Integer> innerEntry : innerMap.entrySet()) {

                        if (counter < innerMap.size()) {
                            System.out.print(innerEntry.getKey() + " => " + innerEntry.getValue() + ", ");
                        } else {
                            System.out.println(innerEntry.getKey() + " => " + innerEntry.getValue() + ".");
                        }

                        counter++;
                    }
                });
    }
}
