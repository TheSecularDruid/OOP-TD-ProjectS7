package tec;

class TestPassagerStandard extends TestPassagerAbstrait {

    public PassagerAbstrait creerPassager(String nom, int destination) {
        ArretCalme arretCalme = new ArretCalme();
        MonteeRepos p = new MonteeRepos(nom, destination, arretCalme);
        PassagerAbstrait pa = (PassagerAbstrait) p;
        return pa;
    }

 
    public void testalaMontee() {
        PassagerAbstrait p = creerPassager("yyy", 5);

        FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
        p.monterDans(faux);
        assert "monteeDemanderAssis".equals(getLastLog(faux)) : "assis";

        faux = new FauxVehicule(FauxVehicule.DEBOUT);
        p.monterDans(faux);
        assert "monteeDemanderDebout".equals(getLastLog(faux)) : "debout";

        faux = new FauxVehicule(FauxVehicule.ASSIS);
        p.monterDans(faux);
        assert "monteeDemanderAssis".equals(getLastLog(faux)) : "assis";

        faux = new FauxVehicule(FauxVehicule.PLEIN);
        p.monterDans(faux);
        assert 0 == faux.logs.size() : "pas de place";
    }

    public void testalArret() {
        super.testalArret();
    }
}
