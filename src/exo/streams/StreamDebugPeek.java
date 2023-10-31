package exo.streams;

import java.util.stream.Stream;

/**
 * Avec peek décrivant l'opération et la valeur passée, on sait mieux où se
 * situe le pb dans la chaine
 */
public class StreamDebugPeek {
    public static void main(String[] args) {
        Double tailleMoyenne = Stream.of("texte", null, "grand texte")
                .peek(e -> System.out.println("map : " + e))
                .mapToInt(String::length)
                .peek(e -> System.out.println("average : " + e))
                .average()
                .getAsDouble();
        System.out.println("taille moyenne = " + tailleMoyenne);
    }
}
