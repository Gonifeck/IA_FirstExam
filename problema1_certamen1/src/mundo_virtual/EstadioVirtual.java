package mundo_virtual;

import mundo_virtual.Pista;
import mundo_virtual.Corredor;
import mundo_virtual.Constantes;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class EstadioVirtual extends Canvas implements Constantes{
    
    //para pintar el lienzo
    public Pista escenario;
    public Corredor personaje_principal;
    public Timer lanzadorEntidadesAutonomas;
    
    public EstadioVirtual(){
        
        escenario=new Pista(this);
        personaje_principal=new Corredor("PP",0,0,ENTIDAD,COLOR_JUGADOR,escenario);
        
        //color de fondo
        this.setBackground(COLOR_CAMINO);
        this.setFocusable(true);

        
        //añadimos el escuchador
        addMouseListener(new MouseAdapter() {
           @Override
       	   public void mouseClicked(MouseEvent evt) {
       	      activarCelda(evt);	
              repaint();
           }
        });
        
        //escuchador eventos de teclado
        addKeyListener(new java.awt.event.KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent evt) {
              realizar_movimiento(evt);
              repaint();
           }
        });
        
    }
    
    private void activarCelda(MouseEvent evt) { 
      for(int i=0; i < NUMERO_CELDAS_LARGO; i++) {
         for ( int j=0 ; j < NUMERO_CELDAS_ANCHO; j++) {
            if ( escenario.celdas[i][j].comprobarSiCeldaSeleccionada(evt.getX(),
                                                                evt.getY())){
                
                escenario.celdas[i][j].tipo=PARED;
                //System.out.println("("+i+","+j+")="+escenario.celdas[i][j].tipo);
            }
            
         }
      }
    }
    
    
    @Override
    public void paint(Graphics g) {
       //escenario.paintComponent(g); 
       //personaje_principal.paintComponent(g);
       
       update(g);
    }
    
    public void realizar_movimiento(KeyEvent evento) {
        switch( evento.getKeyCode() ) {
           
            case KeyEvent.VK_RIGHT:
                System.out.println("Se ha pulsado la tecla RIGHT");
             
                personaje_principal.mover_Derecha();
            
             
            break;
          
            case KeyEvent.VK_J:
                System.out.println("Se ha pulsado la tecla JUMP");
             
                personaje_principal.mover_SaltoSimple();
            
             
            break;
            
            case KeyEvent.VK_L:
                System.out.println("Se ha pulsado la tecla LONGJUMP");
             
                personaje_principal.mover_SaltoDoble();
            
             
            break;
      
       }
        
    }
    
    
    
    @Override
    public void update(Graphics g) {
       escenario.paintComponent(g); 
       personaje_principal.paintComponent(g);
        
    }
      
}
