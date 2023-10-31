package exo.streams;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Une fois qu'un Stream a été exécuté, il ne peut plus être réutilisé. Dès
 * qu'une opération terminale est invoquée, celle-ci ferme le Stream.<br>
 * Pour contourner cette limitation, il faut créer un nouveau Stream pour chaque
 * utilisation. Si la configuration du Stream est complexe, il est possible de
 * définir un Supplier dont le rôle sera de créer une instance à chaque
 * invocation.
 */
public class StreamDoubleAppel {
    public static void main(String[] args) {
        Supplier<Stream<String>> supplier = () -> Stream.of("a1", "a2", "a3")
                .filter(s -> s.startsWith("a"));
        supplier.get().forEach(System.out::println);
        supplier.get().forEach(System.out::println);
    }
}
