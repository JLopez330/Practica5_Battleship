public class Espacio {
    private char cordenadaEnX;
    private char cordenadaEnY;

    public Espacio(char cordX, char cordY){
        cordenadaEnX = cordX;
        cordenadaEnY = cordY;
    }

    //Setters y Getters


    public void setCordenadaEnX(char cordenadaEnX) {

        this.cordenadaEnX = cordenadaEnX;
    }

    public void setCordenadaEnY(char cordenadaEnY) {

        this.cordenadaEnY = cordenadaEnY;
    }

    public char getCordenadaEnX() {
        return cordenadaEnX;
    }

    public char getCordenadaEnY() {
        return cordenadaEnY;
    }


}
