package exo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

/**
 * La troisième surcharge de la méthode reduce() attend en paramètre la valeur
 * initiale, une BiFunction qui sera utilisée comme un accumulateur et une
 * BinaryOperator qui sera utilisée comme combinateur.<br>
 * L'exemple ci-dessous calcule la taille des employés. Ce traitement aurait pu
 * être réalisé différemment par le Stream mais il est utilisé pour illustrer le
 * mode de fonctionnement de la méthode reduce().
 */
public class StreamReduceAvecCombiner {

    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p1", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("p5", "p1", Genre.HOMME, 176));

        // ***************************************************
        // calcul total avec combinator
        Integer tailleTotale = personnes.stream()
                .reduce(0, (somme, e) -> somme += e.getTaille(),
                        (somme1, somme2) -> somme1 + somme2);
        System.out.println("Taille totale = " + tailleTotale);

        // ***************************************************
        // le traitement ci-dessus est similaire à celui-ci :
        BiFunction<Integer, Personne, Integer> accumulator = (somme, pers) -> somme += pers.getTaille();
        Integer tailleTotale2 = 0;
        for (Personne pers : personnes) {
            tailleTotale2 = accumulator.apply(tailleTotale2, pers);
        }
        System.out.println("Taille totale = " + tailleTotale2);

        // ***************************************************
        // Pour comprendre le mode de fonction de la méthode reduce() et l'utilisation
        // qu'elle fait des fonctions d'accumulation et de combinaison, il faut ajouter
        // des traces dans leurs expressions Lambdas
        System.out.println("***** combiner avec stream séquentiel ***** (pas appelé)");
        Integer tailleTotale3 = personnes.stream().reduce(0, (somme, p) -> {
            System.out.println("accumulator : somme=" + somme + " p.getTaille()=" + p.getTaille() + " - "
                    + Thread.currentThread().getName());
            return somme += p.getTaille();
        }, (somme1, somme2) -> {
            System.out.println(
                    "combiner : somme1=" + somme1 + " somme2=" + somme2 + " - " + Thread.currentThread().getName());
            return somme1 + somme2;
        });
        System.out.println("Taille totale = " + tailleTotale3);
        // La fonction de combinaison n'est jamais invoquée lorsque le Stream est
        // exécuté en séquentiel

        // ***************************************************
        // Le comportement est différent lorsque le Stream est invoqué en parallèle.
        System.out.println("***** combiner avec parallelStream ***** (appelé)");
        Integer tailleTotale4 = personnes.parallelStream().reduce(0, (somme, p) -> {
            System.out.println("accumulator : somme=" + somme + " p.getTaille()=" + p.getTaille() + " - "
                    + Thread.currentThread().getName());
            return somme += p.getTaille();
        }, (somme1, somme2) -> {
            System.out.println(
                    "combiner : somme1=" + somme1 + " somme2=" + somme2 + " - " + Thread.currentThread().getName());
            return somme1 + somme2;
        });
        System.out.println("Taille totale = " + tailleTotale4);
        // comme l'accumulateur est invoqué en parallèle, ce n'est plus lui qui fait la
        // somme mais la fonction de combinaison.
        // Les résultats de chaque threads sont ensuite combinés pour obtenir le
        // résultat final.
        // Pour permettre à une opération de réduction d'être exécutée en parallèle, il
        // est nécessaire que celle-ci soit associative.
        // Une opération # est associative si (a # b) # c = a # (b # c)
        // C'est le cas de l'addition et de la multiplication (mais pas de la soustraction).
        // Avec une opération associative, la réduction peut être effectuée dans n'importe quel ordre.
    }
}
