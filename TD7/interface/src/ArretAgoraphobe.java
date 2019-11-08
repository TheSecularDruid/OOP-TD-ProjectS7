package tec;

class ArretAgoraphobe{
    static void choixPlaceArret(Passager p, Vehicule v, int arret, int distanceDestination) {
	if (!(v.aPlaceAssise()&&v.aPlaceDebout()))
	    v.arretDemanderSortie(p);
    }
}
