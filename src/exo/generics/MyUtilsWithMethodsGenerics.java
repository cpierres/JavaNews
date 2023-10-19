package exo.generics;

import java.util.ArrayList;

public class MyUtilsWithMethodsGenerics {

    // <K,V> : Pour dire que cette méthode a deux paramètres K, V
    // La méthode renvoie un objet du type K.
    public static <K, V> K getKey(KeyValue<K, V> entry) {
        K key = entry.getKey();
        return key;
    }

    // <K,V> : Pour dire que cette méthode a deux paramètres K, V
    // La méthode renvoie un objet de type V.
    public static <K, V> V getValue(KeyValue<K, V> entry) {
        V value = entry.getValue();
        return value;
    }

    // ArrayList<E>: La liste contient les éléments du type E.
	// La méthode renvoie un objet du type E.
	public static <E> E getFirstElement(ArrayList<E> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		E first = list.get(0);
		return first;
	}

}
