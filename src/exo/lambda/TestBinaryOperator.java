package exo.lambda;

import java.util.function.BinaryOperator;

public class TestBinaryOperator {
    public static void main(String[] args) {
        //BinaryOperator<T>
        BinaryOperator<Integer> ajout = (a, b) -> a + b;
        System.out.println(ajout.apply(10, 20));
    }
}
