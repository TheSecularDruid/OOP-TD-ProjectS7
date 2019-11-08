package tec;

class MonteeTetu extends PassagerAbstrait{
        public MonteeTetu(java.lang.String nom, int destination, ComportementArret comp_arr) {
	super(nom, destination, comp_arr);
    }

    protected void choixPlaceMontee(Vehicule v) {
	v.monteeDemanderDebout(this);
    }
}
