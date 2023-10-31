package exo.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamBonnePratiqueTableau {
    public static void main(String[] args) {
        String[] prenomsTab = { "alain", "anne", "sophie", "thierry", "antoine", "pierre" };

        // pas utile de créer une collection avec les éléments du tableau et demander un
        // Stream
        Stream<String> prenoms = Arrays.asList(prenomsTab).stream();

        // préférable d'utiliser la méthode of() de l'interface Stream ou la méthode
        // stream() de la classe Arrays
        Stream<String> prenoms2 = Stream.of(prenomsTab);
        Stream<String> prenoms3 = Arrays.stream(prenomsTab);
    }
}
