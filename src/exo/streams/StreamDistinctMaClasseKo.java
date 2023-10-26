package exo.streams;

import java.util.Arrays;
import java.util.List;

public class StreamDistinctMaClasseKo {

    public static void main(String[] args) {
        List<MaClasseKo> mesClasses = Arrays.asList(new MaClasseKo("aaa"), new MaClasseKo("bbb"), new MaClasseKo("aaa"));
        //si MaClasseKo n'implémente pas les méthodes equals et hashCode en cohérence, 
        //distinct ne fonctionnera pas (ici aaa apparait 2 fois du fait de 2 adresses mémoire différentes)
        mesClasses.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
