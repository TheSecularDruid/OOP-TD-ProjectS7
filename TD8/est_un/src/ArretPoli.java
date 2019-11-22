package tec;

class ArretPoli implements ComportementArret {
    public void choixPlaceArret(final Passager p, final Vehicule v, final int distanceDestination) {
        if (!v.aPlaceAssise()) {
            v.arretDemanderDebout(p);
        }
    }
}
