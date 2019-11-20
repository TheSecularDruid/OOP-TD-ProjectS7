package tec;
import collecte.*;

public class Greffon {
    private Collecte collecte;
    public Transport transport;
    int num_arret;

    public Greffon(Transport transport, Collecte collecte) {
	this.transport = transport;
	this.collecte = collecte;
	this.num_arret = 0;
    }

    public void allerArretSuivant() {
	Vehicule vehicule = (Vehicule) this.transport;
	collecte.changerArret(++this.num_arret);
	this.transport.allerArretSuivant();
    }

    void monteeDemanderAssis(Passager p) {
	Vehicule vehicule = (Vehicule) this.transport;
	vehicule.monteeDemanderAssis(p);
	collecte.uneEntree();
    }

    void monteeDemanderDebout(Passager p) {
	Vehicule vehicule = (Vehicule) this.transport;
	vehicule.monteeDemanderDebout(p);
	collecte.uneEntree();
    }

    
    void arretDemanderSortie(Passager p) {
	Vehicule vehicule = (Vehicule) this.transport;
	collecte.uneSortie();
	vehicule.arretDemanderSortie(p);
    }

    void arretDemanderDebout(final Passager p) {
	Vehicule vehicule = (Vehicule) this.transport;
	vehicule.arretDemanderDebout(p);
    }

    void arretDemanderAssis(final Passager p) {
	Vehicule vehicule = (Vehicule) this.transport;
	vehicule.arretDemanderAssis(p);
    }

    boolean aPlaceAssise() {
        Vehicule vehicule=(Vehicule) this.transport;
        return vehicule.aPlaceAssise();
    }

    boolean aPlaceDebout() {
        Vehicule vehicule=(Vehicule) this.transport;
        return vehicule.aPlaceDebout();
    }

    public String toString(){
        Vehicule vehicule=(Vehicule) this.transport;
        return vehicule.toString();
    }

}

    
