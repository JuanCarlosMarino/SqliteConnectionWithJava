/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controller;

/**
 *
 * @author JUAN MARIÑO
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        //Controller.RegistrarCancion("La diferencia", "Vicente fernandez", "Ranchera");
        //Controller.borrarCancion(1);
        //System.out.println(Controller.getProducto(2));
        System.out.println(Controller.listarCanciones());
        Controller.actualizarCancion(3, "El chofer", "Vicente Fernandez", "Ranchera");
    }
    
}
