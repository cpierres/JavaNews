package exo.streams;

import java.util.Arrays;
import java.util.List;

public class StreamBonnePratiqueRecherche {
    public static void main(String[] args) {
        String[] prenomsTab = { "alain", "anne", "sophie", "thierry", "antoine", "pierre" };

        List<String> prenomsList = Arrays.asList(prenomsTab);

        // pas utile de filtrer les éléments et de vérifier s'il y a un premier élément
        // restant pour s'assurer qu'un élément est présent dans une collection
        boolean trouveBad = prenomsList.stream()
                .filter(s -> "pierre".equals(s))
                .findFirst()
                .isPresent();

        System.out.println(trouveBad);

        // préférable d'utiliser l'opération terminale anyMatch() du Stream
        boolean trouveGood = prenomsList.stream()
                .anyMatch(s -> "pierre".equals(s));
        System.out.println(trouveGood);
    }
}
