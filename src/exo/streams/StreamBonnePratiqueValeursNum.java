package exo.streams;

import java.util.stream.Stream;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

public class StreamBonnePratiqueValeursNum {
    public static void main(String[] args) {
        Personne p1 = new Personne("n1", "p1", Genre.HOMME, 176);
        Personne p2 = new Personne("n2", "p1", Genre.HOMME, 190);
        Personne p3 = new Personne("n3", "p1", Genre.FEMME, 172);

        // Pour éviter des opérations d'autoboxing et donc d'améliorer les performances,
        // pas recommandé d'effectuer des calculs sur des wrappers de type
        // primitif numérique.
        int sommeBad = Stream.of(p1, p2, p3)
                .map(p -> p.getTaille())
                .reduce(0, (a, b) -> a + b);
        System.out.println(sommeBad);

        // préférable d'utiliser un IntStream, LongStream ou DoubleStream pour améliorer
        // les performances, réduire le nombre d'objets créés et réduire la quantité de
        // code nécessaire.
        // Ci-dessous, on utilise mapToInt à la place de map
        int sommeGood = Stream.of(p1, p2, p3)
                .mapToInt(p -> p.getTaille())
                .sum();
        System.out.println(sommeGood);
    }
}
