package exo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamPeek {

    public static void main(String[] args) {
        List<String> prenoms = Arrays.asList("andre", "benoit", "albert", "thierry", "alain", "jean");

        Stream<String> stream2premiersPrenomA = prenoms.stream().map(prenom -> {
            System.out.println("map: " + prenom);
            return prenom.toUpperCase();
        }).filter(prenom -> {
            System.out.println("filter: " + prenom);
            return prenom.startsWith("A");
        }).peek(prenom -> {
            System.out.println("peek: " + prenom);
        }).limit(2);

        stream2premiersPrenomA.forEach(System.out::println);

        System.out.println(prenoms);// on n'a pas modifié la source de données
    }
}