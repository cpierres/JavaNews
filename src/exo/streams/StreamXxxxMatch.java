package exo.streams;

import java.util.stream.Stream;

public class StreamXxxxMatch {
    public static void main(String[] args) {
        Stream<Integer> entiers = Stream.of(1, 2, 3, 4, 5);
        boolean auMoinsUnEgalATrois = entiers.anyMatch(e -> e == 3);
        System.out.println(auMoinsUnEgalATrois);

        Stream<Integer> entiers2 = Stream.of(1, 2, 3, 4, 5);
        boolean tousInferieursADix = entiers2.allMatch(e -> e < 10);
        System.out.println(tousInferieursADix);

        Stream<Integer> entiers3 = Stream.of(1, 2, 3, 4, 5);
        boolean tousDifferentsDeDix = entiers3.noneMatch(e -> e == 10);
        System.out.println(tousDifferentsDeDix);
    }

}
