package exo.generics;

import java.util.ArrayList;

public class GenericsDepuisJ5 {
   public static void main(String[] args) { 
		// Créer un ArrayList (Une liste)
		// Cette liste ne permet que contenir des éléments du type String.
		ArrayList<String> userNames = new ArrayList<String>();

		// Ajouter des String à la liste.
		userNames.add("tom");
		userNames.add("jerry");

		// Vous ne pouvez pas ajouter un élément qui n'est pas une String à la liste.
		// (L'erreur se produit lors de la compilation).
		//userNames.add(new Integer(100)); // Compile Error!

		// Vous n'avez pas besoin de forcer l'élément sur le type (cast).
		String userName1 = userNames.get(0); 
		System.out.println("userName1 = " + userName1); 
	} 
 
}
