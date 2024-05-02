public class Tablero {
    private char[][] coordenadasGrid;
    private Barco[] barcos;

    public Tablero(){
        coordenadasGrid = new char[10][10];
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10; j++) {
                coordenadasGrid[i][j] = '#';
            }
        }
    }

    public char devolverContenido(int coordenadaX, int coordenadaY){
        return coordenadasGrid[coordenadaX-1][coordenadaY-1];
    }
}