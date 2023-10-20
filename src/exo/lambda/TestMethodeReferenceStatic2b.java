package exo.lambda;

import java.util.Arrays;
import java.util.List;

public class TestMethodeReferenceStatic2b {
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
            System.out.print(formateur.formater("%3d %s %n", i, element));
        }
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("melon", "abricot", "fraise");
        // le 2ème argument de la méthode afficher est l'interface fonctionnelle
        // formateur
        // à la place de l'expression lambda dans l'exemple TestMethodeReferenceStatic2, 
        // il est possible d'utiliser directement 
        // une "référence de méthode" static avec :: sur format() de la classe String
        // inutile de préciser les arguments qui sont connus via l'interface fonctionnelle
        afficher(fruits, String::format);

        System.out.println("FIN");
    }
}
