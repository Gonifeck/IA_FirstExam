package mundo_virtual;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame implements Constantes{
    
    //nuestra clase se compone de un lienzo de dibujo (herada de canvas)
    public EstadioVirtual mundo_virtual;
    
    //constructor
    public VentanaPrincipal() {
        mundo_virtual=new EstadioVirtual();
        this.getContentPane().add(mundo_virtual);
        //el tamaño de la venta es la del escenario y el incremento de los bordes
        this.setSize(ANCHURA_ESCENARIO,LARGO_ESCENARIO); 
        
    }
    
}