public class Espacio {
    private int cordenadaEnX;
    private int cordenadaEnY;

    public Espacio(int cordX, int cordY){
        cordenadaEnX = cordX;
        cordenadaEnY = cordY;
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


}
