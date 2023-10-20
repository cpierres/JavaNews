package exo.lambda;

import java.util.Arrays;

public class TestMethodeReferenceStaticSort {
    public static void main(String[] args) {
        Integer[] valeurs = { 10, 4, 2, 7, 5, 8, 1, 9, 3, 6 };//ne serait pas applicable 
        //Référence de méthode static pour le 2ème argument, l'interface fonctionnelle Comparator 
        //précise que la méthode attend 2 paramètres pour chaque ligne du tableau
        Arrays.sort(valeurs, Integer::compare);
        System.out.println(Arrays.deepToString(valeurs));
    }
}
