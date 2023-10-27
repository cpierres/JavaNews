package exo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamReduceAvecValInitiale {
    public static void main(String[] args) {
        List<Integer> entiers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer total = entiers.stream()
                .reduce(0, (valeurAccumulee, valeur) -> valeurAccumulee + valeur);
        System.out.println("total=" + total);

        // Parfois en fonction de l'opération d'agrégation, il faut prendre des
        // précautions avec la valeur initiale
        int produit = Stream.of(1, 2, 3, 4, 5)
                .reduce(0, (a, b) -> a * b);
        System.out.println(produit);// Attention, donnera 0 si valeur initiale est 0 !
        int produitOk = Stream.of(1, 2, 3, 4, 5)
                .reduce(1, (a, b) -> a * b);
        System.out.println(produitOk);// ok si valeur initiale est 1

        Integer max = Stream.of(1, 2, 3, 4, 5).reduce(0, Integer::max);
        System.out.println(max);

    }
}