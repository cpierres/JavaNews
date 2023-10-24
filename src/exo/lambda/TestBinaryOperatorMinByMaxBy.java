package exo.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class TestBinaryOperatorMinByMaxBy {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (a, b) -> b - a;
        BinaryOperator<Integer> binaryOperatorMin = BinaryOperator.minBy(comparator);
        System.out.println(binaryOperatorMin.apply(4, 2));

        BinaryOperator<Integer> binaryOperatorMax = BinaryOperator.maxBy(comparator);
        System.out.println(binaryOperatorMax.apply(4, 2));
    }
}
