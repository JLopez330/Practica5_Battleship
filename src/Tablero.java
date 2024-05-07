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


    public void recibirBarco(Barco auxiliar){
        barcos.add(auxiliar);
    }

    public char devolverContenido(int coordenadaX, int coordenadaY){
        return coordenadasGrid[coordenadaX-1][coordenadaY-1];
    }
}