package exo.generics;

public class StringAndGenericEntry<V> extends KeyValue<String, V> {

    public StringAndGenericEntry(String key, V value) {
        super(key, value);
    }
    
}
