package exo.streams;

import java.util.Random;

import exo.lambda.Personne;

public class PersonneService {
    private static Random random = new Random();

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
