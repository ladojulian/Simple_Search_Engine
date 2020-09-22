import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        var originalAlphabet = scanner.nextLine().toCharArray();
        var symbolAlphabet = scanner.nextLine().toCharArray();

        var encodingMap = new HashMap<Character, Character>();
        var decodingMap = new HashMap<Character, Character>();
        for (var i = 0; i < originalAlphabet.length; i++) {
            encodingMap.put(originalAlphabet[i], symbolAlphabet[i]);
            decodingMap.put(symbolAlphabet[i], originalAlphabet[i]);
        }

        var encoding = scanner.nextLine().toCharArray();
        for (char c : encoding) {
            System.out.print(encodingMap.get(c));
        }
        System.out.println();

        var decoding = scanner.nextLine().toCharArray();
        for (char c : decoding) {
            System.out.print(decodingMap.get(c));
        }
        System.out.println();

    }
}