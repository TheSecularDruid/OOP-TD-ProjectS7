package tec;

class PassagerStandard extends PassagerAbstrait {
    
    public PassagerStandard(java.lang.String nom, int destination) {
	super(nom, destination);
    }
    
    protected void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceAssise())
	    v.monteeDemanderAssis(this);
	else if (v.aPlaceDebout())
	    v.monteeDemanderDebout(this);
	
    }
	
    protected void choixPlaceArret(Vehicule v, int numeroArret) {
	if (numeroArret>=this.destination)
	    v.arretDemanderSortie(this);
    }
}

