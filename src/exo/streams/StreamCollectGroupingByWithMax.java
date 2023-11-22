package exo.streams;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * retourner la lettre qui apparaît le plus de fois<br>
 * - Un Map.Entry est la combinaison d’une clé et d’une valeur
 * - la méthode Map.Entry.comparingByValue() retourne un Comparator qui compare une Entry sur sa valeur
 */
public class StreamCollectGroupingByWithMax {

    private static final String generatedHistory = """
            La fontaine de Java
                        
            Dans un monde lointain, il était une fois une île appelée Java. Java était une île magnifique, avec des plages de sable blanc, des forêts tropicales luxuriantes et des volcans enneigés.
                        
            Sur cette île vivait un peuple sage et intelligent, qui avait développé un langage de programmation appelé Java. Java était un langage puissant et polyvalent, capable de créer des applications pour une variété de plateformes.
                        
            Un jour, un jeune programmeur nommé Alice visita Java. Alice était une étudiante en informatique, et elle était passionnée par la programmation. Elle avait toujours rêvé de créer des applications qui aideraient les gens, et elle était déterminée à apprendre Java.
                        
            Alice commença à apprendre Java avec un cours en ligne. Elle était une élève rapide, et elle était bientôt en mesure de créer des applications simples. Elle était tellement enthousiaste à l'idée d'utiliser Java qu'elle commença à passer ses nuits et ses week-ends à travailler sur des projets.
                        
            Alice créa une application pour aider les étudiants à étudier. L'application fournissait des quiz, des exercices et des conseils d'étude. Elle créa également une application pour aider les entreprises à gérer leurs finances. L'application était facile à utiliser et permettait aux entreprises d'économiser du temps et de l'argent.
                        
            Les applications d'Alice étaient un succès. Elles furent utilisées par des milliers de personnes dans le monde entier. Alice était fière de son travail, et elle savait qu'elle avait utilisé Java pour faire une différence.
                        
            Un jour, Alice visita une fontaine dans la forêt tropicale. La fontaine était magnifique, avec de l'eau claire et cristalline qui s'élevait en un jet d'eau puissant.
                        
            Alice s'arrêta pour admirer la fontaine. Elle sentit une inspiration soudaine, et elle eut l'idée d'une nouvelle application.
                        
            Alice créa une application qui permettait aux gens de créer leurs propres fontaines virtuelles. L'application était facile à utiliser, et elle permettait aux gens de personnaliser leurs fontaines avec différentes couleurs, formes et motifs.
                        
            L'application d'Alice fut un succès. Elle fut utilisée par des millions de personnes dans le monde entier. Alice était heureuse d'avoir utilisé Java pour créer une application qui apportait de la joie aux gens.
                        
            Alice continua à travailler sur des projets Java. Elle créa des applications pour aider les gens à apprendre, à travailler et à se divertir. Elle était déterminée à utiliser Java pour faire une différence positive dans le monde.
            """;

    public static void main(String[] args) {
        Character returned = letterWithMostOccurrences();
        if (returned != 'e') {
            System.out.println(returned + " should be e");
        } else {
            System.out.println("success !");
        }
    }

    private static Character letterWithMostOccurrences() {
        Map<Character, Long> nbOccurrencesByLetter = generatedHistory.toLowerCase().chars()
                .mapToObj(i -> (char) i)
                .filter(character -> character != ' ' && character != '\n')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //Map.Entry.comparingByValue() retourne un Comparator qui compare une Entry sur sa valeur
        Optional<Map.Entry<Character, Long>> optionalMapMax = nbOccurrencesByLetter.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        System.out.println(optionalMapMax); //Optional[e=301]

        return optionalMapMax
                .orElseThrow()
                .getKey();//retourner la clé, autrement la lettre ayant le max (au lieu de la valeur)
    }
}
