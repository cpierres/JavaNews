package exo.streams;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;

public class StreamCollectJoining {
    public static void main(String[] args) {
        List<String> elements = Arrays.asList("elem1", "elem2", "elem3", "elem4");
        String resultat = elements.stream().collect(joining());
        System.out.println(resultat);

        resultat = elements.stream().collect(joining(", "));
        System.out.println(resultat);

        resultat = elements.stream().collect(joining(", ", "[", "]"));
        System.out.println(resultat);

    }
}
