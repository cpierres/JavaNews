package exo.generics;

import java.util.ArrayList;

public class BeforeJava5sansGenerique {
  public static void main(String[] args) {

		// Créer un objet ArrayList (une liste).
		// Pour contenir le nom de l'utilisateur
		ArrayList userNames = new ArrayList();

		// Ajouter les String à la liste.
		userNames.add("tom");
		userNames.add("jerry");

		// Vous avez accidentellement ajouté un élément non type String à la liste.
		// (Ceci est permis).
		userNames.add(new Integer(100));

		// Et sortir le premier élément
		// C'est un objet (mais vous savez que c'est un String)
		// ==> tom
		Object obj1 = userNames.get(0);

		// Presser type (cast) au String
		String userName1 = (String) obj1;

		System.out.println("userName1 = " + userName1);

		// Sortir le deuxième élément
		// (vous savez que c'est String)
		// ==> jerry
		String userName2 = (String) userNames.get(1);

		System.out.println("userName2 = " + userName2);

		// Sortir le troisième élément et presser le type (cast) au String
		// (En fait, c'est un Integer).
		// (L'erreur typographique se produit ici).
		String userName3 = (String) userNames.get(2);

		System.out.println("userName3 = " + userName3);
	}

  
}
