package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static Scanner scanner;

    private static Map<String, Set<Integer>> invertedIndex;
    private static final List<String> persons = new ArrayList<>();

    public static void main(String[] args) {
        try {
            final var file = new File(args[1]);
            scanner = new Scanner(file);

            invertedIndex = insertDataset();

            scanner = new Scanner(System.in);
            var option = 0;
            do {
                option = printMenu();

                switch (option) {
                    case 1:
                        System.out.println("Select a matching strategy: ALL, ANY, NONE");
                        var searchOption = scanner.nextLine();
                        var result = searchPerson(searchOption);
                        System.out.println(result);
                        break;
                    case 2:
                        printPeople();
                        break;
                    case 0:
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Incorrect option! Try again.");
                        break;
                }
            } while (option != 0);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static void printPeople() {
        System.out.println("=== List of people ===");
        for (var person : persons) {
            System.out.println(person);
        }
    }

    private static int printMenu() {
        System.out.println(
                "=== Menu ===\n" +
                        "1. Find a person\n" +
                        "2. Print all people\n" +
                        "0. Exit\n");

        return Integer.parseInt(scanner.nextLine());
    }

    private static Map<String, Set<Integer>> insertDataset() {
        var map = new HashMap<String, Set<Integer>>();
        var i = 0;
        while (scanner.hasNextLine()) {
            var line = scanner.nextLine();
            persons.add(line);

            var words = line.toLowerCase().split(" ");
            for (var word : words) {
                var set = map.getOrDefault(word, new HashSet<>());
                set.add(i);
                map.put(word, set);
            }
            i++;
        }
        return map;
    }

    private static String searchPerson(String searchOption) {
        System.out.println("Enter a name or email to search all suitable people:");
        final var words = scanner.nextLine().toLowerCase().split(" ");

        var result = new StringBuilder();
        Set<Integer> set;
        switch (searchOption) {
            case "ALL":
                set = searchAllStrategy(words);
                break;
            case "ANY":
                set = searchAnyStrategy(words);
                break;
            case "NONE":
                set = searchNoneStrategy(words);
                break;
            default:
                return "";
        }

        if (set == null) {
            result.append("No matching people found.");
        } else {
            result.append(set.size()).append(" persons found:\n");
            for (var item : set) {
                result.append(persons.get(item)).append('\n');
            }
        }

        return result.toString();
    }

    private static Set<Integer> searchAllStrategy(String[] words) {
        Set<Integer> resultSet = null;
        for (var word : words) {
            var set = invertedIndex.get(word);
            if (set == null) {
                return new HashSet<>();
            }

            if (resultSet == null) {
                resultSet = new HashSet<>(set);
            } else {
                resultSet.retainAll(set);
            }
        }
        return resultSet;
    }

    private static Set<Integer> searchAnyStrategy(String[] words) {
        Set<Integer> resultSet = null;
        for (var word : words) {
            var set = invertedIndex.get(word);
            if (resultSet == null) {
                resultSet = new HashSet<>(set);
            } else {
                resultSet.addAll(set);
            }
        }
        return resultSet;
    }

    private static Set<Integer> searchNoneStrategy(String[] words) {
        var resultSet = new HashSet<Integer>();
        for (var item : invertedIndex.entrySet()) {
            resultSet.addAll(item.getValue());
        }

        Set<Integer> unionSet = null;
        for (var word : words) {
            var set = invertedIndex.get(word);
            if (unionSet == null) {
                unionSet = new HashSet<>(set);
            } else {
                unionSet.addAll(set);
            }
        }

        resultSet.removeAll(unionSet);

        return resultSet;
    }
}
