package exo.streams;

import java.util.stream.Stream;

/**
 * les traitements d'un Stream sont verticaux : chaque élément est traité
 * successivement par chaque opération.<br>
 * permet d'optimiser le nombre d'opérations à réaliser.<br>
 * Dans l'exemple, l'opération filter n'est invoquée que sur deux
 * éléments. Dès que le Predicat fourni à la méthode anyMatch() renvoie true
 * pour un élément du Stream, les traitements de l'exécution du Stream sont
 * interrompus. Cela permet d'optimiser le nombre d'opérations à exécuter pour
 * obtenir le résultat.
 */
public class TestStreamShortcircuiting {
    public static void main(String[] args) {
        Stream.of("b2", "a1", "b1", "a2", "a3")
                .peek(e -> System.out.println("filter : " + e))
                .filter(e -> e.startsWith("a"))
                .peek(e -> System.out.println("anyMatch : " + e))
                .anyMatch(e -> e.contains("1"));
    }
}
