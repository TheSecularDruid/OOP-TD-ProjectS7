package tec;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class TestFichier {

    public void testInstanciationDefault() {
        try {
            Fichier fichier = new Fichier();
            fichier.supprimer();
            fichier.fermer();
            assert true;
        } catch (IOException e) {
            assert false : "failed to instance Fichier";
        }
    }

    public void testInstanciationFileName() {
        try {
            Fichier fichier = new Fichier("test");
            fichier.supprimer();
            fichier.fermer();
            assert true;
        } catch (IOException e) {
            assert false : "failed to instance Fichier";
        }
    }

    public void testCheckExistenceFichier() {
        try {
            Fichier fichier = new Fichier("test");
            assert new File("test").isFile();
            fichier.supprimer();
            fichier.fermer();
        } catch (IOException e) {
            assert false : "failed to instance Fichier";
        }
    }

    public void testEcriture() {
        try {
            Fichier fichier = new Fichier("test");
            File file = new File("test");
            List<String> line = Files.readAllLines(file.toPath());
            fichier.ecrire();
            List<String> line2 = Files.readAllLines(file.toPath());
            assert line.size() < line2.size();
            fichier.supprimer();
            fichier.fermer();
        } catch (IOException e) {
            assert false : "failed to instance Fichier";
        }
    }

    public void testChangerArret() {
        Fichier fichier;
        try {
            fichier = new Fichier("test");
            fichier.ecrire();
            String line = Files.readAllLines(new File("test").toPath()).get(0);
            fichier.changerArret(5);
            fichier.ecrire();
            String line2 = Files.readAllLines(new File("test").toPath()).get(1);
            assert !line.equals(line2);
            fichier.supprimer();
            fichier.fermer();
        } catch (IOException e) {
            assert false : "failed to instance Fichier";
        }
    }
    
}
