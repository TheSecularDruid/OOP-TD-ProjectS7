package tec;

class TestPassagerIndecis extends TestPassagerAbstrait {

    public PassagerAbstrait creerPassager(String nom, int destination) {
        ArretNerveux arretNerveux = new ArretNerveux();
        MonteeSportif p = new MonteeSportif(nom, destination, arretNerveux);
        PassagerAbstrait pa = (PassagerAbstrait) p;
        return pa;
    }

    public void testalaMontee() {
        PassagerAbstrait p = creerPassager("yyy", 5);

        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);
        assert !"monteeDemanderAssis".equals(getLastLog(faux)) : "debout";

        faux = new FauxVehicule(FauxVehicule.DEBOUT);
        p.monterDans(faux);
        assert "monteeDemanderDebout".equals(getLastLog(faux)) : "assis";

        faux = new FauxVehicule(FauxVehicule.ASSIS);
        p.monterDans(faux);
        assert 0 == faux.logs.size() : "dehors";

        faux = new FauxVehicule(FauxVehicule.PLEIN);
        p.monterDans(faux);
        assert 0 == faux.logs.size() : "pas de place";
    }


    public void testalArret() {

        PassagerAbstrait p = creerPassager("yyy", 5);
        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);

        for (int i = 1; i < 5; i++) {

            p.nouvelArret(faux, i);

            if (p.estAssis())
                assert "changerEnDebout".equals(getLastLog(faux)) : "veut se lever";
            else if (p.estDebout()) {
                assert "changerEnAssis".equals(getLastLog(faux)) : "veut s'asseoir";
            }

        }

        p.nouvelArret(faux, 5);
        assert "arretDemanderSortie".equals(getLastLog(faux)) : "destination";

    }

}
