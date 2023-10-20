package exo.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ConversionCollectionEnStreamViaOptional {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, null);

        Stream<Integer> myStream = Optional.ofNullable(myList).stream().flatMap(List::stream);

        System.out.println(myStream.toString());
    }

}
