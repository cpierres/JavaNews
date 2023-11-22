package exo.streams;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class StreamArraysStreamToListFiles {

    public static void main(String[] args) {
        //Path path = Paths.get("./src/exo/time");
        Path path = Paths.get(".");
        File[] files = path.toFile().listFiles();

        //Utiliser Arrays.stream() pour transformer ce tableau en Stream
        //Puis utiliser “map” avec String.format() pour formater un message
        //○ isFile() pour savoir si c’est un fichier
        //○ length() pour la taille
        //○ getAbsolutePath() pour le chemin absolu
        Arrays.stream(files).
                map(file -> String.format("%s %10s => %s", file.isFile() ? "F" : "D", file.length(), file.getAbsolutePath()))
                .forEach(System.out::println);
    }


}
