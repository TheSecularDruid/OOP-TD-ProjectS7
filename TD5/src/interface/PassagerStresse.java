package tec;

class PassagerStresse extends PassagerAbstrait {
    
    public PassagerStresse(java.lang.String nom, int destination) {
	super(nom, destination);
    }

    protected void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceAssise())
	    v.monteeDemanderAssis(this);
	else if (v.aPlaceDebout())
	    v.monteeDemanderDebout(this);
    }

    protected void choixPlaceArret(Vehicule v, int numeroArret) {
	if (this.estAssis()&&v.aPlaceDebout()&&(this.destination-numeroArret<=3))
	    v.arretDemanderDebout(this);
	if (numeroArret==this.destination)
	    v.arretDemanderSortie(this);
    }
}
