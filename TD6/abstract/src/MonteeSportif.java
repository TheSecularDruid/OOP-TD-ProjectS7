package tec;

public class MonteeSportif extends PassagerAbstrait {

    public MonteeSportif(java.lang.String nom, int destination) {
	super(nom, destination);
    }
    
    public void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceDebout()) {
	    v.monteeDemanderDebout(this);
	}
    }
}
