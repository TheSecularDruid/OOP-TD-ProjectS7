package tec;

class PassagerIndecis extends PassagerAbstrait {
    
    public PassagerIndecis(java.lang.String nom, int destination) {
	super(nom, destination);
    }

    protected void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceDebout())
	    v.monteeDemanderDebout(this);
    }

    protected void choixPlaceArret(Vehicule v, int numeroArret) {
	if (numeroArret==this.destination)
	    v.arretDemanderSortie(this);
	else if (this.estAssis()&&v.aPlaceDebout())
	    v.arretDemanderDebout(this);
	else if (this.estDebout()&&v.aPlaceAssise())
	    v.arretDemanderAssis(this);
    }
}
