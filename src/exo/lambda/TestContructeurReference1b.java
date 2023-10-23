package exo.lambda;

import java.util.function.Supplier;

public class TestContructeurReference1b {

    public static void main(String[] args) {
        // exemple équivalent à TestContructeurReference1 en utilisant une expression
        // lambda
        Supplier<Personne> supplier = () -> new Personne();
        System.out.println(supplier.get());
    }
}