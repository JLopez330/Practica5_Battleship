import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Enemigo {
    private ArrayList<Barco> barcosEnemigo;
    private Tablero tablero;

    public Enemigo(){
        barcosEnemigo = new ArrayList<>();
        tablero = new Tablero();
    }

    public void crearBarcosATablero() {
        int cordX = 0;
        int cordY = 0;
        int desicion;
        char orientacion='X';
        Random random = new Random();
        int tamaño = 2;
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                tamaño = 3;
            }
            boolean colocado = false;
            do {
                desicion =random.nextInt(2);
                if(desicion==0){
                    orientacion='H';
                }else{
                    orientacion='V';
                }
                if(orientacion=='H'){
                    cordX = random.nextInt(10-tamaño)+1;
                    cordY = random.nextInt(10)+1;
                }else{
                    cordX = random.nextInt(10)+1;
                    cordY = random.nextInt(10-tamaño)+1;
                }
                if (tablero.validarColocarEnGrid(cordX, cordY, tamaño, orientacion)) {
                    Barco nuevoBarco = new Barco(tamaño, cordX, cordY, orientacion);
                    if (!verificarEspacioDeBarco(nuevoBarco)) {
                        barcosEnemigo.add(nuevoBarco);
                        colocado = true;
                    }
                }
            } while (!colocado);
            tamaño++;
        }

        mandarBarcosATablero();
        tablero.crearContenido();
    }

    // Método para verificar si hay superposición con otros barcos
    public boolean verificarEspacioDeBarco(Barco barcoAux) {
        for (Barco barco : barcosEnemigo) {
            if (barco.compararUbicacionesConOtroBarco(barcoAux.getUbicaciones())) {
                return true;
            }
        }
        return false;
    }

    public void mandarBarcosATablero(){
        for(Barco barco:barcosEnemigo){
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
        tablero.modificarTablero(cordX-1,cordY-1);
    }
}
