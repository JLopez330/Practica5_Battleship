import java.util.Scanner;

public class Battleship {
    Jugador jugador = new Jugador();
    Enemigo computadora = new Enemigo();
    Tablero enemigo = new Tablero();
    int dificultad=0;
    public Battleship(){

    }

    public void iniciarJuego(){
        Scanner escanear = new Scanner(System.in);
        System.out.println("Bienvenido a Battleship!");
        do{
            System.out.println("========Seleccione una dificultad========");
            System.out.println("[0] Facil\n"+"[1] Dificil");
            dificultad=escanear.nextInt();
            if (!(dificultad==1 || dificultad==0)){
                System.out.println("Esa dificultad no esta disponible");
            }
        }while(!(dificultad==1 || dificultad==0));
        jugador.crearBarcosATablero();
        computadora.crearBarcosATablero();
        jugarTurno();
    }


    public void jugarTurno(){
        System.out.println("============Tablero Jugador============");
        jugador.mostrarElTablero();
        System.out.println();
        System.out.println("============Tablero Enemigo============");
        computadora.mostrarElTablero();
        System.out.println();

    }


}
