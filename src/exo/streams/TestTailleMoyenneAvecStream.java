package exo.streams;

import java.util.ArrayList;
import java.util.List;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * voir équivalent avec boucle dans
 * {@link exo.collections.TestTailleMoyenneAvecBoucle}
 */
public class TestTailleMoyenneAvecStream {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p1", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("p5", "p1", Genre.HOMME, 176));
        // calculer taille moyenne des femmes
        double tailleMoyenneDesFemmes = personnes.stream().filter(p -> p.getGenre() == Genre.FEMME)
                .mapToInt(p -> p.getTaille()).average().getAsDouble();
        System.out.println("Taille moyenne des femmes = " + tailleMoyenneDesFemmes);
    }
}
