package exo.generics;

public class GArrayDemo {
    public static void main(String[] args) {
        //Pour initialiser directement un tableau générique, il faut passer la classe dans le
        //constructeur
        GArray<Integer> garray = new GArray<Integer>(Integer.class);
 
        Integer[] myArray = garray.getMyArray();
 
        myArray[0] = 1;
        myArray[2] = 0;
    } 
}
