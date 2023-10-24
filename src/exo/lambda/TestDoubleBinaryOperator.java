package exo.lambda;

import java.util.function.DoubleBinaryOperator;

public class TestDoubleBinaryOperator {
    public static void main(String[] args) {
        //définit une opération qui attend deux paramètres et renvoie une valeur, tous ces éléments étant de type double
        DoubleBinaryOperator doubleBinaryOperatorSurface = (longueur, largeur) -> longueur * largeur;
        System.out.println(doubleBinaryOperatorSurface.applyAsDouble(10.5, 20.4));
    }
}
