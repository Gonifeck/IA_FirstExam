package mundo_virtual;

import java.awt.Color;
import java.util.Random;

public interface Constantes {
    public final int PIXEL_CELDA=32;
    //number of cells - width
    public final int NUMERO_CELDAS_ANCHO=10;
    //number of cells - height
    public final int NUMERO_CELDAS_LARGO=3;
    //size of the stage
    public final int ANCHO_BORDE_VENTANA=40;
    public final int LARGO_BORDE_VENTANA=60;
    
    public final int ANCHURA_ESCENARIO=(PIXEL_CELDA*NUMERO_CELDAS_ANCHO)+ANCHO_BORDE_VENTANA;
    public final int LARGO_ESCENARIO=(PIXEL_CELDA*NUMERO_CELDAS_LARGO)+LARGO_BORDE_VENTANA;
    //nuevas constantes para funcionalidad interaccion
    public final char ENTIDAD='E';
    public final char PARED='P';
    public final char SALIDA='S';
    public final char CAMINO='V';
    public final char EXPLORADO='X';
    public final char SOLUCION='G';
    public final Color COLOR_CAMINO=Color.ORANGE;
    public final Color COLOR_CORREDOR1=Color.BLUE;
    public final Color COLOR_CORREDOR2=Color.GREEN;
    public final Color COLOR_CORREDOR3=Color.RED;
    public final Color COLOR_PARED=Color.BLACK;
    public final Color COLOR_SALIDA=Color.MAGENTA;
    
    //funcion para generar un aleatorio
    default int numeroAleatorio(int minimo, int maximo) {
       Random random = new Random();
       int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
       return numero_aleatorio;
    }
}

