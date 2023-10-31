package exo.streams;

import java.io.PrintStream;
import java.util.stream.IntStream;

public class StreamParalleleTest2 {
    private static PrintStream afficher(String methode, String valeur) {
        return System.out.format("%s: %s [%s]\n", methode, valeur,
                Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        //parallel() peut être au début ou à la fin ; cela ne change rien
        //c juste une configuration qui est lancée via la méthode terminale.
        IntStream
                .rangeClosed(1, 5)
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
                .parallel()
                .forEach(s -> afficher("forEach ", s));
    }
}
