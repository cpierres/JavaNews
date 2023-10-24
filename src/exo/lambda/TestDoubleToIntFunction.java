package exo.lambda;

import java.util.function.DoubleToIntFunction;

public class TestDoubleToIntFunction {
    public static void main(String[] args) {
        DoubleToIntFunction doubleToIntFunction = (x) -> {
            return (int) x;
        };
        System.out.println(doubleToIntFunction.applyAsInt(3.1234));

    }
}
