package tec;

class TestAutobus {

    public void testInstanciation() {
        // assis
        try {
            Autobus assis = new Autobus(66, 0);
            assert assis.aPlaceAssise();
            assert !assis.aPlaceDebout();
        } catch (Exception e) {
            assert false : "Init failure";
        }


        // debout
        try {
            Autobus debout = new Autobus(0, 99);

            assert !debout.aPlaceAssise();
            assert debout.aPlaceDebout();
        } catch (Exception e) {
            assert false : "Init failure";
        }
    }

    public void testGestionDemander() {
        FauxPassager[] faux = {
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager()}; //10

        Autobus bus;
        try {
            bus = new Autobus(5, 3);

            // assis
            for (int i = 1; i < 5; i++) { //4
                bus.monteeDemanderAssis(faux[i]);
                assert bus.aPlaceAssise() : "demande " + i;
            }

            bus.monteeDemanderAssis(faux[5]);
            assert !bus.aPlaceAssise() : "demande 5: fin assis";


            // debout
            bus.monteeDemanderDebout(faux[6]);
            assert bus.aPlaceDebout() : "demande 1";

            bus.monteeDemanderDebout(faux[7]);
            assert bus.aPlaceDebout() : "demande 2";

            bus.monteeDemanderDebout(faux[8]);
            assert !bus.aPlaceDebout() : "demande 3: fin debout";
        } catch (Exception e) {
            assert false : "Init failure";
        }
    }

    public void testGestionSortie() {
        FauxPassager[] faux = {
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager()}; // 9

        try {
            Autobus bus = new Autobus(3, 4);

            for (int i = 1; i < 4; i++) { //3
                bus.monteeDemanderAssis(faux[i]);
                faux[i].status = FauxPassager.ASSIS;
            }

            for (int i = 4; i <= 7; i++) { //4
                bus.monteeDemanderDebout(faux[i]);
                faux[i].status = FauxPassager.DEBOUT;
            }

            bus.arretDemanderSortie(faux[6]);
            assert bus.aPlaceDebout() : "sortie debout";

            bus.arretDemanderSortie(faux[2]);
            assert bus.aPlaceAssise() : "sortie assis";
        } catch (Exception e) {
            assert false : "Init failure";
        }
    }


    public void testGestionChanger() {
        FauxPassager[] faux = {
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager()}; // 9

        try {
            Autobus bus = new Autobus(3, 5);
            for (int i = 1; i < 4; i++) { //3
                bus.monteeDemanderAssis(faux[i]);
                faux[i].status = FauxPassager.ASSIS;
            }

            for (int i = 4; i <= 7; i++) { //4
                bus.monteeDemanderDebout(faux[i]);
                faux[i].status = FauxPassager.DEBOUT;
            }

            bus.arretDemanderDebout(faux[2]);
            assert bus.aPlaceAssise() : "assis";
            assert !bus.aPlaceDebout() : "debout";

            bus.arretDemanderAssis(faux[5]);
            assert !bus.aPlaceAssise() : "assis";
            assert bus.aPlaceDebout() : "debout";
        } catch (Exception e) {
            assert false : "Init failure";
        }
    }

    public void testDemander() {
        FauxPassager[] faux = {
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager()}; //10

        try {
            Autobus bus = new Autobus(3, 5);

            //*********** Debout ******************************
            for (int i = 1; i < 6; i++) { //5
                bus.monteeDemanderDebout(faux[i]);
                assert 1 == faux[i].logs.size()
                        : "erreur nombre d'appels pour " + i;
                assert "changerEnDebout".equals(getLastLog(faux[i]))
                        : "mauvais appel pour " + i;
            }

            //********* Assis *******************************
            for (int i = 6; i < 9; i++) { //3
                bus.monteeDemanderAssis(faux[i]);
                assert 1 == faux[i].logs.size()
                        : "erreur nombre d'appels pour " + i;
                assert "changerEnAssis".equals(getLastLog(faux[i]))
                        : "mauvais appel pour " + i;
            }
        } catch (Exception e) {
            assert false : "Init failure";
        }
    }

    public void testChanger() {
        FauxPassager faux = new FauxPassager();

        try {
            Autobus bus = new Autobus(1, 1);

            bus.monteeDemanderDebout(faux);
            faux.status = FauxPassager.DEBOUT;

            bus.arretDemanderAssis(faux);
            assert 2 == faux.logs.size() : "erreur nombre d'appels";
            assert "changerEnAssis".equals(getLastLog(faux)) : "mauvais appel";

            bus.arretDemanderDebout(faux);

            assert 3 != faux.logs.size() : "erreur nombre d'appels";
            assert !"changerEnDebout".equals(getLastLog(faux)) : "mauvais appel";
        } catch (Exception e) {
            assert false : "Init failure";
        }
    }

    public void testInteractionSortie() {
        FauxPassager[] faux = {
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager()}; // 9

        try {
            Autobus bus = new Autobus(10, 20);

            bus.monteeDemanderAssis(faux[1]);
            faux[1].status = FauxPassager.ASSIS;

            bus.monteeDemanderDebout(faux[2]);
            faux[2].status = FauxPassager.DEBOUT;

            bus.monteeDemanderDebout(faux[3]);
            faux[3].status = FauxPassager.DEBOUT;

            bus.monteeDemanderAssis(faux[4]);
            faux[4].status = FauxPassager.ASSIS;

            bus.monteeDemanderDebout(faux[5]);
            faux[5].status = FauxPassager.DEBOUT;

            bus.monteeDemanderAssis(faux[6]);
            faux[6].status = FauxPassager.ASSIS;

            bus.monteeDemanderAssis(faux[7]);
            faux[7].status = FauxPassager.ASSIS;

            // sortie
            bus.arretDemanderSortie(faux[6]);
            assert 2 == faux[6].logs.size() : "erreur nombre d'appels";
            assert "changerEnDehors".equals(getLastLog(faux[6])) : "mauvais appel";

            bus.arretDemanderSortie(faux[2]);
            assert 2 == faux[2].logs.size() : "erreur nombre d'appels";
            assert "changerEnDehors".equals(getLastLog(faux[2])) : "mauvais appel";
        } catch (Exception e) {
            assert false : "Init failure";
        }
    }

    public void testArretSuivant() {
        FauxPassager[] faux = {new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager(),
                new FauxPassager()}; // 9

        try {
            Autobus bus = new Autobus(99, 66);
            for (int i = 1; i < 5; i++) {
                bus.monteeDemanderAssis(faux[i]);
                faux[i].status = FauxPassager.ASSIS;
            }

            for (int i = 5; i < 9; i++) {
                bus.monteeDemanderDebout(faux[i]);
                faux[i].status = FauxPassager.DEBOUT;
            }
            bus.allerArretSuivant();

            for (int i = 1; i < 9; i++) {
                assert 2 == faux[i].logs.size()
                        : "erreur nombre d'appels pour " + i;
                assert "nouvelArret".equals(getLastLog(faux[i]))
                        : "mauvais appel pour " + i;
            }

            bus.arretDemanderSortie(faux[3]);
            bus.arretDemanderSortie(faux[6]);
            bus.arretDemanderSortie(faux[8]);

            bus.monteeDemanderDebout(faux[0]);
            faux[0].status = FauxPassager.DEBOUT;

            bus.allerArretSuivant();

            assert !"nouvelArret".equals(getLastLog(faux[3]))
                    : "plus d'appel a nouvelArret:3";
            assert !"nouvelArret".equals(getLastLog(faux[6]))
                    : "plus d'appel a nouvelArret:6";
            assert !"nouvelArret".equals(getLastLog(faux[8]))
                    : "plus d'appel a nouvelArret:8";

            assert "nouvelArret".equals(getLastLog(faux[0]))
                    : "plus d'appel a nouvelArret:0";

            for (int i = 1; i < 8; i++) {
                if (3 == i || 6 == i)
                    continue;

                assert 3 == faux[i].logs.size()
                        : "erreur nombre d'appels pour " + i;
                assert "nouvelArret".equals(getLastLog(faux[i]))
                        : "mauvais appel pour " + i;
            }
        } catch (Exception e) {
            assert false : "Init failure";
        }
    }

    public void testCasLimite() {
        try {
            Autobus autobus = new Autobus(-1, 1);
            assert false : "Forbidden path";
        } catch (Exception e) {
            assert true;
        }

        try {
            Autobus autobus = new Autobus(50, -1);
            assert false : "Forbidden path";
        } catch (Exception e) {
            assert true;
        }

        try {
            Autobus autobus = new Autobus(-453, -1);
            assert false : "Forbidden path";
        } catch (Exception e) {
            assert true;
        }
    }

    public String getLastLog(FauxPassager f) {
        return f.logs.get(f.logs.size() - 1);
    }
}
