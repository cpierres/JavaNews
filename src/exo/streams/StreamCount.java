package exo.streams;

import java.util.stream.Stream;

public class StreamCount {
    public static void main(String[] args) {
        Stream<Integer> nombres = Stream.of(1, 2, 3, 4, 5).filter(e -> (e % 2) == 0);
        System.out.println("Nb elements=" + nombres.count());
    }

}
