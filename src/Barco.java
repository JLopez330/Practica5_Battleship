public class Barco {
    private int tamano;
    private int vida;
    private Espacio[] ubicacion;
    private boolean estaHundido;

    public Barco(int tamano,int cordX, int cordY, char orientacion){
        this.tamano = tamano;
        this.vida = this.tamano;
        estaHundido = false;
        ubicacion = new Espacio[this.tamano];
        darUbicacionABarco(cordX,cordY,orientacion);
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

    public void darUbicacionABarco(int cordX, int cordY, char orientacion){
        for (int i = 0; i < tamano; i++) {
            Espacio aux = new Espacio(cordX,cordY);
            ubicacion[i]=aux;
            if(orientacion == 'H' || orientacion == 'h'){
                cordX++;
            } else if (orientacion == 'V' || orientacion == 'v') {
                cordY++;
            }
        }
    }

    public void golpearBarco(boolean fueGolpeado){
        if(fueGolpeado){
            vida--;
        }
        if(vida==0){
            estaHundido=true;
        }
    }
    public char estadoDeLaPiezaDelBarco(){
        char estado;

        return estado;
    }


}
