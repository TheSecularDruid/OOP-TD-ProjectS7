package tec;
import collecte.*;

public class GreffonVehicule {

    private Collecte collecte;
    public Vehicule vehicule;
    int num_arret;

    public GreffonPassager(Vehicule v, Collecte collecte) {
	this.vehicule  = v;
	this.collecte = collecte;
	this.num_arret = 0;
    }

    public void allerArretSuivant() {
	collecte.changerArret(++this.num_arret);
	this.vehicule.allerArretSuivant();
    }

    void monteeDemanderAssis(Passager p) {
      GreffonPassager gp = (GreffonPassager) p;
	vehicule.monteeDemanderAssis(gp);
	collecte.uneEntree(gp);
    }

    void monteeDemanderDebout(Passager p) {
      GreffonPassager gp = (GreffonPassager) p;
	vehicule.monteeDemanderDebout(gp);
	collecte.uneEntree(gp);
    }


    void arretDemanderSortie(Passager p) {
      GreffonPassager gp = (GreffonPassager) p;
	collecte.uneSortie();
	vehicule.arretDemanderSortie(gp);
    }

    void arretDemanderDebout(final Passager p) {
      GreffonPassager gp = (GreffonPassager) p;
	vehicule.arretDemanderDebout(gp);
    }

    void arretDemanderAssis(final Passager p) {
      GreffonPassager gp = (GreffonPassager) p;
	vehicule.arretDemanderAssis(gp);
    }

    boolean aPlaceAssise() {
        return vehicule.aPlaceAssise();
    }

    boolean aPlaceDebout() {
        return vehicule.aPlaceDebout();
    }

    public String toString(){
        return vehicule.toString();
    }

}
