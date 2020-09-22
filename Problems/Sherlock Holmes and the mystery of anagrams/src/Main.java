import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        final var word1 = scanner.nextLine().toLowerCase().toCharArray();

        Map<Character, Integer> map1 = new HashMap<>();
        for (var letter : word1) {
            map1.put(letter, map1.getOrDefault(letter, 0) + 1);
        }

        final var word2 = scanner.nextLine().toLowerCase().toCharArray();

        Map<Character, Integer> map2 = new HashMap<>();
        for (var letter : word2) {
            map2.put(letter, map2.getOrDefault(letter, 0) + 1);
        }

        System.out.println(map1.equals(map2) ? "yes" : "no");
    }
}