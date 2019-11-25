package tec;

class TestPassagerStresse extends TestPassagerAbstrait {

    public PassagerAbstrait creerPassager(String nom, int destination) {
        ArretPrudent arretPrudent = new ArretPrudent();
        MonteeFatigue p = new MonteeFatigue(nom, destination, arretPrudent);
        PassagerAbstrait pa = (PassagerAbstrait) p;
        return pa;
    }

    public void testalaMontee() {
        PassagerAbstrait p = creerPassager("M.Presse", 5);

        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);
        assert "monteeDemanderAssis".equals(getLastLog(faux)) : "assis";

        faux = new FauxVehicule(FauxVehicule.DEBOUT);
        p.monterDans(faux);
        assert 0 == faux.logs.size() : "dehors";

        faux = new FauxVehicule(FauxVehicule.ASSIS);
        p.monterDans(faux);
        assert "monteeDemanderAssis".equals(getLastLog(faux)) : "dehors";

        faux = new FauxVehicule(FauxVehicule.PLEIN);
        p.monterDans(faux);
        assert 0 == faux.logs.size() : "pas de place";

    }


    public void testalArret() {

        super.testalArret();

        PassagerAbstrait p = creerPassager("M.Presse", 5);
        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);

        p.nouvelArret(faux, 1);
        assert !"arretDemanderDebout".equals(getLastLog(faux)) : "ne demande pas debout";

        p.nouvelArret(faux, 2); 
        assert "arretDemanderDebout".equals(getLastLog(faux)) : "debout";
    }
}
