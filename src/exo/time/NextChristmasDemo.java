package exo.time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;


public class NextChristmasDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("current date : " + localDate);

        localDate = localDate.with(new NextChristmasTemporalAdjuster());
        System.out.println("Next Christmas : " + localDate);

        //2eme façon de faire où l'implémentation de l'interface utilise un lambda.
        //with(..) a besoin d'une interface TemporalAdjuster (qui est une interface functional) dont la méthode
        // d'interface a un paramètre d'interface Temporal (implémenté entre autre par ChronoField)
        localDate = localDate.with(temporal -> temporal.with(ChronoField.MONTH_OF_YEAR, 12).with(ChronoField.DAY_OF_MONTH, 25));
        System.out.println("Next Christmas : "+localDate);
    }
}