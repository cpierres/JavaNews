package exo.streams;

import java.util.Arrays;
import java.util.List;

public class StreamMapVsFlatMap2 {
    public static void main(String[] args) {
        List<Integer> nombres = Arrays.asList(1, 3, 5, 7, 9);

        // on crée une paire de valeur (valeur -1 et valeur) à partir d'une collection
        // de nombres.
        // La valeur retournée par map est ainsi une List de List d'Integer.
        List<List<Integer>> tuples = nombres.stream().map(i -> Arrays.asList(i, i - 1)).toList();
        System.out.println(tuples);

        // même exemple que précédemment mais utilisant une opération flatMap()
        // afin de renvoyer une List d'Integer dont toutes les valeurs ont été mises à
        // plat.
        List<Integer> tuplesAplat = nombres.stream().flatMap(i -> Arrays.asList(i - 1, i).stream()).toList();
        System.out.println(tuplesAplat);
    }
}
