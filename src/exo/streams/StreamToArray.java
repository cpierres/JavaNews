package exo.streams;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamToArray {
    public static void main(String[] args) {
        // Si le type du tableau n'est pas important, il est possible d'utiliser la
        // méthode toArray() sans paramètre
        Stream<String> stream1 = Stream.of("a", "b", "c");
        Object[] objects = stream1.toArray();
        System.out.println(Arrays.toString(objects));

        Stream<String> stream2 = Stream.of("a", "b", "c");
        String[] strings2 = stream2.toArray(size -> new String[size]);
        System.out.println(Arrays.toString(strings2));

        Stream<String> stream3 = Stream.of("a", "b", "c");
        String[] strings3 = stream3.toArray(String[]::new);
        System.out.println(Arrays.toString(strings3));

        // La méthode toArray() est utilisable sur n'importe quel Stream y compris sur
        // les Streams primitifs
        Integer[] integerArray = Stream.of(1, 2, 3, 4, 5).toArray(Integer[]::new);
        int[] intArray = IntStream.of(1, 2, 3, 4, 5).toArray();
        long[] longArray = LongStream.of(1, 2, 3, 4, 5).toArray();
        double[] doubleArray = DoubleStream.of(1, 2, 3, 4, 5).toArray();

    }
}
