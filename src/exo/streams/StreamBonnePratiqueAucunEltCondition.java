package exo.streams;

import java.util.stream.Stream;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * vérification qu'aucun élément ne satisfasse une condition
 */
public class StreamBonnePratiqueAucunEltCondition {
    public static void main(String[] args) {
        Personne p1 = new Personne("n1", "p1", Genre.HOMME, 176);
        Personne p2 = new Personne("n2", "p1", Genre.HOMME, 190);
        Personne p3 = new Personne("n3", "p1", Genre.FEMME, 172);

        long nbGrandePersBad = Stream.of(p1, p2, p3)
                .filter(p -> p.getTaille() >= 180)
                .count();
        boolean aucuneGrandePersBad = nbGrandePersBad == 0;
        System.out.println(aucuneGrandePersBad);

        // noneMatch préférable
        boolean aucuneGrandePersGood = Stream.of(p1, p2, p3)
                .noneMatch(p -> p.getTaille() >= 180);
        System.out.println(aucuneGrandePersGood);
    }
}
