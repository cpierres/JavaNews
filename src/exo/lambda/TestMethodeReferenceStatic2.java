package exo.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * définit une interface fonctionnelle qui est utilisée en paramètre d'une
 * méthode
 */
public class TestMethodeReferenceStatic2 {

    @FunctionalInterface
    interface MonFormateur {
        String formater(String format, Object... arguments);
    }

    /**
     * cette méthode lie les paramètres à l'interface fonctionnelle
     * 
     * @param liste
     * @param formateur
     */
    public static void afficher(List<String> liste, MonFormateur formateur) {
        int i = 0;
        for (String element : liste) {
            i++;
            //l'interface fonctionnelle appelle en lui et place la référence de la 
            //Classe/méthode qu'on lui passe et 
            System.out.print(formateur.formater("%d %s %n", i, element));
        }
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("melon", "abricot", "fraise");
        // le 2ème argument de la méthode afficher est l'interface fonctionnelle
        // formateur à laquelle on passe l'expression lambda.
        // On doit lui passer les 2 paramètres de l'unique méthode formater de cette interface
        // et on pointe vers le corps qui appelle la méthode static String.format(...)
        // avec les paramètres passés (cela revient à une "référence de méthode" appelée
        // avec les bons arguments),
        // et retourne un String

        afficher(fruits, (fmt, arg) -> String.format(fmt, arg));

        System.out.println("FIN");
    }
}