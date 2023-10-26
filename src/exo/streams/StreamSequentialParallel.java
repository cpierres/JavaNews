package exo.streams;

import java.util.stream.Stream;

public class StreamSequentialParallel {
    public static void main(String[] args) {
        // c le dernier mode d'exécution (entre parallel et sequential) appelé qui est
        // pris en compte (donc ici exécution parallel)
        Stream.of(1, 3, 4, 2)
                .sequential()
                .sorted()
                .peek((v) -> System.out.println("peek: " + Thread.currentThread()
                        .getName() + " " + v))
                .parallel()
                .forEach((v) -> System.out.println("forEach: " + Thread.currentThread()
                        .getName() + " " + v));

    }
}
