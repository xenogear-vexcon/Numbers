package Task1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> finalList = new LinkedList<>(intList);
        finalList.removeIf(e -> e <= 0 || e % 2 != 0);
//        finalList.removeIf(e -> e % 2 != 0);
        Collections.sort(finalList);
        for (int e : finalList) {
            System.out.println(e);
        }

    }
}