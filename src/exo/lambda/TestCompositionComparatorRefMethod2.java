package exo.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Même exemple que TestCompositionComparator2 (avec record) mais avec des références de méthodes (bien plus simple).<br>
 * On peut référencer une méthode depuis différents contextes :
 * - une méthode statique : Boolean::valueOf
 * - une méthode sur une instance : objet::toString
 * - une méthode sur une classe : Object::toString
 * - un constructeur : String::new
 */
public class TestCompositionComparatorRefMethod2 {

    public static void main(String[] args) {
        List<CatRecord> cats = Arrays.asList(new CatRecord("Minnie", 3),
                new CatRecord("Izidore", 8),
                new CatRecord("Billy", 2),
                new CatRecord("Billy", 1));

        //exo 1 : tri sur le nom seul
        Function<CatRecord, String> nameFunction = CatRecord::name;
        Collections.sort(cats,
                Comparator.comparing(nameFunction));
        System.out.println(cats);

        //exo 1 : tri sur le nom seul ; équivalent
        Collections.sort(cats,
                Comparator.comparing(CatRecord::name));
        System.out.println(cats);

        //exo 2 : tri en cascade (tri sur le nom puis sur le nb de souris mangées)
        Collections.sort(cats,
                Comparator.comparing(CatRecord::name)
                        .thenComparing(CatRecord::eatenMouseTotal));
        System.out.println(cats);
        //[Cat{name='Billy', eatenMouseTotal=1}, Cat{name='Billy', eatenMouseTotal=2}, Cat{name='Izidore', eatenMouseTotal=8}, Cat{name='Minnie', eatenMouseTotal=3}]
    }
}
