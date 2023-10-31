package exo.streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamBonnePratiqueMax {
    public static void main(String[] args) {
        Stream<String> prenoms = Stream.of("pierre", "anne", "sophie", "thierry", "antoine");

        // pas utile de trier les éléments dans un ordre décroissant et de prendre le
        // premier pour rechercher le plus grand élément.
        Optional<String> premierBad = prenoms.sorted(Comparator.reverseOrder())
                .findFirst();
        System.out.println(premierBad.orElse("inconnu"));

        // préférable d'utiliser l'opération max() du Stream
        Optional<String> premierGood = prenoms.max(Comparator.naturalOrder());
        System.out.println(premierGood.orElse("inconnu"));
    }
}
