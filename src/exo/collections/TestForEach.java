package exo.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * voir équivalent en Stream dans
 * {@link #TestStreamSomme10premiers}
 */
public class TestForEach {
    public static void main(String[] args) {
        List<Integer> entiers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        //long somme = 0;
        LongAdder somme = new LongAdder();
        entiers.forEach(valeur -> {
            if(valeur < 10) {
                //somme = somme + valeur;
                somme.add(valeur);
            }
        });
        System.out.println(somme);
    }
}
