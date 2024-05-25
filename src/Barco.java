import java.util.ArrayList;


public class Barco {
    private int tamano;
    private int cordX;
    private int cordY;
    private char orientacion;
    private ArrayList<Espacio> ubicacion;

    public Barco(int tamano, int cordX, int cordY, char orientacion) {
        this.tamano = tamano;
        this.cordX = cordX;
        this.cordY = cordY;
        this.orientacion = orientacion;
        ubicacion = new ArrayList<>();
        crearBarco(cordX, cordY, orientacion);
    }

    //Setters y getters de la clase
    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public char getOrientacion() {
        return orientacion;
    }

    public int getTamano() {
        return tamano;
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


}
