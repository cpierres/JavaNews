package exo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * plusieurs optimisations sont mises en oeuvre par le Stream.
 * Tous les éléments ne sont pas parcourus. Les opérations ne sont invoquées
 * que le nombre de fois requis sur des éléments pour obtenir le résultat :
 * - L'opération de filtre n'est invoquée que 6 fois
 * - L'opération de transformation n'est invoquée que 3 fois
 * Ceci est possible car l'opération limit(3) ne renvoie qu'un Stream qui
 * contient au maximum le nombre d'éléments précisé en paramètre.
 * Les opérations sont regroupées en une seule itération qui traite chaque
 * élément en lui application le pipeline d'opérations : les opérations
 * n'itèrent pas individuellement sur les éléments du Stream
 */
public class TestStreamOptimisation {

    public static void main(String[] args) {
        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> troisPremierNombrePairAuCarre = nombres.stream().filter(n -> {
            System.out.println("filter " + n);
            return n % 2 == 0;
        }).map(n -> {
            System.out.println("map " + n);
            return n * n;
        }).limit(3).collect(Collectors.toList());

        System.out.println("\nRésultat: ");
        troisPremierNombrePairAuCarre.forEach(System.out::println);
    }
}