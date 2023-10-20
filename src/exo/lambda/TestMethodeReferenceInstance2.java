package exo.lambda;

import java.util.Arrays;

public class TestMethodeReferenceInstance2 {
    public static void main(String[] args) {
        Personne[] personnes = {
                new Personne("nom3", "Julien"),
                new Personne("nom1", "Thierry"),
                new Personne("nom2", "Alain")
        };
        ComparaisonPersonneGeneric<Personne> comparaisonPersonne = new ComparaisonPersonneGeneric<>();

        Arrays.sort(personnes, comparaisonPersonne::comparerParNom);
        System.out.println(Arrays.deepToString(personnes));

        Arrays.sort(personnes, comparaisonPersonne::comparerParPrenom);
        System.out.println(Arrays.deepToString(personnes));
    }
}
