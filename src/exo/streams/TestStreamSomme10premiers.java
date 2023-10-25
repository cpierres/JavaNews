package exo.streams;

import java.util.Arrays;
import java.util.List;

/**
 * voir équivalent en classique dans : 
 * {@link exo.collections.TestForEach}
 */
public class TestStreamSomme10premiers {
    public static void main(String[] args) {
        List<Integer> entiers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        // parallelStream() pour faire traitement en parallèle
        long somme = entiers.parallelStream().filter(v -> v < 10).mapToInt(i -> i).sum();
        System.out.println(somme);

        long somme2 = entiers.stream().filter(v -> v > 10).mapToInt(i -> i).sum();
        System.out.println(somme2);
    }
}
