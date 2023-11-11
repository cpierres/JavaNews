package exo.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericWildcard01 {
    //Pour Collection, on doit préciser le générique. Si on ne veut pas, on précise <?> pour permettre tous les types.
    Collection collection1 = new ArrayList<String>();//warning
    Collection<?> collection2 = new ArrayList<String>();

    // Un ensemble contient uniquement le type Number ou sous-type de Number
    List<? extends Number> listNumbers = new ArrayList<Long>();
    List<? extends Number> listNumbers2 = new ArrayList<Integer>();

    KeyValue<String,?> keyValue = new KeyValue<String,Integer>("un",1);
    KeyValue<String,?>keyValue2 = new KeyValue<String,String>("un","2");

}
