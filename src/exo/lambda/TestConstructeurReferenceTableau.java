package exo.lambda;

public class TestConstructeurReferenceTableau {
    public static void main(String[] args) {
        //possible d'utiliser une référence de constructeur pour un tableau
        MaFabrique2<Integer[]> fabrique2 = Integer[]::new;
        Integer[] entiers = fabrique2.creerInstance(10);
        System.out.println("taille= " + entiers.length);
    }
}