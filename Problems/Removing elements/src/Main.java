import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        var strs = str.split(" ");
        var ints = new Integer[strs.length];
        for (var i = 0; i < strs.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }
        return new LinkedHashSet<>(Set.of(ints));
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        var numbersToDelete = new HashSet<Integer>();
        for (var number : set) {
            if (number > 10) {
                numbersToDelete.add(number);
            }
        }
        set.removeAll(numbersToDelete);
    }
}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}