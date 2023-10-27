package exo.streams;

import java.util.Arrays;
import java.util.List;

public class StreamCollectAvecCombinerPourConcat {
    public static void main(String[] args) {
        List<String> elements = Arrays.asList("elem1", "elem2", "elem2", "elem3", "elem4");

        /*
         * collect() peut aussi être utilisée pour effectuer une opération de réduction
         * qui va permettre de combiner deux éléments pour obtenir un nouvel élément qui
         * sera combiné à son tour à l'élément suivant et ainsi de suite jusqu'à ce que
         * tous les éléments soient traités
         */
        StringBuilder stringBuilder = elements.stream().collect(() -> new StringBuilder(), (sb, s) -> sb.append(s),
                (sb1, sb2) -> sb1.append(sb2));
        System.out.println(stringBuilder.toString());

        //syntaxe avec référence de méthode
        StringBuilder stringBuild2 = elements.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(stringBuild2.toString());

    }
}
