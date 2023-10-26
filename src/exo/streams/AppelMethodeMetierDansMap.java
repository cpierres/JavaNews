package exo.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import exo.lambda.Personne;

/**
 * Avec un stream de départ qui sont des ids, on retourne une liste des personnes.
 * Ici, on montre les différentes syntaxes possibles, la dernière étant la plus courte.
 */
public class AppelMethodeMetierDansMap {
    public static void main(String[] args) {
        Long[] ids = { 12345L, 6789L };

        // syntaxe 1
        List<Personne> listePersonnes1 = Stream.of(ids).map(id -> PersonneService.findById(id)).toList();
        System.out.println(listePersonnes1);

        // syntaxe 2
        List<Personne> listePersonnes2 = Stream.of(ids).map(id -> {
            Personne p = PersonneService.findById(id);
            System.out.println("findById("+id+")");
            return p;
        }).collect(Collectors.toList());
        System.out.println(listePersonnes2);

        // syntaxe 3 : la plus courte (référence de méthode)
        List<Personne> listePersonnes3 = Stream.of(ids).map(PersonneService::findById).collect(Collectors.toList());
        System.out.println(listePersonnes3);

    }
}
