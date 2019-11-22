package tec;

import utils.TestUtils;

class TestPassagerStresse extends TestPassagerAbstrait {

  public static void main (String[] args) {
      TestUtils.checkAssertionOption();
      int nbTest = 0;

      // test instanciation
      nbTest++;
      new TestPassagerStresse().testInstanciation();

      // test changement d'etat
      nbTest++;
      new TestPassagerStresse().testGestionEtat();

      // test montee d'un TestPassagerIndecis
      nbTest++;
      new TestPassagerStresse().testalaMontee();

      // test changement de place a chaque arret
      nbTest++;
      new TestPassagerStresse().testalArret();

      TestUtils.printTestsFinishedMessage(nbTest, "tec.TestPassagerStresse");
  }

    protected PassagerAbstrait creerPassager(String nom, int destination) {
        PassagerStresse p = new PassagerStresse(nom,destination);
        PassagerAbstrait pa = (PassagerAbstrait) p;
        return pa;
    }


    /* A la montee  d'un PassagerStresse :
     *  - le PassagerStresse monte si il y a une place debout ou assise, sinon il reste dehors.
     */
    protected void testalaMontee() {
        PassagerAbstrait p = creerPassager("M.Presse", 5);

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

    /* A partir de 3 arrets avant sa destination si le Passager
    n'est pas debout alors il se leve
     */
    protected void testalArret() {

        super.testalArret();

        PassagerAbstrait p = creerPassager("M.Presse", 5);
        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);

        p.nouvelArret(faux, 1);
        assert !"arretDemanderDebout".equals(getLastLog(faux)) : "ne demande pas debout";

        p.nouvelArret(faux, 2); /*A 3 arret desa destination le PassagerStresse se lève*/
        assert "arretDemanderDebout".equals(getLastLog(faux)) : "debout";
    }
}
