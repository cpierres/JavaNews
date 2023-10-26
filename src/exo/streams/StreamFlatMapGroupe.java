package exo.streams;

import java.util.ArrayList;
import java.util.List;

import exo.lambda.Personne;
import exo.lambda.Personne.Genre;

public class StreamFlatMapGroupe {
    public static void main(String[] args) {
        List<Personne> personnes1 = new ArrayList<>(6);
        personnes1.add(new Personne("p1", "p1", Genre.HOMME, 176));

        List<Personne> personnes2 = new ArrayList<>(6);
        personnes2.add(new Personne("p2", "p1", Genre.HOMME, 190));
        personnes2.add(new Personne("p3", "p1", Genre.FEMME, 172));

        List<Personne> personnes3 = new ArrayList<>(6);
        personnes3.add(new Personne("p4", "p1", Genre.FEMME, 162));
        personnes3.add(new Personne("p5", "p1", Genre.HOMME, 176));
        
        List<AdressePersonne> adressesPersonnes = new ArrayList<AdressePersonne>();
        AdressePersonne adressePersonne1 = new AdressePersonne();
        adressePersonne1.setVille("Tourcoing");
        adressePersonne1.setPersonnes(personnes1);
        adressesPersonnes.add(adressePersonne1);

        AdressePersonne adressePersonne2 = new AdressePersonne();
        adressePersonne2.setVille("Lille");
        adressePersonne2.setPersonnes(personnes2);
        adressesPersonnes.add(adressePersonne2);

        AdressePersonne adressePersonne3 = new AdressePersonne();
        adressePersonne3.setVille("Paris");
        adressePersonne3.setPersonnes(personnes3);
        adressesPersonnes.add(adressePersonne3);

        //afficher les personnes pour chaque ville
        System.out.println("afficher les personnes pour chaque ville: ");
        adressesPersonnes.stream().map(adresse -> adresse.getPersonnes()).forEach(System.out::println);

        //afficher toutes les personnes
        System.out.println("afficher toutes les personnes: ");
        adressesPersonnes.stream().flatMap(adresse -> adresse.getPersonnes().stream()).forEach(System.out::println);

    }
}
