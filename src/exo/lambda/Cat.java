package exo.lambda;

/**
 * Utilisée pour exemple de composition de Comparator
 */

public class Cat {
    private String name;
    private int eatenMouseTotal;

    public Cat(String name, int eatenMouseTotal) {
        this.name = name;
        this.eatenMouseTotal = eatenMouseTotal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEatenMouseTotal() {
        return eatenMouseTotal;
    }

    public void setEatenMouseTotal(int eatenMouseTotal) {
        this.eatenMouseTotal = eatenMouseTotal;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", eatenMouseTotal=" + eatenMouseTotal + '}';
    }

}
