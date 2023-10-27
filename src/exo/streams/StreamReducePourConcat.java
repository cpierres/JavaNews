package exo.streams;

import java.util.stream.Stream;

public class StreamReducePourConcat {
    
    public static void main(String[] args) {
        String lettres = Stream.of("a", "b", "c", "d")
                .reduce((accumulator, item) -> accumulator + ", " + item).orElse("");
        System.out.println(lettres);// a, b, c, d

        // attention, si valeur initiale, elle s'ajoute
        String lettres2 = Stream.of("a", "b", "c", "d")
                .reduce("", (accumulator, item) -> accumulator + ", " + item);
        System.out.println(lettres2);// , a, b, c, d

        // Si le Stream ne contient aucun élément, alors c'est la valeur initiale qui
        // est renvoyée.
        String lettres3 = Stream.of("a", "b", "c", "d")
                .limit(0)
                .reduce("X", (accumulator, item) -> accumulator + ", " + item);
        System.out.println(lettres3);// X

    }
}
