package mundo_virtual;


import java.util.TimerTask;


public class Inteligencia extends TimerTask implements Constantes{
    
    public Corredor entidad;
    public BusquedaAnchura algoritmo_anchura;
    public int index_pasos;
    public Inteligencia(Corredor e,boolean anchura) {
        entidad=e;
        algoritmo_anchura=new BusquedaAnchura(e);

        algoritmo_anchura.buscar(entidad.y,entidad.x,entidad.y,9);
        
        index_pasos=1;
    }

    @Override
    public void run() {
        
        //System.out.println(algoritmo_anchura.pasos.toString());
        char mov;
        mov=algoritmo_anchura.pasos.get(index_pasos);
        ++index_pasos;
       
        switch(mov) {
            case 'R': 
               
                entidad.mover_Derecha(); 
                break;
            case 'J': 
               
                entidad.mover_SaltoSimple();
                break;
            case 'L': 
               
                entidad.mover_SaltoDoble();
                break;
        }
        
        if ( fin()) {
           actualizarMundoVirtual();
           this.cancel();
        }else {
           
           actualizarMundoVirtual();
          
        }
        
        if(algoritmo_anchura.pasos.size()==index_pasos){
            ganadorMundoVirtual();
        }
        
    }
    
    public boolean fin() {
        return entidad.escenario.darCelda(entidad.xMov,entidad.yMov).tipo==SALIDA;
    }
    
    public void actualizarMundoVirtual() {
         entidad.escenario.mundo_virtual.repaint();
    }
    
    public void ganadorMundoVirtual() {
         entidad.escenario.mundo_virtual.ganadorMundoVirtual(entidad.y);
    }
    
    
    
}
