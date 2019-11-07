package tec;

class ArretNerveux{
    static void choixPlaceArret(Passager p, Vehicule v, int arret, int distanceDestination) {
	if(p.estDebout())
	    v.arretDemanderAssis(p);
	if(p.estAssis())
	    v.arretDemanderDebout(p);
    }
}
