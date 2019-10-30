package tec;

abstract class PassagerAbstrait
    implements Passager, Usager {
    import ComportementArret;

    final protected String nom;
    final protected int destination;
    protected Position position;
    protected comportement_arret comp_arret;
    
    public PassagerAbstrait (java.lang.String nom, int destination, comportement_arret comp_arr) {
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
	switch(this.comp_arret) {
	case CALME:
	    ArretCalme.choixPlaceArret(b, numeroArret);
	case NERVEUX:
	    ArretNerveux.choixPlaceArret(b, numeroArret);
	case PRUDENT:
	    ArretPrudent.choixPlaceArret(b, numeroArret);
	case AGORAPHOBE:
	    ArretAgoraphobe.choixPlaceArret(b, numeroArret);
	case POLI:
	    ArretPoli.choixPlaceArret(b, numeroArret);
	}
    }

    public java.lang.String toString() {
	return "<" + nom + ">" + "<" + destination + ">" + "<" + position + ">";
    }
}

