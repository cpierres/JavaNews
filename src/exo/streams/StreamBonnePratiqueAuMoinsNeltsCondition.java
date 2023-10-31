package exo.streams;

import java.util.stream.Stream;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * vérification qu'au moins N éléments satisfassent une condition
 */
public class StreamBonnePratiqueAuMoinsNeltsCondition {
    public static void main(String[] args) {
        Personne p1 = new Personne("n1", "p1", Genre.HOMME, 176);
        Personne p2 = new Personne("n2", "p1", Genre.HOMME, 190);
        Personne p3 = new Personne("n3", "p1", Genre.FEMME, 172);

        long nbGrandePersBad = Stream.of(p1, p2, p3)
                .filter(p -> p.getTaille() >= 180)
                .count();
        boolean auMoinsDeuxGrandePersBad = nbGrandePersBad >= 2;
        System.out.println(auMoinsDeuxGrandePersBad);

        // limit() est short-circuiting et permet de s'assurer du nb de personnes
        // requises
        long nbGrandePersGood = Stream.of(p1, p2, p3)
                .filter(p -> p.getTaille() >= 180)
                .limit(2)
                .count();
        boolean auMoinsDeuxGrandePersGood = nbGrandePersGood >= 2;
        System.out.println(auMoinsDeuxGrandePersGood);

    }
}
