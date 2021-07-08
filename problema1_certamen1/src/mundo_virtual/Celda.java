package mundo_virtual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class Celda extends JComponent implements Constantes {
    
    public int x;
    public int y;
    public char tipo;
    public Rectangle rectanguloCelda;
    //constructor
    public Celda(int x,int y,char t) {
        this.x=x;
        this.y=y;
        tipo=t;
        rectanguloCelda=new Rectangle(x,y,PIXEL_CELDA,PIXEL_CELDA);
    }
    
    //metodo para dibujar una casilla
    @Override
    public void paintComponent(Graphics g) {
        
        switch ( tipo ) {
            case PARED:
               g.setColor(COLOR_PARED);
            break;
            case SALIDA:
               g.setColor(COLOR_SALIDA);
            break;
            case CAMINO:
               g.setColor(COLOR_CAMINO);  
            break;  
            case EXPLORADO:
               g.setColor(COLOR_EXPLORADO);  
            break;
            case SOLUCION:
               g.setColor(COLOR_SOLUCION);  
            break;
            
        } 
        g.fillRect(x, y,PIXEL_CELDA,PIXEL_CELDA);
        g.setColor(Color.BLACK);
        g.drawRect(x, y,PIXEL_CELDA,PIXEL_CELDA);
    }
    
    //si el click esta sobre la celda
    public boolean comprobarSiCeldaSeleccionada(int clickX,int clickY) {
       boolean click=false;
       if ( rectanguloCelda.contains(new Point(clickX,clickY)) ) {
           click=true;
       } 
       return click;
       
    }
   
}
