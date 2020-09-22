import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        final var chars1 = scanner.nextLine().toLowerCase().toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        for (var c : chars1) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        final var chars2 = scanner.nextLine().toLowerCase().toCharArray();
        Map<Character, Integer> map2 = new HashMap<>();
        for (var c : chars2) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        var result = 0;
        for (var c : map1.keySet()) {
            if (map2.getOrDefault(c, 0) == 0) {
                result += map1.get(c);
            } else {
                result += Math.abs(map1.get(c) - map2.get(c));
            }
        }

        for (var c : map2.keySet()) {
            if (map1.getOrDefault(c, 0) == 0) {
                result += map2.get(c);
            }
        }

        System.out.println(result);
    }
}