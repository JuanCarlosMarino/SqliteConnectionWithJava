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
        //Controller.registrarCancion("El Condor Herido", "Diomedez Diaz", "Vallenato");
        //Controller.borrarCancion(5);
        for (Cancion value : Controller.listarCanciones()) {
            System.out.println(value);
        }
        //System.out.println(Controller.obtenerCancion(4));
        //Controller.actualizarCancion(4, "El Poblado", "Crissin", "Reggaeton");
    }
    
}
