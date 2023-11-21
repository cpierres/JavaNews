package exo.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Composition de Comparator
 * - Comparator<T, U>.comparing(function) : créer un Comparator avec une  fonction d'extraction de valeur sur
 * un objet pour comparer sur cette valeur
 * - <comparator>.thenComparing(function) : combine le Comparator avec un autre Comparator créé avec une fonction
 * d'extraction de valeur, ce deuxième Comparator est appelé si le premier ne départage pas.
 */
public class TestCompositionComparator {

    public static void main(String[] args) {
        List<Cat> cats = Arrays.asList(new Cat("Minnie", 3),
                new Cat("Izidore", 8),
                new Cat("Billy", 2),
                new Cat("Billy", 1));

        //exo 1 : tri sur le nom seul
        Collections.sort(cats,
                Comparator.<Cat, String>comparing(cat1 -> cat1.getName()));
        System.out.println(cats);
        //[Cat{name='Billy', eatenMouseTotal=2}, Cat{name='Billy', eatenMouseTotal=1}, Cat{name='Izidore', eatenMouseTotal=8}, Cat{name='Minnie', eatenMouseTotal=3}]

        //exo1 en plus simple
        Collections.sort(cats,Comparator.comparing(cat -> cat.getName()));
        System.out.println(cats);

        //exo 2 : tri en cascade (tri sur le nom puis sur le nb de souris mangées)
        Collections.sort(cats,
                Comparator.<Cat, String>comparing(cat1 -> cat1.getName())
                        .thenComparing(cat -> cat.getEatenMouseTotal()));
        System.out.println(cats);
        //[Cat{name='Billy', eatenMouseTotal=1}, Cat{name='Billy', eatenMouseTotal=2}, Cat{name='Izidore', eatenMouseTotal=8}, Cat{name='Minnie', eatenMouseTotal=3}]


        //exo2 en plus simple => ci-dessous ne fonctionne pas (cat est pris pour un objet)
        //  Collections.sort(cats,
        //                   Comparator.comparing(cat -> cat.getName()).thenComparing(cat2 -> cat2.getEatenMouseTotal()));

        //on voit dans ce cas l'intérêt de préciser les generics <Cat,String> après le point et avant comparing
        //(comparing étant méthode static). Cela permet au 2ème comparator de savoir que le type de son param
        //est aussi un chat. Question ?
        Collections.sort(cats,
                Comparator.<Cat,String>comparing(cat -> cat.getName()).thenComparing(cat2 -> cat2.getEatenMouseTotal()));

    }
}
