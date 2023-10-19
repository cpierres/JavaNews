package exo.optional;

import java.util.Optional;

public class OptionalAvecFlatMap {

    private Optional<String> toLowerCase(String input) {
        return Optional.ofNullable(input.toLowerCase()); // Création d'un nouveau Optional
    }

    public void display() {
        Optional<String> myNullable = Optional.ofNullable("Alex");
        System.out.println(myNullable.map(this::toLowerCase)); // Optional[Optional[alex]]
        // permet de remettre à plat sans imbrication d'un Optional dans un autre Optional
        System.out.println(myNullable.flatMap(this::toLowerCase)); // Optional[alex]
    }

    public static void main(String[] args) {
        OptionalAvecFlatMap test = new OptionalAvecFlatMap();
        test.display();
    }

}