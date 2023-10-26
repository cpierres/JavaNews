package exo.streams;

import java.util.List;

import exo.lambda.Personne;

/**
 * Regroupement de personnes dans une ville
 */
public class AdressePersonne {
    private String ville;
    private List<Personne> personnes;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }
}
