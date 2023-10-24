package exo.lambda;

import java.util.function.DoubleFunction;

public class TestDoubleFunction {
    
    public static void main(String[] args) {
        //DoubleFunction<R> est typée avec un generic qui précise le type de la valeur de retour
        DoubleFunction<String> formater = (x) -> String.format("%.2f", x);
        System.out.println(formater.apply(3.123456));
    }
}
