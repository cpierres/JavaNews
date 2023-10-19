package exo.optional;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) throws Exception {
        // Ne jamais créer un Optional à null, il perdrait tout son intérêt. A la place
        // faire :
        // Optional vide (empty)
        Optional<String> optVide = Optional.empty();
        System.out.println(optVide);

        // *** Optional d'un élément non null (of) ***
        String element = "Alex";
        Optional<String> optOf = Optional.of(element);
        System.out.println(optOf);
        // Si la variable element est à null, alors un NPE est levé
        // element = null;
        // optOf = Optional.of(element);// lève une NPE (retirer commentaires pour test)
        // System.out.println(optOf);

        // *** Optional d'un élément éventuellement null (ofNullable) ***
        String element2 = "Alex";
        Optional<String> optOfNullable = Optional.ofNullable(element2);
        System.out.println(optOfNullable);
        System.out.println(optOfNullable.isPresent());
        System.out.println(optOfNullable.isEmpty());
        System.out.println(optOfNullable.get());// à éviter car lève une exception si null

        optOfNullable = Optional.ofNullable(null);
        System.out.println(optOfNullable);
        System.out.println(optOfNullable.isPresent());
        System.out.println(optOfNullable.isEmpty());
        // System.out.println(optOfNullable.get());//lève une exception car null => à
        // éviter

        // *** Récupération avec une valeur par défaut (orElse) ***
        // élément non null
        optOfNullable = Optional.ofNullable("Alex");
        System.out.println(optOfNullable.orElse("Claire")); // Alex

        // élément null
        optOfNullable = Optional.ofNullable(null);
        System.out.println(optOfNullable.orElse("Claire")); // Claire

        // *** Récupération avec une valeur par défaut issue d'un Supplier (orElseGet) ***
        optOfNullable =  Optional.ofNullable("Alex");
        System.out.println(optOfNullable.orElseGet(() -> "Claire")); //Alex

        optOfNullable = Optional.ofNullable(null);
        System.out.println(optOfNullable.orElseGet(() -> "Claire")); // Claire

        // *** Lever une exception si absence de valeur (orElseThrow) ***
        element = null;
        // String firstName = Optional.ofNullable(element).orElseThrow(); // NoSuchElementException;
        // System.out.println(firstName);

        // String firstName2 = Optional.ofNullable(element).orElseThrow(() -> new Exception("L'element ne doit pas etre vide")); // Exception;
        // System.out.println(firstName2);


        System.out.println("FIN");
    }
}
