import java.util.Scanner;

public class Battleship {
    Tablero tablero = new Tablero();
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
        jugarTurno();
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
    public void colocarBarcosJugador() {
        int coordenadaX;
        int coordenadaY;
        char orientacion;
        char coordenadaYLetra;
        int tamaño=2;
        boolean lugarValido=false;
        boolean repetirTercerBarco=true;
        Scanner aux = new Scanner(System.in);
        do {
            do {
                lugarValido=false;
                do {
                    System.out.println("Ingrese la letra de la columna (a-j):");
                    coordenadaYLetra = Character.toLowerCase(aux.next().charAt(0));
                    coordenadaY = coordenadaYLetra - 'a' + 1;
                } while (!(coordenadaY >= 1 && coordenadaY <= 10));
                do {
                    System.out.println("Ingrese el número de la fila");
                    coordenadaX = aux.nextInt();
                } while (!((coordenadaX > 0 && coordenadaX <= 10)));
                do {
                    System.out.println("Ingrese V para vertical o H para horizontal:");
                    orientacion = Character.toUpperCase(aux.next().charAt(0));
                } while (!(orientacion == 'V' || orientacion == 'H'));
                System.out.println("Posición seleccionada: " + coordenadaYLetra + coordenadaX + orientacion);
                System.out.println("La letra: " + coordenadaYLetra + " Equivale a: " + coordenadaY);
                if (orientacion == 'V' && coordenadaY + tamaño <= 10) {
                    jugador.añadirBarco(tamaño, coordenadaX, coordenadaY, orientacion);
                    lugarValido=true;
                } else if (orientacion == 'H' && coordenadaX + tamaño <= 10) {
                    jugador.añadirBarco(tamaño, coordenadaX, coordenadaY, orientacion);
                    lugarValido=true;
                }
                if (tamaño == 3 && repetirTercerBarco) {
                    tamaño--;
                    repetirTercerBarco = false;
                }
                tamaño++;
            }while(!lugarValido);
            System.out.println("Se creo un barco de tamaño: "+tamaño);
        }while(tamaño<5);
    }

    public void jugarTurno(){
        System.out.println("============Tablero Jugador============");
        jugador.mostrarElTablero();
        System.out.println();
        System.out.println("============Tablero Enemigo============");
        computadora.mostrarElTablero();
        System.out.println();

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
}
