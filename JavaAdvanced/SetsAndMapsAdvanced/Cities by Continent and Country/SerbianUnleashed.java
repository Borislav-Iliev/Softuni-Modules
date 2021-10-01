package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> concerts = new LinkedHashMap<>();

        while (!input.equals("End")) {
            if (!input.contains("@") || input.charAt(input.indexOf("@") - 1) != ' ') {
                input = scanner.nextLine();
                continue;
            }

            String singer = input.substring(0, input.indexOf("@")).trim();

            int firstIndexOfNumber = 0;
            for (int i = input.indexOf("@"); i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if (Character.isDigit(currentSymbol) && input.charAt(i - 1) == ' ') {
                    firstIndexOfNumber = i;
                    break;
                }
            }

            if (firstIndexOfNumber == 0) {
                input = scanner.nextLine();
                continue;
            }

            String venue = input.substring(input.indexOf("@") + 1, firstIndexOfNumber).trim();
            String numbers = input.substring(firstIndexOfNumber);
            String[] numbersArray = numbers.split("\\s+");

            if (numbersArray.length != 2) {
                input = scanner.nextLine();
                continue;
            }

            int ticketPrice = Integer.parseInt(numbersArray[0]);
            int ticketCount = Integer.parseInt(numbersArray[1]);

            if (!concerts.containsKey(venue)) {
                concerts.put(venue, new LinkedHashMap<>());
                concerts.get(venue).put(singer, ticketPrice * ticketCount);
            } else {
                if (concerts.get(venue).containsKey(singer)) {
                    concerts.get(venue).put(singer, concerts.get(venue).get(singer) + ticketPrice * ticketCount);
                } else {
                    concerts.get(venue).put(singer, ticketPrice * ticketCount);
                }
                concerts.put(venue, concerts.get(venue));
            }
            input = scanner.nextLine();
        }

        concerts.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                    .forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
        });
    }
}
