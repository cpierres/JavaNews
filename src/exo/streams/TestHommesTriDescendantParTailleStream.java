package exo.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * On veut obtenir les noms des hommes triés par ordre descendant de taille.
 * voir équivalent en classique :
 * {@link exo.collections.TestHommesTriDescendantParTaille}
 */
public class TestHommesTriDescendantParTailleStream {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p1", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("p5", "p1", Genre.HOMME, 176));

        List<String> nomsHommesTriParTaille = personnes.stream().filter(p -> p.getGenre() == Genre.HOMME)
                .sorted(Comparator.comparingInt(Personne::getTaille).reversed()).map(Personne::getNom)
                .collect(Collectors.toList());
        for (String nom : nomsHommesTriParTaille) {
            System.out.println(nom);
        }
    }
}
