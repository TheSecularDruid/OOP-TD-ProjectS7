package tec;

public abstract class FabriqueTec {
    static public Transport faireAutobus(int nbPlaceAssise, int nbPlaceDebout) {
	return ((Transport)new Autobus(nbPlaceAssise, nbPlaceDebout));
    }
    
    enum comportement_montee {FATIGUE, TETU, REPOS, SPORTIF}
    static public Usager fairePassager(java.lang.String nom, int destination, comportement_arret comp_arret, comportement_montee comp_montee) {
	switch(comp_montee) {
	case FATIGUE:
	    return ((Usager)new MonteeFatigue(nom, destination, comp_arret));
	case TETU:
	    return ((Usager)new MonteeTetu(nom, destination, comp_arret));
	case REPOS:
	    return ((Usager)new MonteeRepos(nom, destination, comp_arret));
	case SPORTIF:
	    return ((Usager)new MonteeSportif(nom, destination, comp_arret));
	}
	
    }
}
