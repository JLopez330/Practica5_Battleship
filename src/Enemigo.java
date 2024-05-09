import java.util.ArrayList;
import java.util.Random;

public class Enemigo {
    private ArrayList<Barco> barcosEnemigo;
    private Tablero tablero;

    public Enemigo(){
        barcosEnemigo = new ArrayList<>();
        tablero = new Tablero();
    }

    public void crearBarcosATablero(){
        Random random = new Random();
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
                    cordX = random.nextInt(10);
                } while (cordX < 1 || cordX > 10);
                do {
                    cordY = random.nextInt(10);
                } while(cordY < 1 || cordY > 10);
                orientacion='H';
                if(tablero.validarColocarEnGrid(cordX,cordY,tamaño,orientacion)){
                    if(i==0){
                        aux = new Barco(tamaño,cordX,cordY,orientacion);
                        barcosEnemigo.add(aux);
                        colocable=true;
                        System.out.println("Barco de Tamaño "+tamaño+" colocado en: ");
                        System.out.println("("+cordX+","+cordYLetra+") posición: "+orientacion);
                    }else{
                        aux = new Barco(tamaño,cordX,cordY,orientacion);
                        colocable=verificarEspacioDeBarco(aux);
                        if(!colocable){
                            barcosEnemigo.add(aux);
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
        tablero.modificarContenido();
    }

    public boolean verificarEspacioDeBarco(Barco barcoAux){
        boolean seChocan = true;
        ArrayList<Espacio>auxUbucar = barcoAux.getUbicaciones();
        for (Barco barco: barcosEnemigo) {
            if(seChocan){
                seChocan = barco.compararUbicacionesConOtroBarco(auxUbucar);
            }
        }
        return seChocan;
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

}
