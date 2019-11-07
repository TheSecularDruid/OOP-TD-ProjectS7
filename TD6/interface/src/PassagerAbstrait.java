package tec;
import tec.ComportementArret;
import tec.ArretCalme;
import tec.ArretNerveux;
import tec.ArretPrudent;
import tec.ArretAgoraphobe;
import tec.ArretPoli;

abstract class PassagerAbstrait
    implements Passager, Usager {

    final protected String nom;
    final protected int destination;
    protected Position position;
    protected ComportementArret comp_arret;
    
    public PassagerAbstrait (java.lang.String nom, int destination, ComportementArret comp_arr) {
	this.nom = nom;
	this.destination = destination;
	this.position = position.DEHORS; // dehors
	this.comp_arret = comp_arr;
    }

    public java.lang.String nom() {
	return this.nom;
    }

    public boolean estDehors() {
	return (position.estDehors());
    }

    public boolean estAssis() {
	return (position.estAssis());
    }

    public boolean estDebout() {
	return (position.estDebout());
    }

    public void changerEnDehors() {
	position = position.dehors();

    }

    public void changerEnAssis() {
	position = position.assis();

    }

    public void changerEnDebout() {
	position = position.debout();

    }

    abstract protected void choixPlaceMontee(Vehicule v);

    final public void monterDans(Transport t) {
	Vehicule b = (Vehicule) t;
	choixPlaceMontee(b);
    }	
    
    final public void nouvelArret(Transport t, int numeroArret) {
	Vehicule b = (Vehicule) t;
	if (numeroArret==destination)
	    b.arretDemanderSortie(this);
	int distanceDest = numeroArret-destination;
	switch(comp_arret) {
	case CALME:
	    ArretCalme.choixPlaceArret(this, b, numeroArret, distanceDest);
	case NERVEUX:
	    ArretNerveux.choixPlaceArret(this, b, numeroArret, distanceDest);
	case PRUDENT:
	    ArretPrudent.choixPlaceArret(this, b, numeroArret, distanceDest);
	case AGORAPHOBE:
	    ArretAgoraphobe.choixPlaceArret(this, b, numeroArret, distanceDest);
	case POLI:
	    ArretPoli.choixPlaceArret(this, b, numeroArret, distanceDest);
	}
    }

    public java.lang.String toString() {
	return "<" + nom + ">" + "<" + destination + ">" + "<" + position + ">";
    }
}

