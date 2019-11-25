package tec;

public class TestJauge {

    public Jauge maJauge;

    public void testConstrJauge() {
        maJauge = new Jauge(10, 5);
        assert maJauge.toString().equals("<5 [0,10[>");
    }

    public void testEstVert() {
        for (int i = 0; i < 10; i++) {
            maJauge = new Jauge(10, i);
            assert (maJauge.estVert()) : "doit etre vert";
        }

        maJauge = new Jauge(10, -1);
        assert (!maJauge.estVert()) : "ne doit pas etre vert";

        maJauge = new Jauge(10, 10);
        assert (!maJauge.estVert()) : "ne doit pas etre vert";

        maJauge = new Jauge(10, -2);
        assert (!maJauge.estVert()) : "ne doit pas etre vert";

        maJauge = new Jauge(10, 11);
        assert (!maJauge.estVert()) : "ne doit pas etre vert";
    }

    public void testEstRouge() {
        for (int i = 0; i < 10; i++) {
            maJauge = new Jauge(10, i);
            assert (!maJauge.estRouge()) : "ne doit pas etre rouge";
        }

        maJauge = new Jauge(10, -1);
        assert (!maJauge.estRouge()) : "ne doit pas etre rouge";

        maJauge = new Jauge(10, 10);
        assert (maJauge.estRouge()) : "doit etre rouge";

        maJauge = new Jauge(10, -2);
        assert (!maJauge.estRouge()) : "ne doit pas etre rouge";

        maJauge = new Jauge(10, 11);
        assert (maJauge.estRouge()) : "doit etre rouge";
    }

    public void testIncrementer() {
        maJauge = new Jauge(5, 2);
        for (int i = 2; i < 4; i++) {
            maJauge.incrementer();
            assert (maJauge.estVert()) : "doit etre vert";
        }
        maJauge.incrementer();
        assert (!maJauge.estVert()) : "ne doit pas etre vert";
    }


    public void testDecrementer() {
        maJauge = new Jauge(5, 5);
        for (int i = 0; i < 4; i++) {
            maJauge.decrementer();
            assert (!maJauge.estRouge()) : "ne doit pas etre rouge";
        }

        maJauge.decrementer();
        assert (!maJauge.estRouge()) : "ne doit pas etre rouge";
    }

    public void testCasLimite() {
        try {
            Jauge inverse = null;

            inverse = new Jauge(-10, 5);
            assert false : "Exception non levée";
        } catch (IllegalArgumentException e) {

        }

    }

}
