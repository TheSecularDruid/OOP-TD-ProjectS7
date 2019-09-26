public class Autobus implements Vehicule {
    private Passager passagers [];
    private Jauge assis;
    private Jauge debouts;
    public int num_arret;

    public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
	assis = new Jauge(nbPlaceAssise,0);
	debouts = new Jauge(nbPlaceDebout,0);
	num_arret = 0;
	passagers = new Passager[nbPlaceDebout+nbPlaceAssise];
    }
    /*
    private void ajouter_passager(Passager p) {
	int  i = 0;
	for (; this.passagers[i] == null; i++) {
	    if (i==(passagers.length-1))
		break;
	}
	passagers[i] = p;
	}*/

    private int chercherEmplacementVide() {	
	for (int i=0;i<passagers.length; i++) {
	    if (passagers[i]==null)
		return i;	    
	}
    }

    public void allerArretSuivant() {

    }

    public boolean aPlaceAssise() {
	return this.assis.estVert();
    }
    
    public boolean aPlaceDebout() {
	return this.debouts.estVert();
    }
    
    public void arretDemanderAssis(Passager p) {

    }

    public void arretDemanderDebout(Passager p) {

    }

    public void arretDemanderSortie(Passager p) {

    }

    public void monteeDemanderAssis(Passager p) {
	ajouter_passager(p);
	if (this.aPlaceAssise()) {
	    this.assis.incrementer();
	    p.changerEnAssis();
	}
    }

    public void monteeDemanderDebout(Passager p) {

    }

    public java.lang.String toString() {
	return "coucou";
    }
    
}
