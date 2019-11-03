package tec;

public class MonteeRepos extends PassagerAbstrait {

    public MonteeRepos(java.lang.String nom, int destination) {
	super(nom, destination);
    }
    
    public void choixPlaceMontee(Vehicule v) {
	if (v.aPlaceAssise()) {
	    v.monteeDemanderAssis(this);
	} else if (v.aPlaceDebout()) {
	    v.monteeDemanderDebout(this);
	}
    }
}
