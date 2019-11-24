package tec;

public class Position {

    static public final Position DEHORS = new Position();
    static public final Position ASSIS  = new Position();
    static public final Position DEBOUT = new Position();



    private Position() {
	
    }
    
  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'état de l'instance est dehors;
   */
  public boolean estDehors() {
    return this == DEHORS;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'état de l'instance est assis;
   */
  public boolean estAssis() {
    return this == ASSIS;
  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'état de l'instance est debout;
   */
  public boolean estDebout() {
    return this == DEBOUT;
  }

  /**
   * La position est-elle assis ou debout ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {
    return this != DEHORS;
  }


  /**
   * Retourne une instance de Position assis.
   *
   * @return instance dans l'état assis.
   */
  public Position assis() {
    return ASSIS; 
  }

  /**
   * Retourne une instance de Position debout.
   *
   * @return instance dans l'état debout.
   */
  public Position debout() {
    return DEBOUT;
  }

  /**
   * Retourne une instance de Position dehors.
   *
   * @return instance dans l'état dehors.
   */
  public static Position dehors() {
    return DEHORS;
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * Mais, il faut adapter son code à chaque classe.
   */
    @Override
    public String toString() {
	String nom = null;
	if (this.equals(DEHORS)) {
	    nom = "endehors";
	} else if (this.equals(ASSIS)) {
	    nom = "assis";
	} else if (this.equals(DEBOUT)) {
	    nom = "debout";
	}
	return "<" + nom + ">";
    }
}
