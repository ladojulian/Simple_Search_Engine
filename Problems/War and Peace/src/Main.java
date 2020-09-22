import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        var map = new HashMap<String, Integer>();
        while (scanner.hasNext()) {
            var word = scanner.next().toLowerCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (var item : map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}