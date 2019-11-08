package tec;

import utils.TestUtils;

class TestPassagerStandard extends TestPassagerAbstrait {

    public static void main(String[] args) {
        TestUtils.checkAssertionOption();
        int nbTest = 0;

        // test instanciation
        nbTest++;
        new TestPassagerStandard().testInstanciation();

        // test changement d'etat
        nbTest++;
        new TestPassagerStandard().testGestionEtat();

        // test montee d'un TestPassagerIndecis
        nbTest++;
        new TestPassagerStandard().testalaMontee();

        nbTest++;
        new TestPassagerStandard().testalArret();

        TestUtils.printTestsFinishedMessage(nbTest, "tec.TestPassagerStandard");
    }

    protected PassagerAbstrait creerPassager(String nom, int destination) {
        PassagerStandard p = new PassagerStandard(nom,destination);
        PassagerAbstrait pa = (PassagerAbstrait) p;
        return pa;
    }



    protected void testalaMontee() {
        PassagerAbstrait p = creerPassager("yyy", 5);

        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);

        assert "monteeDemanderAssis".equals(getLastLog(faux)) : "assis";

        faux = new FauxVehicule(FauxVehicule.DEBOUT);
        p.monterDans(faux);

        assert "monteeDemanderDebout".equals(getLastLog(faux)) : "debout";

        faux = new FauxVehicule(FauxVehicule.PLEIN);
        p.monterDans(faux);

        assert 0 == faux.logs.size() : "pas de place";
    }

    protected void testalArret() {
        super.testalArret();
    }
}
