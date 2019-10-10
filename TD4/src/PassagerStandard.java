package tec;

public class PassagerStandard
    implements Passager, Usager {
    
    final private String nom;
    final private int destination;
    private Position position;
    
    
    public PassagerStandard (java.lang.String nom, int destination) {
	this.nom = nom;
	this.destination = destination;
	this.position = position.DEHORS; // dehors	
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


    public void monterDans(Transport t) {
	Vehicule b = (Vehicule) t;
	if (b.aPlaceAssise()) {
	    b.monteeDemanderAssis(this);
	    position = position.assis();
	} else if (b.aPlaceDebout()) {
	    b.monteeDemanderDebout(this);
	    position = position.debout();
	}
    }
		

    public void nouvelArret(Transport t, int numeroArret) {
	Vehicule b = (Vehicule) t;
	if (numeroArret == destination) {
	    b.arretDemanderSortie(this);
	    position = position.dehors();
	}

    }

    public java.lang.String toString() {
	return "<" + nom + ">" + "<" + destination + ">" + "<" + position + ">";
    }
}

