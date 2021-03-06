package tec;

public class Jauge {
  private int valeur;
  private final int MAX;

  /**
   * Construit une instance en précisant la valeur max de l'intervalle
   * [0, max[ et la position de départ de la Jauge.
   *
   * La position de départ n'est pas forcément dans l'intervalle
   * [0, max[.
   *
   * @param max valeur maximale > 0 de l'intervalle.
   * @param depart   position de départ de la Jauge.
   */
  public Jauge(int max, int depart)
    throws IllegalArgumentException {
    if (max < 0) {
      throw new IllegalArgumentException("vigie max < 0");
    } else {
    valeur = depart;
    MAX = max;
  }
}

  /**
   * La position de la jauge est-elle au-dessus de l'intervalle ?
   *
   * @return vrai si niveau >=  max.
   *
   */
  public boolean estRouge() {
    return valeur >= MAX;
  }

  /**
   * La position de la jauge est-elle dans l'intervalle ?
   *
   * @return vrai si niveau appartient à [0, max[.
   *
   */
  public boolean estVert() {
      return (valeur >= 0)&&(valeur<MAX);
  }

  /**
   * Incrémente la position de la jauge.
   * La position peut devenir supérieur à max.
   */
  public void incrementer() {
    valeur++;
  }

  /**
   * Décrémente la position de la jauge.
   */
  public void decrementer() {
      valeur--;
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une
   * chaîne de caractères correspondant a l'état d'un objet.
   * Mais, il faut adapter son code à chaque classe.
   */
  @Override
  public String toString() {
    return "<" + valeur + " [0," + MAX + "[>";
  }
}
