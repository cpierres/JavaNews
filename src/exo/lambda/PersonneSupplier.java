package exo.lambda;

@FunctionalInterface
public interface PersonneSupplier {
    Personne creerInstance(String nom, String prenom);
}
