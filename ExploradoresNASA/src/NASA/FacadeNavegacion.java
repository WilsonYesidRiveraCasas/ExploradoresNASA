/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NASA;

/**
 *
 * @author WRIVER1
 */
public class FacadeNavegacion {
    
    
    public static String iniciarNavegacion(String rutaArchivo){
        return new ControlNavegacion().procesarExploracion(rutaArchivo);
    }
    
}
