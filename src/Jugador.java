import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

    private ArrayList<Barco> barcosJugador;
    private Tablero tablero;


    public Jugador(){
        barcosJugador = new ArrayList<>();
        tablero = new Tablero();
    }



    /**
     * El metodo que añade el barco al arrayList de barcos del jugador
     * contiene una validación para evitar que los barcos choquen en
     * el tablero o contra otros barcos.
     */
    public void crearBarcosATablero(){
        Scanner sc = new Scanner(System.in);
        int tamaño=2;
        for (int i = 0; i < 5; i++) {
            int cordX=-1;
            int cordY=-1;
            char cordYLetra='X';
            char orientacion = 'X';
            boolean colocable = false;
            if(i==2){
                tamaño=3;
            }
            Barco aux;
            do {
                System.out.println("Barco #"+(i+1)+" tamaño: " + tamaño);
                do {
                    System.out.println("Ingresa la coordenada en X (1 a 10): ");
                    cordX = sc.nextInt();
                } while (cordX < 1 || cordX > 10);
                do {
                    System.out.println("Ingresa la coordenada en Y (A a J): ");
                    cordYLetra = Character.toLowerCase(sc.next().charAt(0));
                    cordY = cordYLetra - 'a' + 1;
                } while(cordY < 1 || cordY > 10);
                do {
                    System.out.println("Ingresa la orientación del barco");
                    System.out.println("[H] Horizontal\n"+"[V] Vertical");
                    orientacion=Character.toUpperCase(sc.next().charAt(0));
                }while (orientacion!='H' && orientacion!='V');
                if(tablero.validarColocarEnGrid(cordX,cordY,tamaño,orientacion)){
                    if(i==0){
                        aux = new Barco(tamaño,cordX,cordY,orientacion);
                        barcosJugador.add(aux);
                        colocable=true;
                        System.out.println("Barco de Tamaño "+tamaño+" colocado en: ");
                        System.out.println("("+cordX+","+cordYLetra+") posición: "+orientacion);
                    }else{
                        aux = new Barco(tamaño,cordX,cordY,orientacion);
                        colocable=verificarEspacioDeBarco(aux);
                        if(!colocable){
                            barcosJugador.add(aux);
                            System.out.println("Barco de Tamaño "+tamaño+" colocado en: ");
                            System.out.println("("+cordX+","+cordYLetra+") posición: "+orientacion);
                            colocable=true;
                        }else{
                            System.out.println("Error al colocar Barco!");
                            colocable=false;
                        }
                    }

                }
            }while(!colocable);
        tamaño++;
        }
        mandarBarcosATablero();
        tablero.crearContenido();
    }

    /**
     * Este metodo recibe el barco que se desea colocar, lo pasa
     * por una comprobación y regresa si es posible colocarlo
     * o no.
     */
    public boolean verificarEspacioDeBarco(Barco barcoAux){
        boolean seChocan = true;
        ArrayList<Espacio>auxUbucar = barcoAux.getUbicaciones();
        for (Barco barco: barcosJugador) {
            if(seChocan){
                seChocan = barco.compararUbicacionesConOtroBarco(auxUbucar);
            }
        }
        return seChocan;
    }



    /**
     * Manda una copia de los barcos al tablero para poder mostrarlos
     */
    public void mandarBarcosATablero(){
        for(Barco barco:barcosJugador){
            tablero.recibirBarco(barco);
        }
    }

    /**
     * Muestra el tablero del jugador
     */
    public void mostrarElTablero(){
        tablero.mostrarTablero();
    }
    public void recivirGolpe(){
        Scanner sc = new Scanner(System.in);
        int cordX=-1;
        int cordY=-1;
        char cordYLetra='X';
        do {
            System.out.println("Ingresa la coordenada en X (1 a 10): ");
            cordX = sc.nextInt();
        } while (cordX < 1 || cordX > 10);
        do {
            System.out.println("Ingresa la coordenada en Y (A a J): ");
            cordYLetra = Character.toLowerCase(sc.next().charAt(0));
            cordY = cordYLetra - 'a' + 1;
        } while(cordY < 1 || cordY > 10);
        tablero.modificarTablero(cordY-1,cordX-1);
    }
}
