package exo.lambda;

public class TestPorteeLambda {

    public static void afficher(String message, int repetition) {
        //le corps de l'expression lambda peut accéder aux variables
        //englobantes (considérées comme final) - non transmises en
        //paramètres
        Runnable runnable = () -> {
            for (int i = 0; i < repetition; i++) {
                System.out.println(message);
            }
        };
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        afficher("Bonjour",5);
    }
    
}
