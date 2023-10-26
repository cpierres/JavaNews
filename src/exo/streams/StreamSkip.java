package exo.streams;

import java.util.Arrays;
import java.util.List;

public class StreamSkip {
    public static void main(String[] args) {
        List<Integer> entiers = Arrays.asList(1, 2, 3, 4, 5, 6);
        entiers.stream()
                .skip(3)
                .forEach(System.out::println);
    }
}
