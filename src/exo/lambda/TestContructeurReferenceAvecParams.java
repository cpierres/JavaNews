package exo.lambda;

public class TestContructeurReferenceAvecParams {

    public static void main(String[] args) {
        PersonneSupplier supplier = Personne::new;
        Personne personne = supplier.creerInstance("nom1", "prenom1");
        System.out.println(personne);
    }
    
}