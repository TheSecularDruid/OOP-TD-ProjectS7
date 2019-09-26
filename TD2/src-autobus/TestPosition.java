class TestPosition {

    static public void main(String[] argvs) {
	boolean estMisAssertion = false;
	assert estMisAssertion = true;
	
	if (!estMisAssertion) {
	    System.out.println("Execution impossible sans l'option -ea");
	    return;
	}
	
	TestPosition temp = new TestPosition();

	//temp.testAssis();
	//temp.testDebout();
	temp.testDehors();
    }

    public TestPosition() {

    }
    
    
    public void testAssis() {

	Position positionTest = new Position();
	positionTest.assis();
	
	assert positionTest.estAssis() : "Erreur assis"; //Le test ne passe pas
	assert !positionTest.estDebout() : "Erreur debout"; //Le test passe
	assert !positionTest.estDehors() : "Erreur dehors"; //Le test ne passe pas
	assert positionTest.estInterieur() : "Erreur interieur"; //Le test ne passe pas

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

	Position positionTest = new Position();
	positionTest.debout();
	
	assert !positionTest.estAssis() : "Erreur assis";
	assert positionTest.estDebout() : "Erreur debout";
	assert !positionTest.estDehors() : "Erreur dehors";
	assert positionTest.estInterieur() : "Erreur interieur";
    }
       
  /*******************************************
     Rapport de Bogue sur testDebout() :
     L'appel de estAssis() renvoie true alors que
     la spécification précise qu'il devrait renvoyer false.
     Le passager qui devrait être "debout" (donc également 
     "à l'intérieur") est indiqué comme
     non assis, non debout, et dehors (non à l'intérieur).
     *******************************************/

    public void testDehors() {
	Position positionTest = new Position();
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
