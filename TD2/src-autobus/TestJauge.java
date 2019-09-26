class TestJauge {

    private int nb_of_tests;

    static public void main(String[] argvs) {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}
	
	TestJauge temp = new TestJauge();	
	temp.testDansIntervalle();
	temp.testAccompli();
	temp.testDépartSupMax();
	temp.testAccompli();
	temp.testDépartEgalMax();
	temp.testAccompli();
	temp.testDépartNégatif();
	temp.testAccompli();
	temp.testDépartNul();
	temp.testAccompli();
	temp.testDecrementer();
	temp.testAccompli();
	temp.testIncrementer();
	temp.testAccompli();
	System.out.println("OK," + temp.nb_of_tests + " tests passed.");
    }

    public TestJauge() {
	nb_of_tests = 0;
    }
    private void testAccompli() {
	System.out.println(".");
	nb_of_tests ++;
    }

    public void testDansIntervalle() {
	Jauge jaugeTest = new Jauge(67899,100);
	
	assert jaugeTest.estVert() : "Erreur verte";
	assert !(jaugeTest.estRouge()) : "Erreur rouge";
    }

    public void testDépartSupMax() {
	Jauge jaugeTest = new Jauge(25,42);

	assert !jaugeTest.estVert() : "Erreur verte";
	assert jaugeTest.estRouge() : "Erreur rouge";
    }
    
    public void testDépartEgalMax() {
	Jauge jaugeTest = new Jauge(42,42);

	assert !jaugeTest.estVert() : "Erreur verte";
	assert jaugeTest.estRouge() : "Erreur rouge";
    }
    
    public void testDépartNégatif() {
	Jauge jaugeTest = new Jauge(4,-24);

	assert !jaugeTest.estVert() : "Erreur verte";
	assert !jaugeTest.estRouge() : "Erreur rouge";
    }

    public void testDépartNul() {
	Jauge jaugeTest = new Jauge(54,0);

	assert jaugeTest.estVert() : "Erreur verte";
	assert !jaugeTest.estRouge() : "Erreur rouge";
    }

    public void testDecrementer() {
	Jauge jaugeTest = new Jauge(42,42);
	jaugeTest.decrementer();

	assert !jaugeTest.estRouge() : "Erreur dans decrementer()";
    }

    public void testIncrementer() {
	Jauge jaugeTest = new Jauge(64,64);
	jaugeTest.incrementer();

	assert jaugeTest.estRouge() : "Erreur dans incrementer()";
    }
}	
	
