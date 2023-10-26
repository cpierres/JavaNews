package exo.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamSorted {
    public static void main(String[] args) {
        List<String> prenoms = Arrays.asList("andre", "benoit", "albert", "thierry", "alain");
        prenoms.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("tri par ordre décroissant: ");
        prenoms.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("tri sur longueur de chaine puis sur ordre naturel décroissant");
        prenoms.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()).reversed())
                .forEach(System.out::println);
    }
}
