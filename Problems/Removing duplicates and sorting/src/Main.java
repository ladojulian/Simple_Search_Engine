import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        final var number = Integer.parseInt(scanner.nextLine());

        Set<String> words = new TreeSet<>();
        for (var i = 0; i < number; i++) {
            words.add(scanner.nextLine());
        }

        for (var word : words) {
            System.out.println(word);
        }
    }
}