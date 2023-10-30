package exo.streams;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

public class StreamCollectGroupingBy {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("Martin", "Christophe", Genre.HOMME, 190));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("Thierry", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("Thierry", "p1", Genre.HOMME, 176));

        Map<Genre, List<Personne>> personnesParGenre = personnes.stream()
                .collect(Collectors.groupingBy(Personne::getGenre));
        // System.out.println(personnesParGenre);
        // solution 1 d'affichage :
        personnesParGenre.forEach((genre, personnesDuGenre) -> System.out.format("%s :%s\n", genre, personnesDuGenre));
        // solution 2 d'affichage :
        for (Map.Entry<Genre, List<Personne>> entry : personnesParGenre.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // au lieu de récupérer une Liste de Personnes (issue du Stream), on récupère
        // pour chaque groupe un Set des noms uniquement (grâce à Collectors.mapping).
        // mapping() renvoie un Collector qui va transformer les objets de type T en
        // type U grâce à la Function avant d'appliquer le downstream Collector
        Map<Genre, Set<String>> nomsGroupesParGenre = personnes.stream()
                .collect(Collectors.groupingBy(Personne::getGenre,
                        Collectors.mapping(Personne::getNom, Collectors.toSet())));
        System.out.println(nomsGroupesParGenre);

        // faire l'équivalent d'un GROUP BY sql
        // Une surcharge de la méthode groupBy() qui attend en second paramètre un objet
        // de type Collector, permet d'appliquer le Collector pour réduire les éléments
        // du groupe et ainsi obtenir la valeur associée à la clé.
        Stream<String> mots = Stream.of("aa", "bb", "aa", "bb", "cc", "bb");
        Map<String, Long> comptageDesMots = mots.collect(
                Collectors.groupingBy(s -> s.toUpperCase(), Collectors.counting()));
        for (Map.Entry entry : comptageDesMots.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        // regroupement à 2 niveaux (collect avec 2 groupingBy)
        Map<Genre, Map<Integer, List<Personne>>> personnesGroupeesParGenreEtTaille = personnes.stream().distinct()
                .collect(Collectors.groupingBy(Personne::getGenre, groupingBy(Personne::getTaille)));
        System.out.println(personnesGroupeesParGenreEtTaille);

        // Traitement plus complexe :
        // Déterminer la taille la plus élevée par genre d'une collection de personnes
        Map<Genre, Integer> tailleMaxParGenre = personnes.stream().distinct()
                .collect(Collectors.groupingBy(Personne::getGenre, Collectors.mapping(Personne::getTaille,
                        Collectors.collectingAndThen(Collectors.maxBy(Integer::compare), d -> d.get().intValue()))));
        System.out.println(tailleMaxParGenre);
    }
}