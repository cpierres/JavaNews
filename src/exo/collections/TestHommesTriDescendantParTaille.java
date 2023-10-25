package exo.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * On veut obtenir les noms des hommes triés par ordre descendant de taille.
 * voir équivalent en stream :
 * {@link exo.streams.TestHommesTriDescendantParTailleStream}
 */
public class TestHommesTriDescendantParTaille {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p1", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("p5", "p1", Genre.HOMME, 176));

        List<Personne> hommesParTaille = new ArrayList<>();
        for (Personne p : personnes) {
            if (p.getGenre() == Genre.HOMME) {
                hommesParTaille.add(p);
            }
        }

        Collections.sort(hommesParTaille, new Comparator<Personne>() {
            @Override
            public int compare(Personne p1, Personne p2) {
                return p2.getTaille() - p1.getTaille();
            }
        });

        List<String> nomsDesHommes = new ArrayList<>();
        for (Personne p : hommesParTaille) {
            nomsDesHommes.add(p.getNom());
        }
        for (String nom : nomsDesHommes) {
            System.out.println(nom);
        }
    }
}
