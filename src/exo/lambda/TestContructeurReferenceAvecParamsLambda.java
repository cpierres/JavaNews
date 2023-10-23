package exo.lambda;

public class TestContructeurReferenceAvecParamsLambda {
    public static void main(String[] args) {
        PersonneSupplier supplier = (nom, prenom) -> new Personne(nom, prenom);
        Personne personne = supplier.creerInstance("nom1", "prenom1");
        System.out.println(personne);
    }
}
