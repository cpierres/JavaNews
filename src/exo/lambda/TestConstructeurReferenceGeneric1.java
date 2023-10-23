package exo.lambda;

import java.util.ArrayList;
import java.util.List;

public class TestConstructeurReferenceGeneric1 {
    public static void main(String[] args) {
        //possible de préciser le ou les types si la classe est typée avec un generic (voir MaFabrique1)
        MaFabrique1<List<String>> fabrique1 = ArrayList<String>::new;
        List<String> mesChaines = fabrique1.creerInstance();
        //mesChaines.forEach(x -> System.out.println(x));//rien dans le tableau
        System.out.println(mesChaines.size());
    }
}
