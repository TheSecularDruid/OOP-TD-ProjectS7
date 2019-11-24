package tec;

/**
 * Classe faussaire pour le test unitaire fonctionnel
 * de MonteeRepos
 * <p>
 * Ce faussaire ne declenche pas d'appel aux methodes
 * de MonteeRepos.
 * <p>
 * Il ne change pas son etat (la variable d'instance status).
 * C'est le test qui change directement la valeur de cette variable.
 * <p>
 * Il enregistre l'appel aux méthodes qui
 * doivent modifier son etat.
 */
public class FauxVehicule extends Vehicule implements Transport {
    static final byte VIDE = 0;
    static final byte DEBOUT = 1;
    static final byte ASSIS = 2;
    static final byte PLEIN = 4;
    private byte status;

    final java.util.List<String> logs = new java.util.LinkedList<>();

    @SuppressWarnings("unused")
    FauxVehicule() {
        this(VIDE);
    }

    FauxVehicule(byte init) {
        status = init;
    }

    int getNumArret(){
        return 0;
    }


    boolean aPlaceAssise() {
        return status == ASSIS
                || status == VIDE;
    }

    boolean aPlaceDebout() {
        return status == DEBOUT
                || status == VIDE;
    }

    // Enregistrements des appels effectues par MonteeRepos.
    void monteeDemanderAssis(Passager p) {
        logs.add("monteeDemanderAssis");
    }

    void monteeDemanderDebout(Passager p) {
        logs.add("monteeDemanderDebout");
    }

    void arretDemanderDebout(Passager p) {
        logs.add("arretDemanderDebout");
    }

    void arretDemanderAssis(Passager p) {
        logs.add("arretDemanderAssis");
    }

    void arretDemanderSortie(Passager p) {
        logs.add("arretDemanderSortie");
    }

    // MonteeRepos n'utilise pas cette méthode.
    public void allerArretSuivant() {
    }
}
