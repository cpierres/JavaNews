package exo.optional;

import java.util.Optional;

public class OptionalifPresentOrElse {
    public static void main(String[] args) {
        // Optional non vide
        Optional<String> myNullable = Optional.ofNullable("Claire");
        myNullable.ifPresentOrElse(System.out::println, () -> System.out.println("Optional est vide"));// Claire

        // Optional vide
        Optional<String> myNullable2 = Optional.empty();
        myNullable2.ifPresentOrElse(System.out::println, () -> System.out.println("Optional vide"));// Optional vide

    }
}
