package tec;

public abstract class FabriqueTec {
    static public Transport faireAutobus(int nbPlaceAssise, int nbPlaceDebout) {
	return ((Transport)new Autobus(nbPlaceAssise, nbPlaceDebout));
    }

    static public Usager fairePassagerStandard(java.lang.String nom, int destination) {
	return ((Usager)new PassagerStandard(nom, destination));
    }
}
