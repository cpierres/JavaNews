package exo.streams;

import java.util.ArrayList;
import java.util.List;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

public class StreamReduce1 {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p1", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("p5", "p1", Genre.HOMME, 176));

        //le reduce est appliqué sur chaque ligne jusqu'à obtenir la personne le plus grande
        personnes.stream().reduce((p1, p2) -> p1.getTaille() > p2.getTaille() ? p1 : p2).ifPresent(System.out::println);
    }
}
