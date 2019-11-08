package tec;

import tec.ComportementArret;

public abstract class FabriqueTec {
    static public Transport faireAutobus(int nbPlaceAssise, int nbPlaceDebout) {
	return ((Transport)new Autobus(nbPlaceAssise, nbPlaceDebout));
    }
    
    static public Usager fairePassagerStandard(java.lang.String nom, int destination) {
	return ((Usager)new MonteeRepos(nom, destination, ComportementArret.CALME));
    }

static public Usager fairePassagerPresse(java.lang.String nom, int destination) {
	return ((Usager)new MonteeFatigue(nom, destination, ComportementArret.PRUDENT));
    }

static public Usager fairePassagerIndecis(java.lang.String nom, int destination) {
	return ((Usager)new MonteeSportif(nom, destination, ComportementArret.NERVEUX));
    }
}

