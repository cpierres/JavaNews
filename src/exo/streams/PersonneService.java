package exo.streams;

import exo.lambda.Personne;

public class PersonneService {

    /**
     * En fait cette méthode de demo génère une personne dont on veut
     * rechercher l'id
     * @param id
     * @return
     */
    public static Personne findById(Long id) {
        return new Personne("nom"+id, "prenom"+id);
    }
}
