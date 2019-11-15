import java.io.*;

public abstract class Collecte{
    
    protected int current_stop;
    protected int current_getting_on;
    protected int current_jumping_off;


    public Collecte(int starting_stop) {
	current_stop = starting_stop;
	current_getting_on = 0;
	current_jumping_off = 0;
    }
    
    public void uneEntree() {
	current_getting_on++;
    }
    
    public void uneSortie() {
	current_jumping_off++;
    }

    public void changerArret() {
	write_data(current_stop, current_getting_on, current_jumping_off);
	current_getting_on = 0;
	current_jumping_off = 0;
	current_stop++;
    }

    protected abstract void write_data(int stop, int on, int off);

    public abstract void print_data();

    public String toString() {
	print("Arrêt courant : " + current_stop);
        print("Nombre de passagers étant pour l'instant montés à cet arrêt : " + current_getting_on);
        print("Nombre de passagers étant pour l'instant descendus à cet arrêt : " + current_jumping_off);
    }
}
