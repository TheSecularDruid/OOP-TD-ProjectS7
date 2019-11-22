package tec;

class GreffonPassager extends PassagerAbstrait {

  GreffonVehicule gv;

  GreffonPassager(String nom, int destination, ComportementArret comportementArret) {
    super(nom, destination, comportementArret);
  }

  public void nouvelArret(Vehicule v, int numeroArret) {
    this.gv = (GreffonVehicule) v;
    choixPlaceArret(this, gv, numeroArret);
  	if (arretsRestants(numeroArret) <= 0) {
  	    v.arretDemanderSortie(this);
  	    changerEnDehors();
  	}
}
