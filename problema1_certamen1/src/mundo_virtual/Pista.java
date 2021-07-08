package mundo_virtual;

import java.awt.Graphics;
import javax.swing.JComponent;

public class Pista extends JComponent implements Constantes {
    
    public Celda[][] celdas;
    public EstadioVirtual mundo_virtual;
    
    public Pista(EstadioVirtual mv) {
        
       mundo_virtual=mv;
       celdas=new Celda[NUMERO_CELDAS_LARGO][NUMERO_CELDAS_ANCHO];
       //inicializar el array de celdas
       for(int i=0; i < NUMERO_CELDAS_LARGO; i++)
          for ( int j=0 ; j <  NUMERO_CELDAS_ANCHO; j++) 
             celdas[i][j]=new Celda(j*PIXEL_CELDA+10,i*PIXEL_CELDA+10,CAMINO);
    
    for(int i=0; i < NUMERO_CELDAS_LARGO; i++){
       celdas[i][2].tipo=PARED;
       celdas[i][5].tipo=PARED;
       celdas[i][6].tipo=PARED;
       celdas[i][8].tipo=PARED;
       celdas[i][9].tipo=SALIDA;
    }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        for(int i=0; i < NUMERO_CELDAS_LARGO ; i++) 
            for ( int j=0 ; j < NUMERO_CELDAS_ANCHO; j++) 
              celdas[i][j].paintComponent(g);
        
        
    }
    
    public Celda darCelda(int pixelX, int pixelY) {
        Celda resultado=null;
        for(int i=0; i < NUMERO_CELDAS_LARGO ; i++) 
            for ( int j=0 ; j < NUMERO_CELDAS_ANCHO; j++) 
                if ( celdas[i][j].x==pixelX && celdas[i][j].y==pixelY)
                    resultado=celdas[i][j];
        return resultado;
        
    }
}
