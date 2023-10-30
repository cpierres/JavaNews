package exo.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamCollectCollectingAndThen {
    public static void main(String[] args) {
        List<String> elements = Arrays.asList("elem1", "elem2", "elem3", "elem4");
        List<String> resultats = elements.stream()
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(resultats.getClass().getName());

    }
}