package exo.generics;

public class PhoneNameDemo {
    public static void main(String[] args) {
        PhoneNameEntry entry = new PhoneNameEntry(6123456, "chris");
        Integer numero = entry.getKey();
        System.out.println("tel: "+numero);

        String name = entry.getValue();
        System.out.println("name: "+name);

    }
}
