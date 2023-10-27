package exo.streams;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * permet de parcourir dans une itération extérieure tous les éléments d'un
 * Stream
 */
public class StreamIterator {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a", "b", "c");

        Iterator<String> it = stream.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        // // 2ème iteration pas possible
        // it = stream.iterator();
        // while (it.hasNext()) {
        // String s = it.next();
        // System.out.println(s);
        // }

    }
}
