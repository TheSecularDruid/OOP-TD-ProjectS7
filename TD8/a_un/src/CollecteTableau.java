package collecte;

import java.util.ArrayList;
import java.io.IOException;
import java.lang.Object;

public class CollecteTableau extends Collecte {
    ArrayList<String> tableau;

    public CollecteTableau() {
        super();
        tableau = new ArrayList<String>();
    }

    public void ecrire() {
        tableau.add(this.toString());
    }
}
