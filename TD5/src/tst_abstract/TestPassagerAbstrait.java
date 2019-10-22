package tec;

import utils.TestUtils;

abstract class TestPassagerAbstrait {

// pour tester Indecis et Stresse au lieu de Standard uniquement
  protected abstract PassagerAbstrait creerPassager(String nom, int destination);


    void testInstanciation() {
        PassagerAbstrait p = creerPassager("xxx", 3);

        assert !p.estAssis();
        assert !p.estDebout();
        assert p.estDehors();
    }

    /* Gestion des changements d'état : changer Debout puis Dehors
    puis Assis
     */
    void testGestionEtat() {
        PassagerAbstrait p = creerPassager("yyy", 3);

        p.changerEnDebout();
        assert !p.estAssis();
        assert p.estDebout();
        assert !p.estDehors();

        p.changerEnDehors();
        assert !p.estAssis();
        assert !p.estDebout();
        assert p.estDehors();

        p.changerEnAssis();
        assert p.estAssis();
        assert !p.estDebout();
        assert !p.estDehors();
    }

    /* 3 cas à la montee : places assises
    et debout, uniquement debout, pas de place
     */
    protected abstract void testalaMontee();

    /* 2 cas à un arret : arret < destination
    et arret >= destination
     */
    protected void testalArret(){
        PassagerAbstrait p = creerPassager("yyy", 5);

        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

        p.nouvelArret(faux, 1);
        assert 0 == faux.logs.size() : "pas a destination";

        p.nouvelArret(faux, 5);
        assert "arretDemanderSortie".equals(getLastLog(faux)) : "destination";
    }

    static String getLastLog(FauxVehicule f) {
        return f.logs.get(f.logs.size() - 1);
    }
}
