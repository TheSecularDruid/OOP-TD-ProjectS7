package tec;

/**
 * Classe faussaire pour le test unitaire fonctionnel
 * d'Autobus.
 * <p>
 * Ce faussaire ne declenche pas d'appel aux methodes
 * d'Autobus.
 * <p>
 * Il ne change pas son etat (la variable d'instance status).
 * C'est le test qui change directement la valeur de cette variable.
 * <p>
 * Il enregistre l'appel aux méthodes qui doivent modifier son etat.
 */
class FauxPassager extends Passager implements Usager {
    private static final byte DEHORS = 0;
    static final byte ASSIS = 1;
    static final byte DEBOUT = 2;
    byte status;

    final java.util.List<String> logs = new java.util.LinkedList<>();

    FauxPassager() {
        this(DEHORS);
    }

    private FauxPassager(byte init) {
        status = init;
    }

    String nom() {
        return null;
    }

    boolean estDehors() {
        return status == DEHORS;
    }

    boolean estAssis() {
        return status == ASSIS;
    }

    boolean estDebout() {
        return status == DEBOUT;
    }

    // Enregistrements des appels effectues par Autobus.
    void changerEnDehors() {
        logs.add("changerEnDehors");
    }

    void changerEnAssis() {
        logs.add("changerEnAssis");
    }

    void changerEnDebout() {
        logs.add("changerEnDebout");
    }

    void nouvelArret(Vehicule bus, int numeroArret) {
        logs.add("nouvelArret");
    }

    @Override
    public void monterDans(final Transport t) {

    }
}
