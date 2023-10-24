package exo.lambda;

import java.util.Objects;
import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        Predicate<String> possedeTaille3 = s -> s.length() == 3;
        Predicate<String> contientX = s -> s.contains("X");
        //Predicat basé sur un autre prédicat avec or
        Predicate<String> contientXouTaille3 = contientX.or(possedeTaille3);

        Predicate<String> estNonNull = Objects::nonNull;
        Predicate<String> estSMS = Predicate.isEqual("SMS");

        System.out.println("1 "+contientX.negate().test("WXYZ"));
        System.out.println("2 "+contientX.or(possedeTaille3).test("WWW"));
        System.out.println("2 "+contientX.or(possedeTaille3).test("WX"));
        System.out.println("3 "+contientX.and(possedeTaille3).test("WXY"));
        System.out.println("3 "+contientX.and(possedeTaille3).test("WWW"));
        System.out.println("4 "+estNonNull.test(null));
        System.out.println("5 "+estNonNull.and(contientX).and(possedeTaille3)
        .test("WWW"));
        System.out.println("5 "+estNonNull.and(contientX).and(possedeTaille3)
        .test("XX"));
        System.out.println("5 "+estNonNull.and(contientX).and(possedeTaille3)
        .test(null));
        System.out.println("6 "+estNonNull.and(contientXouTaille3).test("WWW"));
        System.out.println("6 "+estNonNull.and(contientXouTaille3).test("XX"));
        System.out.println("6 "+estNonNull.and(contientXouTaille3).test(null));
        System.out.println("7 "+estNonNull.and(contientX.or(possedeTaille3))
        .test("WWW"));
        System.out.println("7 "+estNonNull.and(contientX.or(possedeTaille3))
        .test("XX"));
        System.out.println("7 "+estNonNull.and(contientX.or(possedeTaille3))
        .test(null));
        System.out.println("8 "+estSMS.test("SMS"));
        System.out.println("8 "+estSMS.test("ABC"));
        System.out.println("8 "+estSMS.test(null));
    

    }
}
