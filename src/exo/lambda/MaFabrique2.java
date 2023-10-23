package exo.lambda;

@FunctionalInterface
public interface MaFabrique2<T> {
    T creerInstance(int taille);
}
