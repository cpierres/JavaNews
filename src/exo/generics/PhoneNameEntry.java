package exo.generics;

/**
 * PhoneNameEntry elle-même n'est pas générique mais étend une classe générique
 */
public class PhoneNameEntry extends KeyValue<Integer, String> {

    public PhoneNameEntry(Integer key, String value) {
        super(key, value);
    }
    
}
