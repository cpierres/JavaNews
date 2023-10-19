package exo.generics;

public class GenericArrayDemo {
    public static void main(String[] args) {
        // Un tableau des String.
        String[] names = new String[] { "Tom", "Jerry" };

        GenericArray<String> gArray = new GenericArray<String>(names);

        String last = gArray.getLastElement();

        System.out.println("Last Element = " + last);
    }

}
