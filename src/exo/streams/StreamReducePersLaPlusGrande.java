package exo.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

public class StreamReducePersLaPlusGrande {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p1", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("p5", "p1", Genre.HOMME, 176));

        // solution 1 : le reduce est appliqué sur chaque ligne jusqu'à obtenir la
        // personne le plus grande
        personnes.stream().reduce((p1, p2) -> p1.getTaille() > p2.getTaille() ? p1 : p2).ifPresent(System.out::println);

        // solution 2 : utiliser un des BinaryOperator fournis par le JDK
        // (BinaryOperator.maxBy)
        Comparator<Personne> comparatorParTaille = Comparator.comparingInt(Personne::getTaille);
        BinaryOperator<Personne> lePlusGrand = BinaryOperator.maxBy(comparatorParTaille);
        Optional<Personne> plusGrandePersonne = personnes.stream()
                .reduce(lePlusGrand);
        System.out.println(plusGrandePersonne);

    }
}