package exo.lambda;

import java.util.function.Function;

public class TestFunction1 {
    public static void main(String[] args) {
        Function<Integer,Long> doubler = (i) -> (long) i * 2;
        System.out.println(doubler.apply(2));
    }
}