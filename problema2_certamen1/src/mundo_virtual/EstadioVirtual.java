package mundo_virtual;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Timer;
import javax.swing.JOptionPane;

public class EstadioVirtual extends Canvas implements Constantes{
    
    //para pintar el lienzo
    public Pista escenario;
    public Corredor corredor1;
    public Corredor corredor2;
    public Corredor corredor3;
    public Timer lanzadorEntidadesAutonomas;
    public Integer posicion_del_ganador=1;
    
    public EstadioVirtual(){
        
        escenario=new Pista(this);
        corredor1=new Corredor("C1",0,0,ENTIDAD,COLOR_CORREDOR1,escenario);
        corredor2=new Corredor("C2",0,1,ENTIDAD,COLOR_CORREDOR2,escenario);
        corredor3=new Corredor("C3",0,2,ENTIDAD,COLOR_CORREDOR3,escenario);
        
        //color de fondo
        this.setBackground(COLOR_CAMINO);
        this.setFocusable(true);
        
        lanzadorEntidadesAutonomas=new Timer();
        lanzadorEntidadesAutonomas.
                scheduleAtFixedRate(corredor1.inteligencia,0,(int)(Math.random()*50 + 400));
        lanzadorEntidadesAutonomas.
                scheduleAtFixedRate(corredor2.inteligencia,0,(int)(Math.random()*50 + 400));
        lanzadorEntidadesAutonomas.
                scheduleAtFixedRate(corredor3.inteligencia,0,(int)(Math.random()*50 + 400));
       
        
    }

    
    
    @Override
    public void paint(Graphics g) {
       //escenario.paintComponent(g); 
       //personaje_principal.paintComponent(g);
       
       update(g);
    }
    
    @Override
    public void update(Graphics g) {
        escenario.paintComponent(g); 
        corredor1.paintComponent(g);
        corredor2.paintComponent(g);
        corredor3.paintComponent(g);
        
    }
    
    public void ganadorMundoVirtual(int ganador){
        switch (ganador) {
            case 9:
                JOptionPane.showMessageDialog(null,"El azul a llegado " + posicion_del_ganador);
                posicion_del_ganador++;
                break;
            case 11:
                JOptionPane.showMessageDialog(null,"El rojo a llegado " + posicion_del_ganador);
                posicion_del_ganador++;
                break;
            case 10:
                JOptionPane.showMessageDialog(null,"El verde a llegado " + posicion_del_ganador);
                posicion_del_ganador++;
                break;
        
        }
      
    }
}