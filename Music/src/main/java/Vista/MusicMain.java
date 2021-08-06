package Vista;

import Controlador.Controller;
import Modelo.Clases.Cancion;
import java.sql.SQLException;

/**
 *
 * @author JUAN MARIÑO
 */
public class MusicMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {        
        for (Cancion value : Controller.listarCanciones()) {
            System.out.println(value);
        }
        
        //Controller.registrarCancion("La vaca lola", "Canticuentos", "Infantil");
        //Controller.actualizarCancion(6,"La vaca lola", "Canticuentos", "Ronda");
        //System.out.println(Controller.obtenerCancion(4));
        //Controller.borrarCancion(4);
        
        for (Cancion value : Controller.listarCanciones()) {
            System.out.println(value);
        }
    }
    
}
