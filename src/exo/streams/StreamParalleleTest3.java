package exo.streams;

import java.io.PrintStream;
import java.util.stream.IntStream;

public class StreamParalleleTest3 {
    private static PrintStream afficher(String methode, String valeur) {
        return System.out.format("%s: %s [%s]\n", methode, valeur,
                Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // C'est la dernière de ces opérations qui sera utilisée pour déterminer le mode
        // d'exécution.
        // Dans le cas ci-dessous, on a parallel() puis sequential()
        // donc c sequential() qui l'emporte.
        IntStream
                .rangeClosed(1, 5)
                .parallel()
                .mapToObj(v -> {
                    afficher("mapToObj", "e" + v);
                    return "e" + v;
                })
                .filter(s -> {
                    afficher("filter ", s);
                    return true;
                })
                .map(s -> {
                    afficher("map ", s);
                    return s.toUpperCase();
                })
                .sequential()
                .forEach(s -> afficher("forEach ", s));
    }
}