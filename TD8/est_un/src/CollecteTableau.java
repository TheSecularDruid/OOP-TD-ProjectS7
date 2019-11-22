import java.io.*;

public class CollecteTableau extends Collecte{
    protected Vector data;
    
    protected void write_data(int stop, int on, int off) {
	data.add(stop);
	data.add(on);
	data.add(off);
    }

    public void print_data() {
	for(int i=0;i<data.size();i++) {
	    print(i);
	}
    }
}
