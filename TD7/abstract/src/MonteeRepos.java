package tec;

public class MonteeRepos extends PassagerAbstrait {

    public MonteeRepos(java.lang.String nom, int destination, ComportementArret comportementArret) {
	super(nom, destination, comportementArret);
    }
    
    public void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceAssise()) {
	    v.monteeDemanderAssis(this);
	} else if (v.aPlaceDebout()) {
	    v.monteeDemanderDebout(this);
	}
    }
}
