package collecte;
import java.io.*;

public class CollecteFichier extends Collecte{
    protected String output;

    public CollecteFichier(int starting_stop) {
	super(starting_stop);
	output = "donneesCollecteFichier.txt";
    }
    protected void write_data(int stop, int on, int off) {
	FileWriter writer;
	try {
	    writer= new FileWriter(output);
	    String data = "Arrêt : "+stop+"\nDescendus : "+off+" Montés : "+on+"\n";
	    writer.write(data);
	    writer.close();
	}
	catch (IOException e) {
	    e.printStackTrace();}
    }
    
    public void print_data() {
	FileReader reader;
	try {
	    reader = new FileReader(output);
	    int i;
	    while ((i=reader.read()) != -1) 
		System.out.println((char) i); 
	    reader.close();}
	catch (IOException e) {
	    e.printStackTrace();}
    }
}
