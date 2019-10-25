  package tec;

  public class PassagerIndecis extends PassagerAbstrait {

      public PassagerIndecis (java.lang.String nom, int destination) {
          super(nom, destination);
      }

  protected abstract void choixPlaceMontee(Vehicule v) {
  	if (v.aPlaceDebout()) {
  	    (v.monteeDemanderDebout(this));
  	}
  }

  protected abstract void choixPlaceArret(Vehicule v, int arret) {
    if (this.estAssis() && v.aPlaceDebout()) {
      v.arretDemanderDebout(this);
    }
    if (this.estDebout() && v.aPlaceAssise()) {
      v.arretDemanderAssis(this);
    }
  }
}
