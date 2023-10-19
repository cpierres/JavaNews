package exo.optional;

import java.util.Optional;

public class OptionalIfPresent {
    public static void main(String[] args) {
        // réaliser des actions uniquement si l'Optional n'est pas vide via la méthode
        // Optional.ifPresent
        // Optional non vide
        Optional<String> myNullable = Optional.ofNullable("Angel");
        myNullable.ifPresent(x -> System.out.println(x)); // Angel
        //équivalent :
        myNullable.ifPresent(System.out::println); // Angel

        // Optional vide
        Optional<String> myNullable2 = Optional.empty();
        myNullable2.ifPresent(x -> System.out.println(x)); // lambda non exécutée

    }
}
