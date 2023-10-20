package exo.optional;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Effectuer des traitements alternatifs en fonction d'une nullité par exemple
 */
public class OptionalAlternatif {
    public static void main(String[] args) {
        // Optional.or permet de définir un nouvel Optional si celui d'origine est vide.
        // Dans le cas contraire, celui d'origine est conservé.
        Optional<String> myNullable = Optional.empty();
        System.out.println(myNullable.or(() -> Optional.ofNullable("Claire")));// Optional[Claire]

        // Alternative 1 : avec Arrays.asList(null, "Toto").stream()
        Optional<String> myNullable1 = Arrays.asList(null, "Toto").stream().filter(Objects::nonNull).findFirst();
        System.out.println(myNullable1);

        // Alternative 2 : avec Stream.of + filtre sur nonNUll
        Optional<String> myNullable2 = Stream.of(null, "Alexandre").filter(Objects::nonNull).findFirst();
        System.out.println(myNullable2);// Optional[Alexandre]

        // Alternative 3 : avec un Supplier
        Optional<String> myNullable3 = Stream.<Supplier<String>>of(() -> {
            String aName = null;
            return aName;
        }, () -> "Tintin").map(Supplier::get).filter(Objects::nonNull).findFirst();
        System.out.println(myNullable3);//Optional[Tintin]

    }
}
