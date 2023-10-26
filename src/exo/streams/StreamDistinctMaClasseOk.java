package exo.streams;

import java.util.Arrays;
import java.util.List;

public class StreamDistinctMaClasseOk {
        public static void main(String[] args) {
        List<MaClasseOk> mesClasses = Arrays.asList(new MaClasseOk("aaa"), new MaClasseOk("bbb"), new MaClasseOk("aaa"));
        //MaClasseOk implémente les méthodes equals et hashCode en cohérence, 
        //distinct fonctionnera (ici aaa n'apparait pas 2 fois du fait car on compare le nom au lieu des adresses mémoire qui sont différentes)
        mesClasses.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
