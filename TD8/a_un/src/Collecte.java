package collecte;

public abstract class Collecte {
    protected Donnees donnees;

    Collecte() {
	donnees = new Donnees();
    }

    public void uneEntree() {
	donnees.montee();
    }

    public void uneSortie() {
	donnees.descente();
    }

    public void changerArret(int numArret) {
	donnees.changerArret(numArret);
    }

    public String toString() {
	return "Arret "+donnees.arret+" : "+donnees.nbMontee+" entrees et "+donnees.nbDescente+" sorties";
    }
}
