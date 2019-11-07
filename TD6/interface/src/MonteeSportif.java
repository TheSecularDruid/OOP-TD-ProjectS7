package tec;

class MonteeSportif extends PassagerAbstrait{
        public MonteeSportif(java.lang.String nom, int destination, ComportementArret comp_arr) {
	super(nom, destination, comp_arr);
    }

    protected void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceDebout())
	    v.monteeDemanderDebout(this);
    }
}
