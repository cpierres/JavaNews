package exo.streams;

import java.util.stream.Stream;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * vérification qu'au moins un élément satisfasse une condition
 */
public class StreamBonnePratiqueAuMoins1EltOk {
    public static void main(String[] args) {
        Personne p1 = new Personne("n1", "p1", Genre.HOMME, 176);
        Personne p2 = new Personne("n2", "p1", Genre.HOMME, 190);
        Personne p3 = new Personne("n3", "p1", Genre.FEMME, 172);

        // pas nécessaire de filtrer les éléments, de compter le nombre d'éléments et de
        // vérifier si ce nombre est strictement supérieur à zéro
        long nbGrandePersBad = Stream.of(p1, p2, p3)
                .filter(p -> p.getTaille() >= 180)
                .count();
        boolean presenceGrandePersBad = nbGrandePersBad > 0;
        System.out.println(presenceGrandePersBad);

        // préférable d'utiliser l'opération terminale anyMatch() qui attend en
        // paramètre la condition à vérifier. L'intérêt de cette opération est qu'elle
        // est short-circuiting
        boolean presenceGrandePersGood = Stream.of(p1, p2, p3)
                .anyMatch(p -> p.getTaille() >= 180);
        System.out.println(presenceGrandePersGood);

    }
}
