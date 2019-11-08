package tec;

class MonteeRepos extends PassagerAbstrait{
    public MonteeRepos(java.lang.String nom, int destination, ComportementArret comp_arr) {
	super(nom, destination, comp_arr);
    }
    
    protected void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceAssise())
	    v.monteeDemanderAssis(this);
	else if (v.aPlaceDebout())
	    v.monteeDemanderDebout(this);
    }
}
