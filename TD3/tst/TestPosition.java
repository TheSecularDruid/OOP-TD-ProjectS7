import tec.*;

class TestPosition {

    private int nb_of_tests;

    static public void main(String[] argvs) {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}

	int nb_of_tests = 0;
	TestPosition temp = new TestPosition();

	temp.testAssis();
	temp.testAccompli();
	
	temp.testDebout();
	temp.testAccompli();
	
	temp.testDehors();
	temp.testAccompli();

	System.out.println("OK," + temp.nb_of_tests + " tests executés.");
    }

    public TestPosition() {
	nb_of_tests = 0;
    }
    
    private void testAccompli() {
	System.out.println(".");
	nb_of_tests ++;
    }
    
    public void testAssis() {

	Position positionTest = Position.DEHORS;
	positionTest.assis();
	
	//assert positionTest.estAssis() : "Erreur assis"; //Le test ne passe pas
	assert !positionTest.estDebout() : "Erreur debout"; //Le test passe
	//assert !positionTest.estDehors() : "Erreur dehors"; //Le test ne passe pas
	//assert positionTest.estInterieur() : "Erreur interieur"; //Le test ne passe pas

    }
    
    
  /*******************************************
     Rapport de Bogue sur testAssis() :
     L'appel de estAssis() renvoie false alors que
     la spécification précise qu'il devrait renvoyer true.
     Le passager qui devrait être "assis" (donc également 
     "à l'intérieur") est indiqué comme
     non assis, non debout, et dehors (non à l'intérieur).
     *******************************************/
    
    public void testDebout() {

	Position positionTest = Position.DEHORS;
	positionTest.debout();
	
	assert !positionTest.estAssis() : "Erreur assis";  //Le test passe
	//assert positionTest.estDebout() : "Erreur debout"; //Le test ne passe pas
	//assert !positionTest.estDehors() : "Erreur dehors"; //Le test ne passe pas
	//assert positionTest.estInterieur() : "Erreur interieur"; //Le test ne passe pas
    }
       
  /*******************************************
     Rapport de Bogue sur testDebout() :
     L'appel de estDebout() renvoie false alors que
     la spécification précise qu'il devrait renvoyer true.
     Le passager qui devrait être "debout" (donc également 
     "à l'intérieur") est indiqué comme
     non assis, non debout, et dehors (non à l'intérieur).
     *******************************************/

    public void testDehors() {
	Position positionTest = Position.DEHORS;
	positionTest.dehors();
	
	assert !positionTest.estAssis() : "Erreur assis";
	assert !positionTest.estDebout() : "Erreur debout";
	assert positionTest.estDehors() : "Erreur dehors";
	assert !positionTest.estInterieur() : "Erreur interieur";
    }
}	
   
  /*******************************************
     Rapport de Bogue sur testDehors() :
     Tout fonctionne, cependant il semblerait, d'après
     le comportement de tous les tests, que les
     méthodes assis(), debout() et dehors() agissent
     toutes de manière identique et donnent le
     comportement de dehors().
     *******************************************/
