package tec;

import utils.TestUtils;

class TestPassagerIndecis extends TestPassagerAbstrait {

    public static void main (String[] args) {
        TestUtils.checkAssertionOption();
        int nbTest = 0;

        // test instanciation
        nbTest++;
        new TestPassagerIndecis().testInstanciation();

        // test changement d'etat
        nbTest++;
        new TestPassagerIndecis().testGestionEtat();

        // test montee d'un TestPassagerIndecis
        nbTest++;
        new TestPassagerIndecis().testalaMontee();

        // test changement de place a chaque arret
        nbTest++;
        new TestPassagerIndecis().testalArret();

        TestUtils.printTestsFinishedMessage(nbTest, "tec.TestPassagerIndecis");
    }

    protected PassagerAbstrait creerPassager(String nom, int destination) {
        PassagerIndecis p = new PassagerIndecis(nom,destination);
        PassagerAbstrait pa = (PassagerAbstrait) p;
        return pa;
    }

    /* 3 cas à la montee : places assises
    et debout, uniquement debout, pas de place
     */
    protected void testalaMontee() {
        PassagerAbstrait p = creerPassager("yyy", 5);

        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);
        assert !"monteeDemanderAssis".equals(getLastLog(faux)) : "debout";

        faux = new FauxVehicule(FauxVehicule.DEBOUT);
        p.monterDans(faux);
        assert "monteeDemanderDebout".equals(getLastLog(faux)) : "assis";

        faux = new FauxVehicule(FauxVehicule.PLEIN);
        p.monterDans(faux);
        assert 0 == faux.logs.size() : "pas de place";
    }

    /* 2 cas à un arret : arret < destination
    et arret >= destination et change de position
    2 possibilite : veut passer de assis a debout
    ou de debout a assis
     */
    protected void testalArret() {

        PassagerAbstrait p = creerPassager("yyy", 5);
        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);

        for(int i=1;i<5;i++){

            p.nouvelArret(faux, i);

            if(p.estAssis())
                assert "changerEnDebout".equals(getLastLog(faux)) : "veut se lever";
            else if(p.estDebout()){
                assert "changerEnAssis".equals(getLastLog(faux)) : "veut s'asseoir";
            }

        }

        p.nouvelArret(faux, 5);
        assert "arretDemanderSortie".equals(getLastLog(faux)) : "destination";

    }

}
