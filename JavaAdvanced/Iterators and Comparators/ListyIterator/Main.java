package ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        List<String> elements = Arrays
                .stream(command.split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(elements);

        while (!command.equals("END")) {

            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
