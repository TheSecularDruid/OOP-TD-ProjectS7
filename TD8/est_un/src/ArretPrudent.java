package tec;

class ArretPrudent implements ComportementArret {
    public void choixPlaceArret(final Passager p, final Vehicule v, final int distanceDestination) {
        if (distanceDestination <= 3) {
            v.arretDemanderDebout(p);
        }
    }
}
