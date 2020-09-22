import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        var longestWord = "";
        for (var i = 0; i < list.size(); i++) {
            if (list.get(i).length() > longestWord.length()) {
                longestWord = list.get(i);
                for (var j = 0; j < i; j++) {
                    list.set(j, longestWord);
                }
            } else {
                list.set(i, longestWord);
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}