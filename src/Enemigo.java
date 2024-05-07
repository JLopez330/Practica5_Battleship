import java.util.ArrayList;

public class Enemigo {
    private ArrayList<Barco> barcos;
    private Tablero tablero;

    public Enemigo(){
        barcos = new ArrayList<>();
        tablero = new Tablero();
    }

    public void añadirBarco(int tamano,int cordX, int cordY, char orientacion){
        barcos.add(new Barco(tamano,cordX,cordY,orientacion));
    }

    public void mostrarElTablero(){
        tablero.mostrarTablero();
    }


}
