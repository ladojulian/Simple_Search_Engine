import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        var range = scanner.nextLine().split(" ");
        var from = Integer.parseInt(range[0]);
        var to = Integer.parseInt(range[1]) + 1;

        var number = Integer.parseInt(scanner.nextLine());

        var map = new TreeMap<Integer, String>();

        for (var i = 0; i < number; i++) {
            var item = scanner.nextLine().split(" ");
            map.put(Integer.parseInt(item[0]), item[1]);
        }

        for (var item : map.subMap(from, to).entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}