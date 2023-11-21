package exo.lambda;

import java.util.function.Predicate;

/**
 * - <predicate1>.and(predicate2) : exécute le premier Predicate puis le second
 * si le premier est vrai (&&)
 * - <predicate1>.or(predicate2) : exécute le premier Predicate puis le second si
 * le premier est faux (||)
 * - <predicate1>.negate() : inverse le résultat du Predicate (!)
 */
public class TestCompositionPredicate {
    public static void main(String[] args) {
        Predicate<String> containsA = s -> s.contains("a");
        Predicate<String> containsB = s -> s.contains("b");

        System.out.println(containsA.test("---a---"));//true
        System.out.println(containsB.test("---b---"));//true

        //composition de Predicate avec and
        Predicate<String> containsAB = containsA.and(containsB);
        System.out.println(containsAB.test("---a---"));//false
        System.out.println(containsAB.test("---b---"));//false
        System.out.println(containsAB.test("---ab---"));//true
        System.out.println(containsAB.test("---ba---"));//true

        //composition de Predicate avec or
        Predicate<String> containsAorB = containsA.or(containsB);
        System.out.println(containsAorB.test("---a---"));//true
        System.out.println(containsAorB.test("---b---"));//true
        System.out.println(containsAorB.test("---ab---"));//true
        System.out.println(containsAorB.test("---ba---"));//true

        //composition de Predicate avec negate
        Predicate<String> notContainsAorB = containsAB.negate();
        System.out.println(notContainsAorB.test("---a---"));//true
        System.out.println(notContainsAorB.test("---b---"));//true
        System.out.println(notContainsAorB.test("---ab---"));//false
    }
}
