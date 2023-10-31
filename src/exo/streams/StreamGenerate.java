package exo.streams;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * generate() permet de créer un Stream infini en lui passant en paramètre un
 * Supplier qui aura la responsabilité de créer de nouveaux éléments.
 */
public class StreamGenerate {
    public static void main(String[] args) {
        Stream<UUID> streamUUID = Stream.generate(UUID::randomUUID);
        List<UUID> valeurs = streamUUID.limit(5).collect(Collectors.toList());
        System.out.println(valeurs);
    }
}
