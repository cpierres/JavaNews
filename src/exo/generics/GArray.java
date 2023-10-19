package exo.generics;

import java.lang.reflect.Array;

/**
 * Pour initialiser directement un tableau générique, vous devez passer l'objet Class <T> à Java qui 
 * permet à Java de créer un tableau générique au moment de l'exécution en utilisant Java Reflection
 */
public class GArray<T> {
    private Class<T> tclass;

    private T[] myArray;
  
    public GArray(Class<T> tclass) {
        this.tclass = tclass;
  
        final int size = 10;
        myArray = (T[]) Array.newInstance(tclass, size);
    }
  
    public T[] getMyArray() {
        return this.myArray;
    }  
    
}
