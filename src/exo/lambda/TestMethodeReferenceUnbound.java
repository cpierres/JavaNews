package exo.lambda;

import java.util.Arrays;

public class TestMethodeReferenceUnbound {
    public static void main(String[] args) {
        String[] fruits = {"Melon", "abricot", "fraise", "cerise", "myrtille"};
        Arrays.sort(fruits, String::compareToIgnoreCase);
        System.out.println(Arrays.deepToString(fruits));
    }
}
