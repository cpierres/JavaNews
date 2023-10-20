package exo.lambda;

public class Calculatrice {
    
    @FunctionalInterface
    interface OperationEntiere {
        long effectuer(int a, int b);
    }

    /**
     * Méthode pour exploiter l'interface fonctionnelle 
     * @param a 1er param de l'interface fonctionnelle
     * @param b 2ème param de l'interface fonctionnelle
     * @param operationEntiere l'interface fonctionnelle (avec une seule méthode)
     * @return
     */
    public long calculer(int a, int b, OperationEntiere operationEntiere) {
        return operationEntiere.effectuer(a, b);
    }

    public static void main(String[] args) {
        Calculatrice calc = new Calculatrice();
        //Les paramètres a et b des expressions lambdas ci-dessous sont définis dans 
        //l'interface fonctionnelle qui a une unique méthode
        OperationEntiere addition = (a,b) -> a + b;
        //2eme expression lambda. C la méthode calculer(a,b,interfaceFonctionnelle) qui 
        //rapprochera les paramètres de l'interface fonctionnelle
        OperationEntiere soustraction = (a,b) -> a - b;

        System.out.println(calc.calculer(10, 5, addition));
        System.out.println(calc.calculer(10, 5, soustraction));
    }
}
