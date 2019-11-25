package collecte;
import java.io.*;
import java.util.*; 

public class CollecteTableau extends Collecte{
    protected ArrayList data;
    
    public CollecteTableau(int starting_stop) {
	super(starting_stop);
    }
    
    protected void write_data(int stop, int on, int off) {
	data.add(stop);
	data.add(on);
	data.add(off);
    }

    public void print_data() {
	for(int i=0;i<data.size();i++) {
	    System.out.println(i);
	}
    }
}
