package exo.optional;

import java.util.Optional;

public class OptionalAvecMap {
    public static void main(String[] args) {
        Optional<String> myOptional = Optional.ofNullable("Alex");
        //on applique à la valeur récupérée du optional un toUpperCase
        //si myOptional on retourne Claire
        System.out.println(myOptional.map(String::toUpperCase).orElse("Claire"));

        Personne personne = new Personne("Angel");
        //l'objectif est d'obtenir le prenom à partir de l'objet personne
        //Si l'objet personne n'est pas null, on applique à cet objet la méthode getPrenom de la classe Personne
        //Si l'objet personne est null, le map sera ignoré et on retournera la valeur proposée dans orElse
        String prenom = Optional.ofNullable(personne).map(Personne::getPrenom).orElse("Claire");
        System.out.println(prenom);
    }
}
