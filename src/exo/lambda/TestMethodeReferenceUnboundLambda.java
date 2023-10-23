package exo.lambda;

import java.util.Arrays;

public class TestMethodeReferenceUnboundLambda {

    public static void main(String[] args) {
        String[] fruits = {"Melon", "abricot", "fraise", "cerise", "myrtille"};
        //même résultat que TestMethodeReferenceUnbound mais avec expression lambda (pour montrer ce que fait exemple précédent)
        //le 1er param sera l'instance sur laquelle la méthode est invoquée. Le second est passé en paramètre de la méthode.
        Arrays.sort(fruits, (s1, s2) -> s1.compareToIgnoreCase(s2) );
        System.out.println(Arrays.deepToString(fruits));
    }
    
}
