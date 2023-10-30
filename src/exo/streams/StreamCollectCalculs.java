package exo.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

public class StreamCollectCalculs {
    public static void main(String[] args) {

        List<Personne> personnes = new ArrayList<>(6);

        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("Thierry", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("Thierry", "p1", Genre.HOMME, 176));

        Double tailleMoyenne = personnes.stream().collect(Collectors.averagingDouble(Personne::getTaille));
        System.out.println(tailleMoyenne);

        Double tailleMoyenneSansDoublon = personnes.stream().distinct()
                .collect(Collectors.averagingDouble(Personne::getTaille));
        System.out.println(tailleMoyenneSansDoublon);

        Stream<String> chaines = Stream.of("aaa", "bb", "ccccc");
        Double moyenneLongueur = chaines.collect(Collectors.averagingDouble(String::length));
        System.out.println(moyenneLongueur);

        chaines = Stream.of("aaa", "bb", "ccccc");
        long sommeLongueur = chaines.collect(Collectors.summingLong(String::length));
        System.out.println(sommeLongueur);

        Long nb = personnes.stream().collect(Collectors.counting());
        System.out.println(nb);

        nb = personnes.stream().distinct().collect(Collectors.counting());
        System.out.println(nb);

        // min et max attendent un Comparator pour déterminer l'élément concerné
        chaines = Stream.of("aaa", "bb", "ccccc");
        Optional<String> laPlusGrandeChaine = chaines.collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(laPlusGrandeChaine);

        Optional<Personne> laPlusGrandePersonne = personnes.stream().collect(Collectors.maxBy(Comparator.comparingInt(Personne::getTaille)));
        System.out.println(laPlusGrandePersonne);

        DoubleSummaryStatistics tailleSummary = personnes.stream().distinct()
                .collect(Collectors.summarizingDouble(Personne::getTaille));
        System.out.println(tailleSummary);
        System.out.println(tailleSummary.getMax());

    }
}
