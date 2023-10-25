package exo.streams;

import java.util.stream.Stream;

/**
 * la méthode iterate() attend en paramètre une valeur initiale et un
 * UnaryOperator qui sera invoqué pour générer chaque nouvelle valeur.
 * On définit une condition d'arrêt avec la méthode limit(maxSize).
 * C'est la méthode terminale qui déclenche l'exécution.
 */
public class StreamInfiniAvecIterate {
    public static void main(String[] args) {
        Stream<Integer> entiers = Stream.iterate(0, n -> n + 1);
        entiers.limit(1000).forEach(System.out::println);
    }
}
