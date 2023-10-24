package exo.lambda;

import java.util.function.Function;

public class TestFunctionIdentity {
    public static void main(String[] args) {
        Function<Long,Long> identite = Function.identity();
        //renvoie la valeur fournie en paramètre de apply
        System.out.println(identite.apply(3L));
    }
}
