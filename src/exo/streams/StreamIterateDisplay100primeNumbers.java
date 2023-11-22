package exo.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIterateDisplay100primeNumbers {

    public static void main(String[] args) {
        //affiche les 100 premiers nombres à partir de 2
        //le 2ème argument de iterate est un UnaryOperator<T> qui définit une opération qui attend un paramètre
        // et renvoie une valeur, tous ces éléments étant de même type. Elle hérite de l'interface
        // fonctionnelle Function<T, T>.
        Stream.iterate(2, i -> i + 1).limit(100).forEach(System.out::println);

        // Stream Integer borné entre 2 et 100 (non inclus)
        IntStream.range(2,100).forEach(System.out::println);

        // dans les valeurs de 2 à 99 obtenues ci-dessus, ne conserver que les nombres pairs
        System.out.println("**** Nombres pairs entre 2 et 99 ****");
        IntStream.range(2,100).filter(i -> i % 2 == 0).forEach(System.out::println);

        //maintenant, on veut les 100 premiers nombre premier
        /*
          Utiliser “Stream.iterate()” avec “2” en paramètre (pour commencer l’itération à 2) puis une lambda
          qui fait une incrémentation de 1 “i -> i +1”
            ○ Sur ce stream, appeler “filter”, dans sa lambda
                ■ Créer un autre stream avec “IntStream.range()”, avec en paramètre 2 et i, pour itérer de 2 à i-1
                ■ Sur ce stream, appeler “noneMatch” avec en lambda un modulo du paramètre et de i , comparé à zéro.
                ■ Donc le stream retourne vrai si aucune valeur entre 2 et i-1 est une division exacte avec i
            ○ appeler la méthode “limit” sur le premier Stream, avec en paramètre 100
         */
        System.out.println("**** Nombre premiers ****");
        Stream.iterate(2, i -> i + 1)
                .filter(i -> IntStream.range(2, i).noneMatch(n -> i % n == 0))
                .limit(100)
                .forEach(System.out::println);

    }
}
