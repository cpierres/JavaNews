package exo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * partitioningBy() est une spécialisation de la méthode groupingBy(). Elle
 * attend en paramètre un Predicate pour grouper les éléments selon la valeur
 * booléenne retournée par le Predicate. La collection de type Map retournée
 * possède donc forcément un booléen comme clé.
 */
public class StreamCollectPartitioningBy {
    public static void main(String[] args) {
        Stream<String> chaines = Stream.of("aaa", "bb", "ccccc");
        Map<Boolean, List<String>> map = chaines.collect(
                Collectors.partitioningBy(s -> s.length() >= 3));
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("Thierry", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("Thierry", "p1", Genre.HOMME, 176));

        Map<Boolean, List<Personne>> grandesPersonnes = personnes.stream().distinct()
                .collect(Collectors.partitioningBy(p -> p.getTaille() > 175));
        // System.out.println(grandesPersonnes);
        for (Map.Entry<Boolean, List<Personne>> entry : grandesPersonnes.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}
