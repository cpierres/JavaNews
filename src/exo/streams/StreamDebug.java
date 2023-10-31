package exo.streams;

import java.util.stream.Stream;

public class StreamDebug {
    public static void main(String[] args) {
            Double tailleMoyenne = Stream.of("texte", null, "grand texte")
       .mapToInt(String::length)
        .average()
        .getAsDouble();
    System.out.println("taille moyenne = " + tailleMoyenne);

    }
}
