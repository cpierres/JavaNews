package exo.generics;

public class StringAndGenericDemo {
    public static void main(String[] args) {
        StringAndGenericEntry<String> entry = new StringAndGenericEntry<String>("MYCODE", "MYNAME");
        String matricule = entry.getKey();
        String name = entry.getValue();
        System.out.println("matricule: " + matricule + " ; name: " +
                name);
    }
}
