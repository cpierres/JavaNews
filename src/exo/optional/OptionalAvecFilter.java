package exo.optional;

import java.util.Optional;

public class OptionalAvecFilter {

    public static void main(String[] args) {
        Optional<Integer> myOptional = Optional.ofNullable(30);
        System.out.println(myOptional.filter(age -> age > 20).isPresent()); // true
        //Si l'Optional (ou le résultat de l'opération précédente (filtre ou map) le rend vide, 
        //le 2ème filtre ne sera pas appelé. Donc, il n'est pas possible d'obtenir en entrée du filtrage de valeur null
        System.out.println(myOptional.filter(age -> age > 40).filter(age -> age < 100).isPresent()); // false
        System.out.println(myOptional.filter(age -> age < 100).isPresent()); // true
    }

}
