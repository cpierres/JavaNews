package exo.lambda;

import java.util.function.UnaryOperator;

public class TestUnaryOperator {
    public static void main(String[] args) {
        UnaryOperator<String> minuscule = (c) -> c.toLowerCase();
        System.out.println(minuscule.apply("TEST"));
    }
}