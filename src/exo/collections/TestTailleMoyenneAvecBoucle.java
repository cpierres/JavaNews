package exo.collections;

import java.util.ArrayList;
import java.util.List;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * voir équivalent avec stream dans :
 * {@link exo.streams.TestTailleMoyenneAvecStream}
 */
public class TestTailleMoyenneAvecBoucle {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p1", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("p5", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p6", "p1", Genre.FEMME, 168));

        // calculer taille moyenne des femmes
        long total = 0;
        int nbPers = 0;
        for (Personne personne : personnes) {
            if (personne.getGenre() == Genre.FEMME) {
                nbPers++;
                total += personne.getTaille();
            }
        }
        double resultat = (double) total / nbPers;
        System.out.println("Taille moyenne des femmes = " + resultat);
    }

}
