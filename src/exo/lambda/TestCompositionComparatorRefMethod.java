package exo.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Même exemple que TestCompositionComparator (avec classe) mais avec des références de méthodes (bien plus simple).<br>
 * On peut référencer une méthode depuis différents contextes :
 * - une méthode statique : Boolean::valueOf
 * - une méthode sur une instance : objet::toString
 * - une méthode sur une classe : Object::toString
 * - un constructeur : String::new
 */
public class TestCompositionComparatorRefMethod {
    public static void main(String[] args) {
        List<Cat> cats = Arrays.asList(new Cat("Minnie", 3),
                new Cat("Izidore", 8),
                new Cat("Billy", 2),
                new Cat("Billy", 1));

        //exo 1 : tri sur le nom seul
        Collections.sort(cats,
                Comparator.comparing(Cat::getName));
        System.out.println(cats);
        //[Cat{name='Billy', eatenMouseTotal=2}, Cat{name='Billy', eatenMouseTotal=1}, Cat{name='Izidore', eatenMouseTotal=8}, Cat{name='Minnie', eatenMouseTotal=3}]

        //exo 2 : tri en cascade (tri sur le nom puis sur le nb de souris mangées)
        Collections.sort(cats,
                Comparator.comparing(Cat::getName)
                        .thenComparing(Cat::getEatenMouseTotal));
        System.out.println(cats);
        //[Cat{name='Billy', eatenMouseTotal=1}, Cat{name='Billy', eatenMouseTotal=2}, Cat{name='Izidore', eatenMouseTotal=8}, Cat{name='Minnie', eatenMouseTotal=3}]

    }
}