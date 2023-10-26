package exo.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMapToDouble {
    public static void main(String[] args) {
        Double[] valeurs = { 1.0, 2.0, 3.0, 4.0, 5.0 };

        // cette version fait de l'autoboxing via objet Double
        Double[] valeursAuCarre = Stream.of(valeurs).map(v -> v * v).toArray(Double[]::new);
        System.out.println(Arrays.deepToString(valeursAuCarre));

        // version optimisée grâce à mapToDouble (retourne des primitives)
        double[] valeursAuCarreOptimise = Stream.of(valeurs)
                .mapToDouble(v -> v * v)
                .toArray();
        System.out.println(Arrays.toString(valeursAuCarreOptimise));
    }
}