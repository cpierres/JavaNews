package exo.generics;

import java.util.ArrayList;

public class GenericWildCard02 {
    public static void main(String[] args) {

        // Une liste contient les éléments de type String.
        ArrayList<String> listString = new ArrayList<String>();
        listString.add("Tom");
        listString.add("Jerry");

        // Une liste contient les éléments de type Integer
        ArrayList<Integer> listInteger = new ArrayList<Integer>();
        listInteger.add(100);

        // Vous ne pouvez pas déclarer:
        //ArrayList<Object> list1 = listString; // ==> Error! (à décommenter)

        // Un objet avec type paramètre représentant
        // (wildcard parameterized object).
        ArrayList<? extends Object> list2;

        // Vous pouvez déclarer:
        list2 = listString;

        // Ou
        list2 = listInteger;

    }

}
