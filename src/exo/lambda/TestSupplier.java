package exo.lambda;

import java.util.function.Supplier;

/**
 * L'interface Supplier ne permet de renvoyer que des objets.
 * Plusieurs interfaces fonctionnelles la spécialisent pour retourner 
 * des valeurs primitives : *
 * BooleanSupplier, DoubleSupplier, IntSupplier et LongSupplier
 */
public class TestSupplier {
    public static void main(String[] args) {
        //définit une fonction qui renvoie une valeur dont le type correspond au type générique
        Supplier<String> message = () -> "Bienvenue";
        //méthode get() qui renvoie un objet de type T
        System.out.println(message.get());
    }

}
