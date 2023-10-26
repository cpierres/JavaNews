package exo.streams;

import java.util.Arrays;
import java.util.List;

public class StreamDistinct {
    public static void main(String[] args) {
        List<Integer> entiers = Arrays.asList(1, 2, 3, 1, 2, 3);
        //distinct filtre les doublons en se basant sur la méthode equals().
        entiers.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
