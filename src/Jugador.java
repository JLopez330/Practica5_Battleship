import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jugador {

    private ArrayList<Barco> barcosJugador;
    private Tablero tablero;

    private int direccionImpacto = 0;
    private int cordXFijada = 0;
    private int cordYFijada = 0;

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
                do {
                    System.out.println("Ingresa la coordenada en Y (A a J): ");
                    cordYLetra = Character.toLowerCase(sc.next().charAt(0));
                    cordY = cordYLetra - 'a' + 1;
                } while(cordY < 1 || cordY > 10);
                System.out.println("Barco #"+(i+1)+" tamaño: " + tamaño);
                do {
                    System.out.println("Ingresa la coordenada en X (1 a 10): ");
                    cordX = sc.nextInt();
                } while (cordX < 1 || cordX > 10);

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

    public void recibirGolpe(){
        int cordX=0;
        int cordY=0;
        Random aleatorio = new Random();
        boolean espacioValido = false;

        do{
            switch (direccionImpacto){
                case 0:
                    cordX=aleatorio.nextInt(10)+1;
                    cordY=aleatorio.nextInt(10)+1;
                    if(tablero.devolverContenido(cordX,cordY)=='#' || tablero.devolverContenido(cordX,cordY)=='o'){
                        tablero.modificarTablero(cordY,cordX);
                        espacioValido=true;
                    }
                    if(tablero.devolverContenido(cordX,cordY)=='X'){
                        direccionImpacto=aleatorio.nextInt(4)+1;
                        switch (direccionImpacto){
                                case 1: //Norte
                                cordYFijada=cordY-1;
                                cordXFijada=cordX;
                                    break;
                                case 2: //Este
                                    cordXFijada=cordX+1;
                                    cordYFijada=cordY;
                                    break;
                                case 3: //Sur
                                    cordYFijada=cordY+1;
                                    cordXFijada=cordX;
                                    break;
                                case 4: //Oeste
                                    cordXFijada=cordX-1;
                                    cordYFijada=cordY;
                                    break;
                            }
                        }
                        break;

                    case 1: //Norte
                        if(cordYFijada>=1){
                            tablero.modificarTablero(cordYFijada,cordXFijada);
                            if(tablero.devolverContenido(cordXFijada,cordYFijada)=='X'){
                                cordYFijada--;
                            } else {
                                direccionImpacto=0;
                            }
                            espacioValido=true;
                        }else{
                            direccionImpacto=0;
                        }
                        break;

                    case 2: //Este
                        if(cordYFijada<=10){
                            tablero.modificarTablero(cordYFijada,cordXFijada);
                            if(tablero.devolverContenido(cordXFijada,cordYFijada)=='X'){
                                cordXFijada++;
                            }else {
                                direccionImpacto=0;
                            }
                            espacioValido=true;
                        }else{
                            direccionImpacto=0;
                        }

                        break;

                    case 3: //Sur
                        if(cordYFijada<=10){
                            tablero.modificarTablero(cordYFijada,cordXFijada);
                            if(tablero.devolverContenido(cordXFijada,cordYFijada)=='X' && cordYFijada<10){
                                cordYFijada++;
                            }else{
                                direccionImpacto=0;
                            }
                            espacioValido=true;
                        }else{
                            direccionImpacto = 0;
                        }

                        break;

                    case 4: //Oeste
                        if(cordXFijada>=1){
                            tablero.modificarTablero(cordYFijada,cordXFijada);
                            if(tablero.devolverContenido(cordXFijada,cordYFijada)=='X' && cordXFijada>0){
                                cordXFijada--;
                            }else {
                                direccionImpacto=0;
                            }
                            espacioValido=true;
                        }else{
                            direccionImpacto=0;
                        }
                        break;



                }
            }while(!espacioValido);

    }
    public boolean comprobarSiGanoLaComputadora(){
        boolean ganador=false;
        if (!tablero.quedanBarcosVivos()){
            ganador=true;
            System.out.println("La computadora a ganado");
        }
        return ganador;
    }
}
