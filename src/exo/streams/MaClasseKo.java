package exo.streams;

public class MaClasseKo {
    private String nom;

    public MaClasseKo(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    @Override
    public String toString() {
        return "MaClasse [nom=" + nom + "]";
    }

    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((nom == null) ? 0 : nom.hashCode());
    //     return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (getClass() != obj.getClass())
    //         return false;
    //     MaClasse other = (MaClasse) obj;
    //     if (nom == null) {
    //         if (other.nom != null)
    //             return false;
    //     } else if (!nom.equals(other.nom))
    //         return false;
    //     return true;
    // }
}
