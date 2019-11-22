package tec;

abstract class PassagerAbstrait
    extends Passager implements Usager {

    final private String nom;
    final private int destination;
    private Position position;
    private final ComportementArret comportementArret;


    PassagerAbstrait (String nom, int destination, ComportementArret comportementArret) {
	this.nom = nom;
	if (destination < 0)
	    throw new IllegalArgumentException();
	else
	    this.destination = destination;
	this.position = position.DEHORS; // dehors
	this.comportementArret = comportementArret;
    }

    public java.lang.String nom() {
	return this.nom;
    }

    boolean estDehors() {
	return (position.estDehors());
    }

    boolean estAssis() {
	return (position.estAssis());
    }

    boolean estDebout() {
	return (position.estDebout());
    }

    void changerEnDehors() {
	position = position.dehors();

    }

    public void changerEnAssis() {
	position = position.assis();

    }

    void changerEnDebout() {
	position = position.debout();

    }


    // override
    public void monterDans(Transport t) {
	Vehicule v = (Vehicule) t;
        choixPlaceMontee(v);
    }

    protected final int arretsRestants(int arret) {
      return destination - arret;
    }

    public abstract void choixPlaceMontee(Vehicule v);

    public void choixPlaceArret(final Passager p, Vehicule v, int arret) {
	comportementArret.choixPlaceArret(p, v, arretsRestants(arret));
    }

    public void nouvelArret(Vehicule v, int numeroArret) {
	choixPlaceArret(this, v, numeroArret);
	if (arretsRestants(numeroArret) <= 0) {
	    v.arretDemanderSortie(this);
	    changerEnDehors();
	}

    }

    public java.lang.String toString() {
	return "<" + nom + ">" + "<" + destination + ">" + "<" + position + ">";
    }
}
