package tec;
import collecte.*;

public class Greffon extends Autobus {
    Collecte donnees;
    
    public Greffon(int nbPlaceAssise, int nbPlaceDebout) {
	super(nbPlaceAssise, nbPlaceDebout);
	donnees = new CollecteTableau(0);
    }
    public void allerArretSuivant() {
	donnees.changerArret();
	super.allerArretSuivant();
    }
    
    void arretDemanderSortie(Passager p) {
	donnees.uneSortie();
	super.arretDemanderSortie(p);
    }

    void monteeDemanderAssis(Passager p) {
	donnees.uneEntree();
	super.monteeDemanderAssis(p);
    }

    void monteeDemanderDebout(Passager p) {
	donnees.uneEntree();
	super.monteeDemanderDebout(p);
    }

    public String toString() {
	return donnees.toString() + super.toString();
    }
}
