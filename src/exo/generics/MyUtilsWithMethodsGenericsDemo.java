package exo.generics;

import java.util.ArrayList;

public class MyUtilsWithMethodsGenericsDemo {

    public static void main(String[] args) {
        // K = Integer: Phone
        // V = String: Name
        KeyValue<Integer, String> entry1 = new KeyValue<Integer, String>(12000111, "Tom");
        KeyValue<Integer, String> entry2 = new KeyValue<Integer, String>(12000112, "Jerry");

        // (K = Integer)
        Integer phone = MyUtilsWithMethodsGenerics.getKey(entry1);
        System.out.println("Phone = " + phone);

        // test de public static <E> E getFirstElement(ArrayList<E> list)
        // Une liste contient les éléments de type KeyValue<Integer,String>.
        ArrayList<KeyValue<Integer, String>> list = new ArrayList<KeyValue<Integer, String>>();
        
        // Ajouter l'élément à la liste.
        list.add(entry1);
        list.add(entry2);

        KeyValue<Integer, String> firstEntry = MyUtilsWithMethodsGenerics.getFirstElement(list);

        System.out.println("Value = " + firstEntry.getValue());

    }
}
