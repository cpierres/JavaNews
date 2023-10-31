package exo.streams;

import java.io.PrintStream;
import java.util.stream.IntStream;

/**
 * Dans le code ci-dessous, l'exécution de la méthode sorted() pour chaque
 * élément se fait toujours dans le même thread ce qui n'est pas forcément le
 * comportement attendu vu que le Stream est parallèle.<br>
 * En fait, l'implémentation de la méthode sorted() utilise la méthode
 * parallelSort() de la classe Arrays. Les traitements de cette méthode sont
 * exécutés de manière séquentielle jusqu'à un certain nombre d'éléments et une
 * fois ce nombre atteint les traitements sont effectués en parallèle.<br>
 * L'exemple StreamParalleleSort2 montre qu'avec plus de lignes à traiter
 * le parallèlisme est bien mis en oeuvre.
 */
public class StreamParalleleSort {

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
                .sorted((s1, s2) -> {
                    afficher("sorted ", s1 + "/" + s2);
                    return s1.compareTo(s2);
                })
                .forEach(s -> afficher("forEach ", s));
    }
}
