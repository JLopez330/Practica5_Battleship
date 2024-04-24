public class Barco {
    private int tamano;
    private int vida;
    private boolean estaHundido;

    public Barco(int tamano){
        this.tamano = tamano;
        this.vida = this.tamano;
        estaHundido = false;
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


}
