import java.util.ArrayList;
import java.util.Iterator;

public class Barco {
    private int tamano;
    private int vida;
    private ArrayList<Espacio> ubicacion;
    private boolean estaHundido;

    public Barco(int tamano,int cordX, int cordY, char orientacion){
        this.tamano = tamano;
        this.vida = this.tamano;
        estaHundido = false;
        ubicacion = new ArrayList<>();
        crearBarco(cordX,cordY,orientacion);
    }

    //Setters y getters de la clase
    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public boolean isEstaHundido() {
        return estaHundido;
    }

    public void setEstaHundido(boolean estaHundido) {
        this.estaHundido = estaHundido;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void crearBarco(int cordX, int cordY, char orientacion){
        for (int i = 0; i < tamano; i++) {
            Espacio aux = new Espacio(cordX,cordY);
            ubicacion.add(aux);
            if(orientacion == 'H' || orientacion == 'h'){
                cordX++;
            } else if (orientacion == 'V' || orientacion == 'v') {
                cordY++;
            }
        }
    }

    public String verificarGolpe(int cordX, int cordY){
        String resultado = "";
        int marcadorGolpe = 0;

        Iterator<Espacio> iterador = ubicacion.iterator();
        while(iterador.hasNext()){
            Espacio espacio = iterador.next();
            if(espacio.getCordenadaEnX()==cordX && espacio.getCordenadaEnY()==cordY){
                marcadorGolpe = 1;
                iterador.remove();
            }
        }

        if(marcadorGolpe>0){
            golpearBarco(true);
            if(!estaHundido){
                resultado = "Golpe!";
            }else{
                resultado = "Hundido!";
            }
        }
        resultado = "Agua!";

        return resultado;
    }

    public void golpearBarco(boolean fueGolpeado){
        if(fueGolpeado){
            vida--;
        }
        if(vida==0){
            estaHundido=true;
        }
    }


}
