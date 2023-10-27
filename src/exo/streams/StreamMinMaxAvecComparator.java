package exo.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * attendent en paramètre un Comparator qui permet de préciser l'ordre de
 * comparaison des éléments.<br>
 * Elles renvoient une instance de type Optional<T>
 * Le plus simple est d'utiliser la méthode comparing() de l'interface
 * Comparator : elle renvoie un objet de type Comparator qui compare les clés
 * extraites grâce à l'expression Lambda fournie en paramètre. Le paramètre de
 * la méthode comparing() est une Function qui permet d'extraire la clé sur
 * laquelle le Comparator retourné va faire la comparaison
 */
public class StreamMinMaxAvecComparator {
    public static void main(String[] args) {
        List<String> prenoms = Arrays.asList("andre", "benoit", "albert", "thierry", "alain",
                "jean");
        Optional<String> plusCourtPrenom = prenoms.stream().min(Comparator.comparing(element -> element.length()));
        System.out.println(plusCourtPrenom.orElseGet(() -> "aucun prénom trouvé"));
    }

}
