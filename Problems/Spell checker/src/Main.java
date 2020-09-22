import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        var d = Integer.parseInt(scanner.nextLine());

        Set<String> knownWords = new HashSet<>();
        for (var i = 0; i < d; i++) {
            knownWords.add(scanner.nextLine().toLowerCase());
        }

        var l = Integer.parseInt(scanner.nextLine());

        Set<String> words = new HashSet<>();
        for (var i = 0; i < l; i++) {
            var line = scanner.nextLine().toLowerCase().split(" ");
            words.addAll(Arrays.asList(line));
        }

        words.removeAll(knownWords);

        for (var word : words) {
            System.out.println(word);
        }
    }
}