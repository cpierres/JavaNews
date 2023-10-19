package exo.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWildCard03 {
    public static void printElement(List<?> list) {
        for (Object e : list) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        names.add("Tom");
        names.add("Jerry");
        names.add("Donald");

        List<Integer> values = new ArrayList<Integer>();
        values.add(100);
        values.add(120);

        System.out.println("--- Names --");

        printElement(names);

        System.out.println("-- Values --");

        printElement(values);

    }

}
