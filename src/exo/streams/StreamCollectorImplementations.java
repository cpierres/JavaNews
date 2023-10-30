package exo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * Il est possible de développer sa propre implémentation de l'interface
 * Collector pour définir des opérations de réductions personnalisées si
 * celles-ci ne sont pas fournies par le JDK.<br>
 * L'interface Collector implémentée doit être typée avec 3 génériques :
 * <ul>
 * <li>T : le type des objets qui seront traités</li>
 * <li>A : le type de l'objet utilisé comme accumulator</li>
 * <li>R : le type de l'objet qui sera retourné comme résultat</li>
 * </ul>
 * Il est courant que les types A et R soient identiques : c'est par exemple le
 * cas pour un type de l'API Collection. Mais ils peuvent être différents par
 * exemple un accumulator de type StringBuilder et un résultat de type
 * String.<br>
 * L'implémentation d'un Collector peut se faire de deux manières :
 * <ul>
 * <li>Utiliser une des surcharges de la fabrique of() de l'interface Collector
 * : elle permet de créer des Collector simples</li>
 * <li>Définir une classe qui implémente l'interface Collector : pour des cas
 * plus complexes ou des besoins particuliers</li>
 * </ul>
 */
public class StreamCollectorImplementations {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("n1", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("n2", "p2", Genre.HOMME, 190));
        personnes.add(new Personne("n3", "p3", Genre.FEMME, 172));
        personnes.add(new Personne("n4", "p4", Genre.FEMME, 162));
        personnes.add(new Personne("n5", "p5", Genre.HOMME, 175));

        // Implémentation d'un Collector personnalisé avec Collector.of
        Collector<Personne, StringJoiner, String> nomsCollector = Collector.of(() -> new StringJoiner(","), // supplier
                (sj, pers) -> sj.add(pers.getNom().toUpperCase()), // accumulator
                (sj1, sj2) -> sj1.merge(sj2), // combiner
                StringJoiner::toString);// finisher

        /*
         * Le Collector utilise la classe StringJoiner de Java 8 pour concaténer les
         * prénoms des personnes dans ses traitements :
         * <ul>
         * <li>Le supplier fournit une instance de StringJoiner avec le délimiteur à
         * utiliser</li>
         * <li>L'accumulator utilise la méthode add() du StringJoiner pour concaténer
         * chaque prénom mis en majuscules en les séparant par une virgule</li>
         * <li>Le combiner utilise la méthode merge() pour fusionner les deux
         * StringJoiner fournis en paramètre</li>
         * <li>Le finisher utilise la méthode toString() du StringJoiner pour fournir le
         * résultat final sous la forme d'une chaîne de caractères. Son utilisation est
         * nécessaire car le type du Supplier et le type renvoyé du Collector sont
         * différents</li>
         * </ul>
         */

        String noms = personnes.stream().collect(nomsCollector);
        System.out.println(noms);
    }
}
