import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        var newspaperWords = scanner.nextLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (var word : newspaperWords) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        var noteWords = scanner.nextLine().split(" ");
        for (var word : noteWords) {
            if (map.getOrDefault(word, 0) != 0) {
                map.put(word, map.get(word) - 1);
            } else {
                System.out.println("You are busted");
                return;
            }
        }
        System.out.println("You get money");
    }
}