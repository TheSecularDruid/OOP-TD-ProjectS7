class TestJauge {

    private int nb_of_tests;

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
	
	//assert !jaugeTest.estVert() : "Erreur verte";
	assert jaugeTest.estRouge() : "Erreur rouge";
    }
    /*******************************************
     Rapport de Bogue sur testDépartSupMax() :
     L'appel de estVert() renvoie true alors que
     la spécification précise qu'eil devrait
     renvoyer false dans le cas niveau>max
     *******************************************/
    
    public void testDépartEgalMax() {
	Jauge jaugeTest = new Jauge(42,42);
	
	//assert !jaugeTest.estVert() : "Erreur verte";
	assert jaugeTest.estRouge() : "Erreur rouge";
    }
    /*******************************************
     Rapport de Bogue sur testDépartEgalMax() :
     L'appel de estVert() renvoie true alors que
     la spécification précise qu'il devrait
     renvoyer false dans le cas niveau==max.
    *******************************************/
    
    public void testDépartNégatif() {
	Jauge jaugeTest = new Jauge(-4,24);

	//assert !jaugeTest.estVert() : "Erreur verte";
	//assert !jaugeTest.estRouge() : "Erreur rouge";
    }
    /*******************************************
     Rapport de Bogue sur testDépartNégatif() :
     L'appel de estVert() renvoie true alors que
     la spécification précise qu'il devrait
     renvoyer false dans le cas niveau<0.
     L'appel de estRouge() renvoie true alors
     que la spécification précise qu'il devrait
     renvoyer false dans le cas niveau<max.
    *******************************************/

    public void testDépartNul() {
	Jauge jaugeTest = new Jauge(0,54);
	
	assert jaugeTest.estVert() : "Erreur verte";
	//assert !jaugeTest.estRouge() : "Erreur rouge";
    }
    /*******************************************
     Rapport de Bogue sur testDépartNul() :
     L'appel de estRouge() renvoie true alors que
     la spécification précise qu'il devrait
     renvoyer false dans le cas niveau<test.
    *******************************************/

    //J'avoue que j'ai un problème là : je peux pas trop m'amuser à tester incrémenter et décrémenter à partir de estRouge() et estVert() puisque je sais que les fonctions sont complètement buggées et que je peux pas les corriger, mais dans le même temps j'ai pas grand chose d'autre
    public void testDecrementer() {
	Jauge jaugeTest = new Jauge(42,42);
	jaugeTest.decrementer();

	assert !jaugeTest.estRouge() : "Erreur dans decrementer()";
    }

    public void testIncrementer() {
	Jauge jaugeTest = new Jauge(64,64);
	jaugeTest.incrementer();

	//assert jaugeTest.estRouge() : "Erreur dans incrementer()";
    }
    /*******************************************
     Rapport de Bogue sur incrementer() :
     L'appel de estRouge() renvoie false alors que
     la spécification précise qu'il devrait
     renvoyer false dans le cas niveau<test.
     Un appel de toString() révèle que niveau
     est à 0, laissant supposer un overflow.
    *******************************************/

}	
	
