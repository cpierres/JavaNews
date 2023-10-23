package exo.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class TestMethodeReferenceUnboundClasseAno {
    public static void main(String[] args) {
        String[] fruits = {"Melon", "abricot", "fraise", "cerise", "myrtille"};
        //même résultat que TestMethodeReferenceUnbound mais avec une classe anonyme
        Arrays.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        System.out.println(Arrays.deepToString(fruits));
    }
}
