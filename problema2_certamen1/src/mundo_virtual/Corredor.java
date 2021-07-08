package mundo_virtual;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Corredor extends JComponent implements Constantes{
    
    public String identificador;
    public int xMov;
    public int yMov;
    public Color color;
    public char tipo;
    public Pista escenario;
    public Inteligencia inteligencia;
    public int x, y;
    
    public Corredor(String id,int x,int y,char t,Color c,Pista esc) {
        identificador=id;
        this.x=x;
        this.y=y;
        xMov=(x*PIXEL_CELDA)+10;
        yMov=(y*PIXEL_CELDA)+10;
        color=c;
        tipo=t;
        escenario=esc;
        inteligencia=new Inteligencia(this,false);
        
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(xMov,yMov,PIXEL_CELDA,PIXEL_CELDA);  
    }
         
    public void mover_Derecha(){ 
        //
        if ( xMov+PIXEL_CELDA < NUMERO_CELDAS_ANCHO*PIXEL_CELDA &&  
           escenario.darCelda(xMov+PIXEL_CELDA,
                              yMov).tipo!=PARED) {
           
           xMov+=PIXEL_CELDA; 
           y++;
        
           
        }
    
    }
    public void mover_SaltoSimple(){ 
        //
        if ( xMov+PIXEL_CELDA*2 < NUMERO_CELDAS_ANCHO*PIXEL_CELDA &&  
           escenario.darCelda(xMov+PIXEL_CELDA*2,
                              yMov).tipo!=PARED) {
           
           xMov+=(PIXEL_CELDA*2); 
           y+=2;
        
           
        }
    
    }
    
    public void mover_SaltoDoble(){ 
        //
        if ( xMov+PIXEL_CELDA*3 < NUMERO_CELDAS_ANCHO*PIXEL_CELDA &&  
           escenario.darCelda(xMov+PIXEL_CELDA*3,
                              yMov).tipo!=PARED) {
           
           xMov+=(PIXEL_CELDA*3); 
           y+=3;
        
           
        }
    
    }
    
}
