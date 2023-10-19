package exo.generics;

public class MyGeneric<T> {
    private T tclassGenerique;

    public MyGeneric(Class<T> tClass) throws InstantiationException, IllegalAccessException {
        this.tclassGenerique = (T) tClass.newInstance();
    }

    public T getTclassGenerique() {
        return tclassGenerique;
    }
    
}