package exo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StreamCollectAvecCombinerPourConcatViaStringJoiner {
    public static void main(String[] args) {
        List<String> elements = Arrays.asList("elem1", "elem2", "elem2", "elem3", "elem4");
        StringBuilder concat = elements.stream()
                .collect(() -> new StringBuilder(), (sb, s) -> sb.append(";")
                        .append(s), (sb1, sb2) -> sb1.append(sb2));
        System.out.println(concat.toString());

        // ok mais bcp de code
        StringBuilder concat2 = elements.stream()
                .collect(() -> new StringBuilder(), (sb, s) -> {
                    if (sb.length() != 0) {
                        sb.append(";");
                    }
                    sb.append(s);
                }, (sb1, sb2) -> sb1.append(sb2));
        System.out.println(concat2.toString());

        // solution avec StringJoiner
        StringJoiner elmtJoiner = elements.stream()
                .collect(() -> new StringJoiner(";"),
                        (j, e) -> j.add(e),
                        (j1, j2) -> j1.merge(j2));
        System.out.println(elmtJoiner.toString());

    }
}
