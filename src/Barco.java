import java.util.ArrayList;
import java.util.Iterator;

public class Barco {
    private int tamano;
    private int vida;
    private int cordX;
    private int cordY;
    private char orientacion;
    private ArrayList<Espacio> ubicacion;
    private boolean estaHundido;

    public Barco(int tamano, int cordX, int cordY, char orientacion) {
        this.tamano = tamano;
        this.vida = this.tamano;
        this.cordX = cordX;
        this.cordY = cordY;
        this.orientacion = orientacion;
        estaHundido = false;
        ubicacion = new ArrayList<>();
        crearBarco(cordX, cordY, orientacion);
    }

    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public char getOrientacion() {
        return orientacion;
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

    public ArrayList<Espacio> getUbicaciones(){
        return ubicacion;
    }

    /**
     * Crea un barco al recibir sus coordenadas como int y la orientacion en un char
     *
     */
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

    /**
     * Compara la ubicación del barco con otro que recibe, si se encuentran o no en el mismo
     * espacio regresa un boolean
     *
     */
    public boolean compararUbicacionesConOtroBarco(ArrayList<Espacio> ubicaciones){
        boolean coinciden = false;
        for (Espacio espacio:ubicacion) {
            for (Espacio auxEspacio:
                 ubicaciones) {
               if(espacio.getCordenadaEnX()==auxEspacio.getCordenadaEnX() &&
               espacio.getCordenadaEnY()== auxEspacio.getCordenadaEnY()){
                   coinciden=true;
                   break;
               }
            }
        }
        return coinciden;
    }

    /**
     * Verifica si el barco es golpeado
     *
     */
    public Boolean verificarGolpe(int cordY, int cordX){
        boolean resultado=false;
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
                resultado = true;
            }else{
                resultado = true;
                System.out.println("Barco hundido");
            }
        }
        return resultado;
    }

    /**
     * Daña al barco, si su vida es disminuida a 0, regresa un mensaje y hunde
     * el barco
     *
     */
    public void golpearBarco(boolean fueGolpeado){
        if(fueGolpeado){
            vida--;
        }
        if(vida==0){
            estaHundido=true;
        }
    }


}
