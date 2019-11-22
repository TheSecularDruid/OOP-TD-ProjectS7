package collecte;

public class Donnees {
    int arret;
    int nbMontee;
    int nbDescente;

    public Donnees() {
        arret = 0;
        nbMontee = 0;
        nbDescente = 0;
    }

    void changerArret(int numArret) {
        nbMontee = 0;
        nbDescente = 0;
        arret = numArret;
    }

    void montee(){
        this.nbMontee++;
    }

    void descente(){
        this.nbDescente++;
    }

}
