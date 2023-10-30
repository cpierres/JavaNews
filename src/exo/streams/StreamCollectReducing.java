package exo.streams;

import static java.util.stream.Collectors.reducing;

import java.util.ArrayList;
import java.util.List;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * On peut obtenir le même comportement pour certains de ces Collectors en
 * utilisant des opérations de l'interface Stream notamment min(), max() ou
 * reduce() qu'il est préférable d'utiliser. Cependant l'utilisation de ces
 * Collectors est parfois requise notamment pour combiner des Collectors afin de
 * réaliser des opérations plus complexes essentiellement en tant que downstream
 * Collector.
 * Ces surcharges attendent jusqu'à trois paramètres :
 * <ul>
 * <li>Identity : la valeur initiale qui sera retournée si le Stream est
 * vide</li>
 * <li>Mapper : une fonction à appliquer sur chacun des éléments pour extraire
 * la valeur à utiliser</li>
 * <li>Op : une opération qui combine les valeurs</li>
 * <ul>
 */
public class StreamCollectReducing {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("Thierry", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("Thierry", "p1", Genre.HOMME, 176));

        int tailleTotale = personnes.stream().distinct().collect(reducing(0, Personne::getTaille, Integer::sum));
        System.out.println(tailleTotale);
    }
}
