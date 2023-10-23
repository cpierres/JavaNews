package exo.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class TestInterfaces {
    public static void main(String[] args) {
        Consumer<String> afficher = (message) -> {
            System.out.println(message);
        };
        afficher.accept("Bonjour du Consumer");

        BiConsumer<Integer, Integer> afficherAddition = (x, y) -> System.out.println(x + " + " + y + " = " + (x + y));
        afficherAddition.accept(1, 2);

        BiFunction<Integer, Integer, Long> additionner = (x, y) -> (long) x + y;
        System.out.println(additionner.apply(1,3));

        //Une expression lambda peut être assignée explicitement à une interface fonctionnelle 
        Runnable monTraitement = () -> System.out.println("bonjour Runnable explicite via lambda");
        new Thread(monTraitement).start();

        //Equivalent : Si le type n'est pas explicitement précisé dans le code, c'est le compilateur 
        //qui va déterminer implicitement l'interface fonctionnelle correspondante
        new Thread(() -> System.out.println("Runnable implicite via lambda")).start();

    }
}
