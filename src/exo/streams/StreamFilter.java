package exo.streams;

import java.util.Arrays;
import java.util.List;

public class StreamFilter {
    public static void main(String[] args) {
        List<String> prenoms = Arrays.asList("andre", "benoit", "albert", "thierry", "alain",
                "jean");

        // 2 filters successifs sont possibles
        prenoms.stream()
                .filter(p -> p.startsWith("a"))
                .filter(p -> p.length() == 5)
                .forEach(System.out::println);

        // mais préférable de regrouper les filtres lorsque cela est possible
        prenoms.stream()
                .filter(p -> p.startsWith("a") && p.length() == 5)
                .forEach(System.out::println);
    }
}
