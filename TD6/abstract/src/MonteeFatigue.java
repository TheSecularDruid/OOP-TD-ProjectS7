package tec;

public class MonteeFatigue extends PassagerAbstrait {

    public MonteeFatigue(java.lang.String nom, int destination) {
	super(nom, destination);
    }

    public void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceAssise()) {
	    v.monteeDemanderAssis(this);
	}
    }
}
