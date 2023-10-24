package exo.lambda;

import java.util.function.DoubleUnaryOperator;

public class TestDoubleUnaryOperator {
    public static void main(String[] args) {
        //opération qui attend un paramètre et renvoie une valeur, ces deux éléments étant de type double
        DoubleUnaryOperator surfaceCarre = (cote) -> cote * cote;
        System.out.println(surfaceCarre.applyAsDouble(10.5));
    }
}