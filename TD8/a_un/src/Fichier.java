package tec;
import collecte.*;

import java.io.Writer;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.Object;


public class Fichier extends Collecte {
    private String filename;
    private FileWriter f;
    private PrintWriter p;

    public Fichier(String fileName) throws IOException {
        super();
        this.filename = fileName;
        f = new FileWriter(fileName);
        p = new PrintWriter(f);
        donnees = new Donnees();
    }

    public Fichier() throws IOException {
        super();
        long nb = System.nanoTime();
        this.filename = "data_collect_" + nb;
        f = new FileWriter(this.filename);
        p = new PrintWriter(f);
        donnees = new Donnees();
    }

    public void fermer() throws IOException {
        p.close();
        f.close();
    }

    public boolean supprimer() {
        File file = new File(this.filename);
        return file.delete();
    }

    public void ecrire() {
        p.println(this.toString());
        p.flush();
    }


}
