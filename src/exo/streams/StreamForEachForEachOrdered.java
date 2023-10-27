package exo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StreamForEachForEachOrdered {
    public static void main(String[] args) {
        List<String> prenoms = Arrays.asList("andre", "benoit", "albert", "thierry", "alain");
        Consumer<String> afficherElement = s -> System.out.println(s + " - " +
                Thread.currentThread().getName());

        System.out.println("stream().sorted().forEach: ");                
        prenoms.stream().sorted().forEach(afficherElement);

        System.out.println("parallelStream().sorted().forEach: ");
        //forEach() sur un Stream parallèle n'est pas déterministe : 
        //elle ne garantit pas dans ce cas le respect de l'ordre des éléments puisque 
        //ceux-ci sont traités par différents threads
        prenoms.parallelStream().sorted().forEach(afficherElement);

        System.out.println("parallelStream().sorted().forEachOrdered: ");
        //garantit l'ordre des éléments du Stream. Pour cela, elle n'utilise 
        //qu'un seul thread pour exécuter l'action sur tous les éléments
        prenoms.parallelStream().sorted().forEachOrdered(afficherElement);

    }
}
