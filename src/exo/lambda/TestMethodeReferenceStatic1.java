package exo.lambda;

/**
 * invoque la méthode statique de trois manières : 
 * la version historique en utilisant une classe anonyme interne et 
 * les deux possibilités offertes par Java 8 c'est à dire une expression lambda et une référence de méthode.
 * 
 * Les trois invocations rigoureusement identiques.
 * Seule la quantité de code nécessaire pour les réaliser change.
 */
public class TestMethodeReferenceStatic1 {

    static void executer() {
        System.out.println("execution de mon traitement par " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        // ancienne manière de faire : classe anonyme interne
        new Thread(new Runnable() {
            @Override
            public void run() {
                executer();
            }
        }).start();

        // expression lambda (voir l'inteface fonctionnelle dans Runnable)
        new Thread(() -> executer()).start();

        // référence de méthode statique ::
        new Thread(TestMethodeReferenceStatic1::executer).start();
    }
}
