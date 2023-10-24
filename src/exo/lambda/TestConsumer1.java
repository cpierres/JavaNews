package exo.lambda;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class TestConsumer1 {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        Consumer<String> consumerAction = (x) -> {
            i.addAndGet(1);
            if ("ZZX".equals(x)) {
                throw new RuntimeException("erreur zzx dans passage "+i.get());
            } else {
                x = x.toLowerCase();
                System.out.print(x + i.get() + " - ");
            }
        };

        //Test accept simple
        consumerAction.accept("TEST ACCEPT");
        System.out.println();
        i.set(0);

        //le consommateur optionnel andThen est exécuté en 2ème si pas d'erreur dans le 1er (accept)
        consumerAction.andThen(consumerAction).accept("TEST");
        System.out.println();
        i.set(0);

        //Si erreur dans le accept (exception), l'exception est remontée à l'appelant et le second consommateur n'est pas exécuté
        //Lors de l'invocation de andThen(), si une exception est levée par un des deux Consumer, celle-ci est propagée 
        //dans la méthode englobante
        consumerAction.andThen(consumerAction).accept("ZZX");
    }
}
