package exo.generics;

public class MyGenericDemo {
    public static void main(String[] args) {
        try {
            MyGeneric<UneClasse> mg = new MyGeneric<UneClasse>(UneClasse.class);
            UneClasse uneClasse = mg.getTclassGenerique();
            uneClasse.currentDate();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        
    }
}
