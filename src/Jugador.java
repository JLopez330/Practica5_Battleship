import java.lang.reflect.Array;
import java.util.ArrayList;

public class Jugador {

    private ArrayList<Barco> barcos;
    private Tablero tablero;


    public Jugador(){
        barcos = new ArrayList<>();
        tablero = new Tablero();
    }


    /**
     * El metodo que añade el barco al arrayList de barcos del jugador
     * contiene una validación para evitar que los barcos choquen en
     * el tablero.
     */
    public boolean añadirBarco(int tamano,int cordX, int cordY, char orientacion){
        boolean seColoco = false;
        Barco auxiliar = new Barco(tamano,cordX,cordY,orientacion);
        if(barcos.isEmpty()){
            barcos.add(auxiliar);
            seColoco = true;
        }else if(verificarEspacioDeBarco(auxiliar)){
            barcos.add(auxiliar);
            seColoco = true;
        }
        return seColoco;
    }

    /**
     * Este metodo recibe el barco que se desea colocar, lo pasa
     * por una comprobación y regresa si es posible colocarlo
     * o no.
     */
    public boolean verificarEspacioDeBarco(Barco barcoAux){
        boolean sePuedeGuardar = false;
        ArrayList<Espacio>auxUbucar = barcoAux.getUbicaciones();
        for (Barco barco: barcos) {
            if(!sePuedeGuardar){
                sePuedeGuardar = barco.compararUbicacionesConOtroBarco(auxUbucar);
            }
        }
        return sePuedeGuardar;
    }

    public void mandarBarcosATablero(){

    }

    public void mostrarElTablero(){
        tablero.mostrarTablero();
    }
}
