package exo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import exo.lambda.Personne;

/**
 * Lorsque les données à traiter par le Stream sont des données primitives de
 * type int, long ou double, il est donc préférable d'utiliser les interfaces
 * IntStream, LongStream et DoubleStream.<br>
 * C'est par exemple un IntStream qui est retourné lorsque l'on utilise une
 * opération de type map T vers int. Dans ce cas, ce sont des interfaces
 * fonctionnelles renvoyant un type primitif qui sont utilisées comme
 * IntSupplier, IntConsumer, ToIntFunction.<br>
 * Ces interfaces fonctionnent comme l'interface Stream avec quelques
 * différences :
 * <ul>
 * <li>Les interfaces fonctionnelles utilisées sont celles spécifiques aux types
 * primitifs : par exemple IntFunction à la place de Function, IntPredicate à la
 * place de Predicate, ...</li>
 * <li>Elles proposent quelques opérations terminales spécifiques aux types
 * primitifs comme sum(), average(), ...</li>
 * </ul>
 */
public class StreamAvecPrimitives {
    public static void main(String[] args) {
        int valeur = IntStream.of(1, 2, 3, 4, 5).map(n -> 2 * n).sum();
        System.out.println(valeur);

        // parfois utile voire même nécessaire de transformer un Stream primitif en
        // Stream d'objets et vice versa.
        // mapToInt(), mapToLong() et mapToDouble() de l'interface Stream fonctionne
        // comme la méthode map() sauf qu'au lieu de renvoyer un Stream<T>, elles
        // renvoient respectivement un IntStream, un LongStream et un DoubleStream.
        // Ci-dessous, on transforme un Stream d'objets String en stream int primitif
        Stream.of("1", "2", "3")
                .mapToInt(Integer::parseInt)
                .max().ifPresent(System.out::println);

        // on transforme un tableau d'objets Double en stream basé sur int et on fait la
        // somme
        int sommeEntiere = Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue).sum();
        System.out.println(sommeEntiere);

        // Les Streams primitifs peuvent être transformés en Stream d'objets en
        // utilisant la méthode mapToObj(). Selon le type primitif, elle attend
        // respectivement en paramètre une interface fonctionnelle de type IntFunction,
        // LongFunction et DoubleFunction.
        // Ci-dessous, on part d'un stream de primitives int, qu'on transforme en stream
        // d'objets String.
        IntStream.range(1, 4).mapToObj(i -> "" + i).forEach(System.out::println);

        // boxed() permet de transformer un Stream primitif en Stream<T> ou T est soit
        // un Integer, un Long ou un Double
        Stream<Integer> streamInteger = IntStream.range(10, 14).boxed();
        System.out.println(streamInteger.toList());

        // Les interfaces IntStream, LongStream et DoubleStream proposent de nombreuses
        // méthodes
        IntStream.rangeClosed(1, 5)
                .forEach(n -> System.out.print(n));
        System.out.println();
        IntStream.range(1, 5)
                .forEach(n -> System.out.print(n));

        System.out.println();
        // possible de créer une collection d'objets en utilisant la méthode range()
        // pour définir chaque élément.
        // Remarque : l'utilisation de Streams dont les traitements modifient l'état
        // d'objets externes n'est cependant pas recommandé
        List<AdressePersonne> adressesPersonnes = new ArrayList<AdressePersonne>();
        IntStream.range(1, 3).forEach(i -> {
            AdressePersonne adr = new AdressePersonne();
            adr.setVille("Ville" + i);
            adressesPersonnes.add(adr);
            // ajout de personnes dans cette ville
            IntStream.range(1, 4).forEach(j -> {
                adr.getPersonnes().add(new Personne("nom" + j, "prenom" + j));
            });
        });
        System.out.println(adressesPersonnes.toString());
    }
}
