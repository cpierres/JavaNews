package exo.lambda;

import java.util.function.Function;

public class TestFunctionAndThenCompose {
    public static void main(String[] args) {
        Function<Long, Long> doubler = (i) -> {
            long resultat = i * 2;
            System.out.println("doubler => " + resultat);
            return resultat;
        };

        Function<Long, Long> laMoitie = (i) -> {
            long resultat = i / 2;
            System.out.println("laMoitie de " + i + " en long => " + resultat);
            return resultat;
        };

        System.out.println("---- demo avec andThen ---");
        // andThen est traité après la Function parente doubler
        System.out.println(doubler.andThen(laMoitie).apply(3L));

        System.out.println("---- demo avec compose ---");
        // compose est traité avant la Function parente doubler
        System.out.println(doubler.compose(laMoitie).apply(3L));
    }
}
