package exo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

public class StreamFindFirstOuFindAny {
    public static void main(String[] args) {
        List<Personne> personnes = new ArrayList<>(6);
        personnes.add(new Personne("p1", "p1", Genre.HOMME, 176));
        personnes.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes.add(new Personne("p3", "p1", Genre.FEMME, 172));
        personnes.add(new Personne("p4", "p1", Genre.FEMME, 162));
        personnes.add(new Personne("p5", "p1", Genre.HOMME, 176));

        Optional<Personne> uneGrandePersonne = personnes.stream().filter(p -> p.getTaille() > 200).findFirst();
        if (uneGrandePersonne.isPresent()) {
            System.out.println("Grande personne trouvée : " + uneGrandePersonne);
        } else {
            System.out.println("Aucune grande personne trouvée");
        }

        // findAny() est plus performante que la méthode findFirst() notamment lorsque
        // le Stream est traité en mode parallèle
        Optional<Personne> unePetitePersonne = personnes.parallelStream().filter(p -> p.getTaille() < 165).findAny();
        if (unePetitePersonne.isPresent()) {
            System.out.println("Petite personne trouvée : " + unePetitePersonne);
        } else {
            System.out.println("Aucune petite personne trouvée");
        }
    }
}
