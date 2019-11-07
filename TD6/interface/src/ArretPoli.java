package tec;

class ArretPoli{
    static void choixPlaceArret(Passager p, Vehicule v, int arret, int distanceDestination) {
	if(!v.aPlaceAssise())
	    v.arretDemanderDebout(p);
    }
}
