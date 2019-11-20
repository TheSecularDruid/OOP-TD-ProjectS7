package tec;

public class MonteeFatigue extends PassagerAbstrait {

    public MonteeFatigue(java.lang.String nom, int destination, ComportementArret comportementArret) {
	super(nom, destination, comportementArret);
    }

    public void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceAssise()) {
	    v.monteeDemanderAssis(this);
	}
    }
}
