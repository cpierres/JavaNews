package exo.lambda;

/**
 * On précise que cette classe va se référer à un Type qui étend potentiellement Personne
 */
public class ComparaisonPersonneGeneric<T extends Personne> {
    public int comparerParNom(T p1, T p2) {
        return p1.getNom().compareTo(p2.getNom());
    }

    public int comparerParPrenom(T p1, T p2) {
        return p1.getPrenom().compareTo(p2.getPrenom());
    }
}
