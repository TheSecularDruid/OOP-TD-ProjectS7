package tec;

class ArretPrudent{
    static void choixPlaceArret(Passager p, Vehicule v, int arret, int distanceDestination) {	
	if (v.aPlaceAssise()&&distanceDestination>=5)
	    v.arretDemanderAssis(p);
	if (v.aPlaceDebout()&&distanceDestination<=3)
	    v.arretDemanderDebout(p);
    }
}
