package exo.lambda;

import java.util.function.BiPredicate;

public class TestBiPredicate {
    public static void main(String[] args) {
        // BiPredicate<T,U> est typé avec deux generic qui précisent respectivement
        // le type du premier et du second argument de l'opération de la fonction
        BiPredicate<Integer, Integer> estSupOuEgal = (x, y) -> x >= y;
        BiPredicate<Integer, Integer> estLaMoitie = (x, y) -> x == y * 2;

        System.out.println("1 " + estSupOuEgal.test(2, 3));
        System.out.println("1 " + estSupOuEgal.test(3, 2));
    
        System.out.println("2 " + estSupOuEgal.and(estLaMoitie).test(4, 2));
        System.out.println("2 " + estSupOuEgal.and(estLaMoitie).test(3, 2));
    
        System.out.println("3 " + estSupOuEgal.negate().test(3, 2));
    
        System.out.println("4 " + estSupOuEgal.or(estLaMoitie).test(1, 1));
        System.out.println("4 " + estSupOuEgal.or(estLaMoitie).test(4, 2));
        System.out.println("4 " + estSupOuEgal.or(estLaMoitie).test(2, 4));
    
    }
}
