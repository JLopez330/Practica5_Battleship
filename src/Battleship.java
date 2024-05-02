import java.util.Scanner;

public class Battleship {
    Tablero tablero = new Tablero();
    Tablero enemigo = new Tablero();
    int dificultad=0;
    public Battleship(){
        Scanner escanear = new Scanner(System.in);
        System.out.println("Bienvenido a Battleship!");
        do{
            System.out.println("Seleccione una dificultad: 0 es facil y 1 es dificil");
            dificultad=escanear.nextInt();
            if (!(dificultad==1 || dificultad==0)){
                System.out.println("Esa dificultad no esta disponible");
            }
        }while(!(dificultad==1 || dificultad==0));

    }
    public void mostrarTableroComputadora(){
        System.out.println("Tablero de la maquina");
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
                System.out.print(tablero.devolverContenido(i,j)+" ");  // Imprimir el número de columna
            }
            System.out.println();
            letra++; // Incrementar la letra
        }
    }
    public void mostrarTableroJugador(){
        System.out.println("Tablero del jugador");
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
                System.out.print(enemigo.devolverContenido(i,j)+" ");  // Imprimir el número de columna
            }
            System.out.println();
            letra++; // Incrementar la letra
        }
    }
    public void colocarBarcosJugador(){

    }
}
