package exo.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Les traitements réalisés par la méthode collect() peuvent être exécutés en
 * parallèle sur plusieurs threads dans un Stream parallèle car chacun d'eux va
 * utiliser sa propre instance du conteneur et la méthode de combinaison permet
 * de fusionner le contenu des différents conteneurs.
 */
public class StreamCollectorParallel {
    public static void main(String[] args) {
        List<String> elements = Arrays.asList("elem1", "elem2", "elem2", "elem3", "elem4");

        /*
         * La surcharge de la méthode collect() : <br>
         * <R> collect(Supplier<R> resultSupplier, BiConsumer<R, T>
         * accumulator, BiConsumer<R, R> combiner) attend trois
         * paramètres :
         * <ul>
         * <li>supplier : pour fournir une instance du conteneur vide</li>
         * <li>accumulator : pour ajouter un élément dans le conteneur</li>
         * <li>combiner : pour combiner deux conteneurs lors de l'utilisation du Stream
         * en parallèle</li>
         * </ul>
         */
        Set<String> ensemble = elements.parallelStream().collect(() -> new HashSet<String>(),
                (hset, eleme) -> hset.add(eleme),
                (hset1, hset2) -> hset1.addAll(hset2));
        System.out.println(ensemble);

        // Syntaxe équivalente :
        Set<String> ensemble2 = elements.parallelStream().collect(HashSet::new,
                HashSet::add,
                HashSet::addAll);
        System.out.println(ensemble2);
    }
}