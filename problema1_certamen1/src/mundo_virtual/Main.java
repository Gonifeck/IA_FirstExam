/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo_virtual;
import javax.swing.JFrame;
/**
 *
 * @author Gonifeck
 */


public class Main {
    
    public static void main (String[]args) {
        
        VentanaPrincipal vp=new VentanaPrincipal();
        vp.setVisible(true);
        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("RIGHT para un salto normal");
        System.out.println("J para un salto normal");
        System.out.println("L para un salto doble");
       
        
    }
    
}
