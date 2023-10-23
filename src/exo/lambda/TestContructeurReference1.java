package exo.lambda;

import java.util.function.Supplier;

public class TestContructeurReference1 {
    public static void main(String[] args) {
        //il faut avoir créé un constructeur sans paramètre dans Personne pour que cet exemple fonctionne (sinon erreur du compilateur)
        Supplier<Personne> supplier = Personne::new;
        System.out.println(supplier.get());
    }
}