import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        var isEven = true;
        while (scanner.hasNextInt()) {
            if (isEven) {
                scanner.nextInt();
            } else {
                list.add(scanner.nextInt());
            }
            isEven = !isEven;
        }

        for (var i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}