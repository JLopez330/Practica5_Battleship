import java.util.Scanner;

public class Battleship {
    Jugador jugador = new Jugador();
    Enemigo computadora = new Enemigo();
    boolean finDePartida=false;
    public Battleship(){

    }

    public void iniciarJuego(){
        System.out.println("Bienvenido a Battleship!");
        System.out.println("Jugador, elija las coordenadas donde colocara sus barcos");
        jugador.crearBarcosATablero();
        computadora.crearBarcosATablero();
        System.out.println("============Tablero Jugador============");
        jugador.mostrarElTablero();
        System.out.println();
        System.out.println("============Tablero Enemigo============");
        computadora.mostrarElTablero();
        System.out.println();
        do{
            jugarTurno();
            if(jugador.comprobarSiGanoLaComputadora()){
                finDePartida=true;
            }
            if(computadora.comprobarSiGanoElJugador()){
                finDePartida=true;
            }
        }while(!finDePartida);

    }


    public void jugarTurno(){
        computadora.recibirGolpe();
        jugador.recibirGolpe();
        System.out.println("============Tablero Jugador============");
        jugador.mostrarElTablero();
        System.out.println();
        System.out.println("============Tablero Enemigo============");
        computadora.mostrarElTablero();
        System.out.println();

    }


}
