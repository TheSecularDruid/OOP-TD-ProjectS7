package tec;

class MonteeFatigue extends PassagerAbstrait{
    public MonteeFatigue(java.lang.String nom, int destination, ComportementArret comp_arr) {
	super(nom, destination, comp_arr);
    }

    protected void choixPlaceMontee(Vehicule v) {
	if(v.aPlaceAssise())
	    v.monteeDemanderAssis(this);
    }
}
