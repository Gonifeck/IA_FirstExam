package mundo_virtual;

import java.util.ArrayList;

public class BusquedaAnchura implements Constantes{
    
    public ArrayList<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Estado> sucesores;
    public ArrayList<Character> pasos;
    public int index_pasos;
    public Estado inicial;
    public Estado objetivo;
    public Estado actual;
    public boolean exito;
    public Corredor entidad;
    
    public BusquedaAnchura(Corredor e) {
        entidad=e;
        colaEstados=new ArrayList<>();
        historial=new ArrayList<>();
        sucesores=new ArrayList<>();
        pasos=new ArrayList<>();
        index_pasos=0;
        exito=false;
        
    }
    
    public void buscar(int x_origen,int y_origen,
                       int x_destino,int y_destino) {
        //resetear();
        
        inicial=new Estado(x_origen,y_origen,'N',null);
        objetivo=new Estado(x_destino,y_destino,'N',null);
        
        colaEstados.add(inicial);
        
        if ( inicial.equals(objetivo)) System.out.println("origen igual a destino");
        
        while ( !colaEstados.isEmpty() && !exito){
            
            actual=colaEstados.get(0);
            colaEstados.remove(0);
            sucesores.clear();
            procesarEstado(actual);
           
        }
     
    }
    
    public void procesarEstado(Estado e) {
       
       calcularSucesores(e);
       
       for ( int i=0 ; i < sucesores.size() ; i++){
          
          if ( !historial.contains(sucesores.get(i))) {
           
             historial.add(sucesores.get(i));
             colaEstados.add(sucesores.get(i));
                   
             if ( objetivo.equals(sucesores.get(i))) {      
                objetivo.predecesor=sucesores.get(i).predecesor;
                objetivo.oper=sucesores.get(i).oper;
                calcularSolucion();
                exito=true;
                        
             }
               
           }
                        
                    
        }   
 
        sucesores.clear();
       
        
    }
    
    public void calcularSucesores(Estado e) {
        if (e.y < NUMERO_CELDAS_ANCHO-1 && entidad.escenario.celdas[e.x][e.y+1].tipo!=PARED) {
            sucesores.add(new Estado(e.x,e.y+1,'R',e));
            return;
        }
        
        if (e.y < NUMERO_CELDAS_ANCHO-2 && entidad.escenario.celdas[e.x][e.y+2].tipo!=PARED) {
            sucesores.add(new Estado(e.x,e.y+2,'J',e));
            return;
        }
        
        if (e.y < NUMERO_CELDAS_ANCHO-3 && entidad.escenario.celdas[e.x][e.y+2].tipo==PARED && entidad.escenario.celdas[e.x][e.y+3].tipo!=PARED) {
            sucesores.add(new Estado(e.x,e.y+3,'L',e));
            return;
        }
        return;
    }
    
    public void calcularSolucion() {
        
        ArrayList<Estado> solucion=new ArrayList<>();
        solucion.add(objetivo);
        Estado predecesor=objetivo.predecesor;
        
        while ( predecesor != null){
            
            solucion.add(predecesor);  
            predecesor=predecesor.predecesor;
            
        }
        //System.out.print(" Solucion -> \n ");
        for ( int i=solucion.size()-1 ; i >= 0 ; i --) {
           //System.out.println(solucion.get(i).oper); 
           pasos.add(solucion.get(i).oper);           
        }
        objetivo.predecesor=null;
    }
    
 
}