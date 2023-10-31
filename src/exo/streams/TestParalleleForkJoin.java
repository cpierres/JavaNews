package exo.streams;

import java.util.concurrent.ForkJoinPool;

public class TestParalleleForkJoin {
    public static void main(String[] args) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();// instance du pool commun de Fork/join
        System.out.println(commonPool.getParallelism());// égal au nb de coeurs - 1
        // possible de modifier cette valeur en utilisant la variable d'environnement de
        // la JVM java.util.concurrent.ForkJoinPool.common.parallelism
    }
}
