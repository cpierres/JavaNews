package exo.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcardInvalid {

    // Paramètre Wildcard ne peut pas participer à l'opérateur new
    // List<? extends Object> list= new ArrayList<? extends Object>();//KO
    List<? extends Object> list = new ArrayList<String>();// OK
}
