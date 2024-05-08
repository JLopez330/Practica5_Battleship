import java.util.ArrayList;

public class Tablero {
    private char[][] coordenadasGrid;
    private ArrayList<Barco> barcos;

    public Tablero(){
        coordenadasGrid = new char[10][10];
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10; j++) {
                coordenadasGrid[i][j] = '#';
            }
        }
    }

    public void mostrarTablero(){
        System.out.println("Tablero");
        // Imprimir los números superiores
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Imprimir el tablero con letras a-j en el lado izquierdo
        char letra = 'a';
        for (int i = 1; i <= 10; i++) {
            System.out.print(letra + " ");  // Imprimir la letra en el lado izquierdo
            for (int j = 1; j <= 10; j++) {
                System.out.print(devolverContenido(i,j)+" ");  // Imprimir el número de columna
            }
            System.out.println();
            letra++; // Incrementar la letra
        }

    }

    /**
     * Valida si el barco se saldrá del tamaño adecuado del grid
     */
    public boolean validarColocarEnGrid(int cordX, int cordY, int tamaño, char orientar){
        boolean sePuede = true;
        if(tamaño >= 2 && cordX==10 && orientar == 'H'){
            sePuede = false;
        } else if (tamaño >=2 && cordY==10 && orientar == 'V') {
            sePuede = false;
        }

        return sePuede;
    }

    public void recibirBarco(Barco auxiliar){
        barcos.add(auxiliar);
    }

    public char devolverContenido(int coordenadaX, int coordenadaY){
        return coordenadasGrid[coordenadaX-1][coordenadaY-1];
    }

    public void modificarContenido(){
        System.out.println(barcos.size());
        for(int i=1;i<=5;i++){
            for (int j=1;j<=barcos.get(i).getTamano();j++){
                if(barcos.get(i).getOrientacion()=='H'){
                    coordenadasGrid[barcos.get(i).getCordX()+j-1][barcos.get(i).getCordY()] = 'o';
                }else if(barcos.get(i).getOrientacion()=='V'){
                    coordenadasGrid[barcos.get(i).getCordX()][barcos.get(i).getCordY()+j-1] = 'o';
                }
            }
        }
    }
}