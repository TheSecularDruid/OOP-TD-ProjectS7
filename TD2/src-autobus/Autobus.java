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

    
    private int chercherEmplacementVide() {
        for (int i = 0; i < passagers.length-1; i++) {
	    if (passagers[i] == null)
		return i;
	}
	return -1;
    }

    private int chercherPassager(Passager p) {
	for (int i = 0; i < passagers.length-1; i++) {
	    if ( passagers[i] == p)
		return i;
	}
	return -1;
    }

    /* public void allerArretSuivant() {
	num_arret++;
	for (int i = 0; i < passagers.length; i++) {
	    if (passagers[i] != null) {
		passagers[i].
	    }
	}
	}*/

    public boolean aPlaceAssise() {
	return assis.estVert();
    }
    
    public boolean aPlaceDebout() {
	return debouts.estVert();
    }
    
    public void arretDemanderAssis(Passager p) {
	if (this.aPlaceAssise()) {
	    p.changerEnAssis();
	    assis.incrementer();
	    debouts.decrementer();
	}	   
    }

    public void arretDemanderDebout(Passager p) {
	if (this.aPlaceDebout()) {
	    p.changerEnDebout();
	    debouts.incrementer();
	    assis.decrementer();
	}
	   
    }

    public void arretDemanderSortie(Passager p) {
	if (p.estAssis())
	    assis.decrementer();
	else
	    debouts.decrementer();

	p.changerEnDehors();
    }

    public void monteeDemanderAssis(Passager p) {
	if (this.aPlaceAssise()) {
	    p.changerEnAssis();
	    assis.incrementer();
	}
	    
    }

    public void monteeDemanderDebout(Passager p) {
	if (this.aPlaceDebout()) {
	    p.changerEnDebout();
	    debouts.incrementer();
	}
    }

    public java.lang.String toString() {
	return "coucou";
    }
    
}
