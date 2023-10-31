package exo.streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Certains Collector sont conçus pour être utilisés comme des downstreams
 * Collector de l'opération groupingBy(). Il n'est pas nécessaire de les
 * utiliser à la place des opérations de l'interface Stream équivalente.
 */
public class StreamBonnePratiqueCollectorNotUseful {
    public static void main(String[] args) {
        Stream<String> prenoms = Stream.of("pierre", "anne", "sophie", "thierry", "antoine");

        // pour compter simplement les éléments d'un Stream, pas utile d'utiliser le
        // Collector obtenu par la fabrique counting()
        long nbBad = prenoms.collect(Collectors.counting());
        System.out.println(nbBad);

        // préférable d'utiliser l'opération count() de l'interface Stream
        prenoms = Stream.of("pierre", "anne", "sophie", "thierry", "antoine");
        long nbGood = prenoms.count();
        System.out.println(nbGood);

        // pour déterminer le plus petit ou le plus grand élément d'un Stream,
        // pas utile d'utiliser le Collector obtenu par la fabrique minBy() ou maxBy().
        prenoms = Stream.of("pierre", "anne", "sophie", "thierry", "antoine");
        Optional<String> plusGrandBad = prenoms.collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(plusGrandBad.orElse("inconnu"));

        // préférable d'utiliser l'opération min() ou max() de l'interface Stream
        prenoms = Stream.of("pierre", "anne", "sophie", "thierry", "antoine");
        Optional<String> plusGrandGood = prenoms.max(Comparator.naturalOrder());
        System.out.println(plusGrandGood.orElse("inconnu"));

        // De la même manière, il est préférable d'utiliser :
        // - L'opération reduce() plutôt que le Collector obtenu par la méthode
        // reducing() de la classe Collectors
        // - L'opération map() plutôt que le Collector obtenu par la méthode mapping() de
        // la classe Collectors
        //  -L'opération filter() plutôt que le Collector obtenu par la méthode
        // filtering() de la classe Collectors
        // -L'opération flatMap() plutôt que le Collector obtenu par la méthode
        // flatMapping() de la classe Collectors

    }
}
