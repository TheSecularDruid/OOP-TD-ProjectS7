package tec;

public class TestPosition {

    public void testAssis() {
        Position maPosition = Position.dehors();
        maPosition = maPosition.assis();
        assert maPosition.estAssis();
        assert maPosition.estInterieur();
    }

    public void testDebout() {
        Position maPosition = Position.dehors();
        maPosition = maPosition.debout();
        assert maPosition.estDebout();
        assert maPosition.estInterieur();
    }

    public void testDehors() {
        Position maPosition = Position.dehors();
        maPosition = maPosition.dehors();
        assert maPosition.estDehors();
    }

}
