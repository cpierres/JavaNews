package exo.streams;

import java.util.stream.Stream;

public class StreamReducePourConcat {
    public static void main(String[] args) {
        String lettres = Stream.of("a", "b", "c", "d")
                .reduce((accumulator, item) -> accumulator + ", " + item).orElse("");
        System.out.println(lettres);
    }
}
