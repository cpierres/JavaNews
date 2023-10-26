package exo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapVsFlatMap {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList("5", "10", "15", "20").stream().map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(listOfIntegers);

        // si on a une structure plus complexe comme celle-ci (une liste de deux
        // tableaux), flatMap permet de les mettre à plat en les réunissant
        // flatMap(List::stream) permet de créer un nouveau stream à plat
        List<String> listOfStrings = Arrays.asList(Arrays.asList("5", "10"), Arrays.asList("15", "20")).stream()
                .flatMap(List::stream).collect(Collectors.toList());
        System.out.println(listOfStrings);

        listOfIntegers = Arrays.asList(Arrays.asList("5", "10"), Arrays.asList("15", "20")).stream()
                .flatMap(List::stream).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(listOfIntegers);
        
    }
}
