package SetsAndMapsAdvancedExercises;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Set<String>> playerCards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(":\\s+");
            String name = tokens[0];
            String[] inputCards = tokens[1].split(",\\s+");

            playerCards.putIfAbsent(name, new LinkedHashSet<>());
            Set<String> strings = playerCards.get(name);
            Collections.addAll(strings, inputCards);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : playerCards.entrySet()) {
            int sum = 0;
            for (String currentCard : entry.getValue()) {
                if (currentCard.contains("10")) {
                    String multiplier = currentCard.replace("10", "");
                    sum += 10 * getTypeOfCard(multiplier.charAt(0));
                } else {
                    char powerOfCard = currentCard.charAt(0);
                    char typeOfCard = currentCard.charAt(1);
                    sum += getPowerOfCard(powerOfCard) * getTypeOfCard(typeOfCard);
                }
            }
            System.out.println(entry.getKey() + ": " + sum);
        }
    }

    public static int getTypeOfCard(char typeOfCard) {
        switch (typeOfCard) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
        }
        return typeOfCard;
    }

    public static int getPowerOfCard(char powerOfCard) {
        switch (powerOfCard) {
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
                return powerOfCard - 48;
        }
    }
}
