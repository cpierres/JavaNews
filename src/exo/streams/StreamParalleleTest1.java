package exo.streams;

import java.io.PrintStream;
import java.util.stream.IntStream;

/**
 * L'exécution des traitements en parallèle n'est pas prédictive. Plusieurs
 * exécutions de ce code donneront un ordre de traces différent.
 * L'API Stream utilise le thread courant et les threads du pool commun de
 * Fork/Join. Chaque thread exécute le pipeline d'opérations pour un
 * sous-ensemble de données, restreint dans l'exemple ci-dessus car le nombre
 * d'éléments est trop faible.
 */
public class StreamParalleleTest1 {
    private static PrintStream afficher(String methode, String valeur) {
        return System.out.format("%s: %s [%s]\n", methode, valeur,
                Thread.currentThread().getName());
    }

    public static void main(String[] args) {
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
                .forEach(s -> afficher("forEach ", s));
    }
}
