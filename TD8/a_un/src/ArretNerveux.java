package tec;

class ArretNerveux implements ComportementArret {
    public void choixPlaceArret(final Passager p, final Vehicule v, final int distanceDestination) {
        if (p.estAssis() && v.aPlaceDebout()) {
            v.arretDemanderDebout(p);
        }
        if (p.estDebout() && v.aPlaceAssise()) {
            v.arretDemanderAssis(p);
        }
    }
}
