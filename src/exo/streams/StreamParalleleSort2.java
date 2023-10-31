package exo.streams;

import java.io.PrintStream;
import java.util.stream.IntStream;

/**
 * Si le nombre d'éléments à traiter est important, alors l'exécution de la
 * méthode sorted() se fait bien en parallèle.<br>
 * Certaines opérations, comme reduce() ou collect() ont besoin de traitements
 * supplémentaires lors de l'exécution du Stream en parallèle par rapport à leur
 * exécution en séquentiel notamment pour agréger les résultats issus de chacun
 * des threads.
 */
public class StreamParalleleSort2 {

    private static PrintStream afficher(String methode, String valeur) {
        return System.out.format("%s: %s [%s]\n", methode, valeur,
                Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        IntStream
                .rangeClosed(1, 10000)
                .parallel()
                .mapToObj(v -> {
                    afficher("mapToObj", "e" + v);
                    return "e" + v;
                })
                .sorted((s1, s2) -> {
                    afficher("sorted ", s1 + "/" + s2);
                    return s1.compareTo(s2);
                })
                .forEach(s -> afficher("forEach ", s));
    }
}
