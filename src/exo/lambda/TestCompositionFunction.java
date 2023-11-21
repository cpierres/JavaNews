package exo.lambda;

import java.util.function.Function;

/**
 * Composition de Function avec compose et andThen<br>
 * - <function1>.compose(function2) : exécute la deuxième fonction et passe le résultat à la première<br>
 * - <function1>.then(function2) : exécute la première fonction et passe le résultat à la deuxième<br>
 */
public class TestCompositionFunction {

    public static void main(String[] args) {
        Function<Integer, Integer> multiply = (value) -> value * 3;
        Function<Integer, Integer> add = (value) -> value + 3;

        // Composition de Function avec compose (la 2ème s'exécute et donne son résultat à la 1ère)
        Function<Integer, Integer> addAndMultiply = multiply.compose(add);
        System.out.println(addAndMultiply.apply(2));//(2+3)*3=15

        // Composition de Function avec andThen (la 1ère s'exécute et ensuite donne son résultat à la 2ème)
        Function<Integer, Integer> multiplyAndAdd = multiply.andThen(add);
        System.out.println(multiplyAndAdd.apply(2));//(2*3)+2

    }

}
