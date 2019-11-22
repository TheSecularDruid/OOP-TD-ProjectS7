package tec;

public class Autobus extends Vehicule implements Transport {
    private Passager passagers [];
    private Jauge assis;
    private Jauge debouts;
    public int num_arret;

    public Autobus(int nbPlaceAssise, int nbPlaceDebout) {
	if (nbPlaceAssise < 0) {
	    throw new IllegalArgumentException();
	}else {
	    assis = new Jauge(nbPlaceAssise,0);
	    passagers = new Passager[nbPlaceDebout+nbPlaceAssise];
	}
	debouts = new Jauge(nbPlaceDebout,0);
	num_arret = 0;
    }

    
    private int chercherEmplacementVide() {
        for (int i = 0; i < passagers.length; i++) {
	    if (passagers[i] == null)
		return i;
	}
       	return -1;
    }

    private int chercherPassager(Passager p) {
	for (int i = 0; i < passagers.length; i++) {
	    if ( passagers[i] == p)
		return i;
	}
	return -1;
    }

    void allerArretSuivant() {
	num_arret++;
	for (int i = 0; i < passagers.length; i++) {
	    if (passagers[i] != null) {
		passagers[i].nouvelArret(this,num_arret);
	    }
	}
    }
    
    boolean aPlaceAssise() {
	return assis.estVert();
    }
    
    boolean aPlaceDebout() {
	return debouts.estVert();
    }
    
    public void arretDemanderAssis(Passager p) {
	if (this.aPlaceAssise()) {
	    p.changerEnAssis();
	    assis.incrementer();
	    debouts.decrementer();
	}	   
    }

    void arretDemanderDebout(Passager p) {
	if (this.aPlaceDebout()) {
	    p.changerEnDebout();
	    debouts.incrementer();
	    assis.decrementer();
	}	   
    }

    void arretDemanderSortie(Passager p) {
	if (p.estAssis())
	    assis.decrementer();
	else
	    debouts.decrementer();
	int indiceDernierPassager = this.chercherEmplacementVide()-1;
	if (indiceDernierPassager<0)
	    indiceDernierPassager = passagers.length-1;
	passagers[this.chercherPassager(p)] = passagers[indiceDernierPassager];
	passagers[indiceDernierPassager] = null;
	p.changerEnDehors();	
    }

    void monteeDemanderAssis(Passager p) {
	if (chercherPassager(p) == -1) {
	    if (this.aPlaceAssise()) {
		p.changerEnAssis();
		assis.incrementer();
		passagers[chercherEmplacementVide()]=p;
	    }
	}
	else {
	    throw new IllegalStateException("Passenger already in the bus.");
	}	    
    }
    
    void monteeDemanderDebout(Passager p) {
	if (chercherPassager(p) == -1) {
	    if (this.aPlaceDebout()) {
		p.changerEnDebout();
		debouts.incrementer();
		passagers[chercherEmplacementVide()]=p;
	    }
	}
	else {
	    throw new IllegalStateException("Passenger already in the bus.");
	}	
    }
    
    public java.lang.String toString() {
	java.lang.String returnValue = "Passengers names : \n";
	for (int i=0;i<passagers.length;i++)
	    if (passagers[i]!=null)
		returnValue = returnValue + passagers[i].nom() + " ";
	    else
		returnValue = returnValue + "NoPassengerHere ";
	return returnValue;
    }
}
