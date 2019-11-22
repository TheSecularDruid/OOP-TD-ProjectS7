package tec;

class ArretAgoraphobe implements ComportementArret {
    public void choixPlaceArret(final Passager p, final Vehicule v, final int distanceDestination) {
        if (!v.aPlaceAssise() || !v.aPlaceDebout()) {
            v.arretDemanderSortie(p);
            p.changerEnDehors();
        }
    }
}
