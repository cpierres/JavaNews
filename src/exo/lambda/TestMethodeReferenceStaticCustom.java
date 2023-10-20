package exo.lambda;

import java.util.Arrays;

public class TestMethodeReferenceStaticCustom {
      public static void main(String[] args) {
    Integer[] valeurs = {10, 4, 2, 7, 5, 8, 1, 9, 3, 6};
    Arrays.sort(valeurs, TestMethodeReferenceStaticCustom::comparerEntierAscendant);
    System.out.println(Arrays.deepToString(valeurs));
  }
  
  /**
   * On peut spécifier une méthode personnalisée qui respecte le contrat des arguments
   * de comparator !
   * @param a
   * @param b
   * @return
   */
  public static int comparerEntierAscendant(int a, int b) {
    return a - b;
  }

}
