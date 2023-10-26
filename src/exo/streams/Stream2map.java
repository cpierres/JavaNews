package exo.streams;

import java.util.List;
import java.util.stream.Stream;

/**
 * On applique 2 map successivement pour obtenir un Stream sur Personne puis sur les noms (String)
 */
public class Stream2map {
    public static void main(String[] args) {
        Long[] ids = { 12345L, 6789L };
        //dans le 1er map, on récupère les Personnes, dans le 2ème juste le nom
        List<String> listeNoms = Stream.of(ids).map(id -> PersonneService.findById(id)).map(p -> p.getNom()).toList();
        System.out.println(listeNoms);
    }
}