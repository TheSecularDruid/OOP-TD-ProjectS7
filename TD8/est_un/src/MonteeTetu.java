package tec;

public class MonteeTetu extends PassagerAbstrait {

    public MonteeTetu(java.lang.String nom, int destination, ComportementArret comportementArret) {
	super(nom, destination, comportementArret);
    }

    public void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceAssise()) {
	    v.monteeDemanderAssis(this);
	}
	else {
	    v.monteeDemanderDebout(this);
	}
    }
}
