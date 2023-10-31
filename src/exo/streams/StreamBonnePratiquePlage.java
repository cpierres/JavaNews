package exo.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamBonnePratiquePlage {
    public static void main(String[] args) {
        String[] prenomsTab = { "alain", "anne", "sophie", "thierry", "antoine", "pierre" };

        // pas utile d'utiliser la fabrique range() de l'interface IntStream puis de
        // transformer chaque valeur en l'élément correspondant dans le tableau avec
        // l'opération mapToObj()
        long nbBad = IntStream.range(2, 5)
                .mapToObj(idx -> prenomsTab[idx])
                .count();
        System.out.println(nbBad);

        long nbGood = Arrays.stream(prenomsTab, 2, 5)
                .count();
        System.out.println(nbGood);
    }
}
