import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }

        System.out.println(list);
    }
}