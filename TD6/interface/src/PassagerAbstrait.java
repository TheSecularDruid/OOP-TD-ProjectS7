package tec;

abstract class PassagerAbstrait
    implements Passager, Usager {
    
    final protected String nom;
    final protected int destination;
    protected Position position;
    
    
    public PassagerAbstrait (java.lang.String nom, int destination) {
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

    abstract protected void choixPlaceMontee(Vehicule v);

    public void monterDans(Transport t) {
	Vehicule b = (Vehicule) t;
	choixPlaceMontee(b);
    }
	
    abstract protected void choixPlaceArret(Vehicule v, int arret);


    public void nouvelArret(Transport t, int numeroArret) {
	Vehicule b = (Vehicule) t;
	choixPlaceArret(b, numeroArret);

    }

    public java.lang.String toString() {
	return "<" + nom + ">" + "<" + destination + ">" + "<" + position + ">";
    }
}

