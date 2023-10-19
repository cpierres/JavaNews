package exo.generics;

public class KeyValueDemo {

    public static void main(String[] args) {
        KeyValue<Integer, String> entry = new KeyValue<Integer,String>(6123456, "chris");
        Integer numero = entry.getKey();
        System.out.println("numero: "+numero);

        String name = entry.getValue();
        System.out.println("name: "+name);

    }
    
}
