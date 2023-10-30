package exo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

public class StreamCollectToXxx {
        public static void main(String[] args) {
                List<Personne> personnes = new ArrayList<>(6);

                personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
                personnes.add(new Personne("p4", "p1", Genre.FEMME, 172));
                personnes.add(new Personne("Thierry", "p1", Genre.HOMME, 176));
                personnes.add(new Personne("p3", "p1", Genre.FEMME, 162));
                personnes.add(new Personne("Thierry", "p1", Genre.HOMME, 176));

                List<Personne> hommesList = personnes.stream().filter(p -> p.getGenre() == Genre.HOMME)
                                .collect(Collectors.toList());
                System.out.println(hommesList);

                // pour filtrer les doublons, Personne doit implémnter equals et hashCode
                Set<Personne> hommesSet = personnes.stream().filter(p -> p.getGenre() == Genre.HOMME)
                                .collect(Collectors.toSet());
                System.out.println(hommesSet);

                Set<Personne> hommesSetTriParNom = personnes.stream().filter(p -> p.getGenre() == Genre.HOMME)
                                .collect(Collectors.toCollection(
                                                () -> new TreeSet<Personne>(Comparator.comparing(Personne::getNom))));
                System.out.println(hommesSetTriParNom);

                List<String> elements = Arrays.asList("elem4", "element2", "element2", "elem1", "elem3");
                Set<String> resultats = elements.stream().collect(Collectors.toCollection(TreeSet::new));
                System.out.println(resultats);

                Set<String> resultatSet = elements.stream().collect(Collectors.toCollection(HashSet::new));
                System.out.println(resultatSet);

                Map<String, Integer> resultatsMap = elements.stream().distinct().collect(Collectors.toMap(Function.identity(),
                                String::length));
                System.out.println(resultatsMap);// on ne peut pas avoir de doublon (distinct) sur la clé sinon
                                                 // duplicateKeyException

                Map<Integer, String> resultatsMap2 = elements.stream()
                                .collect(Collectors.toMap(String::length, Function.identity(), (s1, s2) -> s1));
                System.out.println(resultatsMap2);// retourne le 1er élement de chaque taille

                Map<Integer, String> resultatsMap3 = elements.stream()
                                .collect(Collectors.toMap(String::length, Function.identity(), (s1, s2) -> s1 + ";" + s2));
                System.out.println(resultatsMap3);// concatène les éléments de chaque taille

        }
}