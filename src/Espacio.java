public class Espacio {
    private int cordenadaEnX;
    private int cordenadaEnY;

    private char caracterEspacio;

    public Espacio(int cordX, int cordY){
        cordenadaEnX = cordX;
        cordenadaEnY = cordY;
        caracterEspacio = '#';
    }

    //Setters y Getters


    public void setCordenadaEnX(int cordenadaEnX) {

        this.cordenadaEnX = cordenadaEnX;
    }

    public void setCordenadaEnY(int cordenadaEnY) {

        this.cordenadaEnY = cordenadaEnY;
    }

    public int getCordenadaEnX() {
        return cordenadaEnX;
    }

    public int getCordenadaEnY() {
        return cordenadaEnY;
    }

    public char getCaracterEspacio(){
        return  caracterEspacio;
    }

    public void setCaracterEspacio(char caracterEspacio) {
        this.caracterEspacio = caracterEspacio;
    }


}
