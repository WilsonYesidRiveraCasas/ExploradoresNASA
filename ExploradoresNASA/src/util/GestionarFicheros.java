/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WRIVER1
 */
public class GestionarFicheros {
    
    
    /**
     * Este método permite leer un fichero y teronará una lista 
     * donde cada posicion representa una linea de texto del fichero
     * @param rutaArchivo String ruta del fichero a leer
     * @return List<String> Lineas de texto del fichero
     * @throws Exception En caso de que ocurra una excepción al leer se lanzará
     */
    public static List<String> leerArchivo(String rutaArchivo)throws Exception{
        
        File fichero;
        FileReader lectorArchivo;
        try{
            fichero = new File(rutaArchivo);
            lectorArchivo = new FileReader(fichero);
            BufferedReader br = new BufferedReader(lectorArchivo);
            List<String> lineas=new ArrayList<String>();
          
            while(true){
                String aux=br.readLine();
                if(aux!=null){
                    lineas.add(aux);
                }
                else{
                    break;
                }
            }
            br.close();
            lectorArchivo.close();
            
            return lineas;
            
        }catch(IOException e){
            throw new Exception("Error al Tratar de Leer El fichero. Exception: "+e.getMessage());
        }
    }
    
    
}
