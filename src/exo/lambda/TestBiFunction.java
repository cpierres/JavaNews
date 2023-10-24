package exo.lambda;

import java.util.function.BiFunction;

public class TestBiFunction {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatener = (x,y) -> x + y;
        System.out.println(concatener.apply("Bonjour", " java"));
    }
}
