import java.util.ArrayList;

public class Jugador {

    private ArrayList<Barco> barcos;


    public Jugador(){
        barcos = new ArrayList<>();
    }

    public void añadirBarco(int tamano,char cordX, char cordY, char orientacion){
        barcos.add(new Barco(tamano,cordX,cordY,orientacion));
    }
}
