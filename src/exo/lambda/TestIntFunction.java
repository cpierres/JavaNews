package exo.lambda;

import java.util.function.IntFunction;

public class TestIntFunction {
    public static void main(String[] args) {
        //IntFunction<R> 
        IntFunction<String> formater = (x) -> String.format("%d m", x);
        System.out.println(formater.apply(3));

    }
}
