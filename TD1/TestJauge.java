class TestJauge {

    static public void main(String[] argvs) {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}
	
	int nb_of_tests = 0;
	TestJauge temp = new TestJauge();	
	temp.testDansIntervalle();
	System.out.println(".");
	nb_of_tests ++;
	temp.testDépartSupMax();
	System.out.println(".");
	nb_of_tests ++;
	temp.testDéparEgalMax();
	System.out.println(".");
	nb_of_tests ++;
	System.out.println("OK," + nb_of_tests + " tests passed.");
    }

    public TestJauge() {
	
    }

    public void testDansIntervalle() {
	Jauge jaugeTest = new Jauge(67899,100);
	
	assert jaugeTest.estVert() : "Erreur verte";
	assert !(jaugeTest.estRouge()) : "Erreur rouge";
    }

    public void testDépartSupMax() {
	Jauge jaugeTest = new Jauge(25,42);
	
	//assert !jaugeTest.estVert() : "Erreur verte";
	assert jaugeTest.estRouge() : "Erreur rouge";
    }
    /*******************************************
     Rapport de Bogue sur testDépartSupMax() :
     L'appel de estVert() renvoie true alors que
     la spécification précise qu'elle devrait
     renvoyer false.
     *******************************************/
    
    public void testDépartEgalMax() {
	Jauge jaugeTest = new Jauge(42,42);
	
	assert jaugeTest.estVert() : "Erreur verte";
	assert jaugeTest.estRouge() : "Erreur rouge";
    }
}	
	
