/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NASA;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.GestionarFicheros;

/**
 *
 * @author WRIVER1
 */
public class ControlNavegacion {
    
   
    private Superficie superficieMarte;
    
    
    public ControlNavegacion(){
  
    }
    
    
    
    /**
     * Este método permite procesar la entrada de datos para la ejecución de la exploración
     * @param rutaArchivo String ruta del archivo
     */
    public String procesarExploracion(String rutaArchivo){
        
        String resultadoProcesoExploracion="";
        try{
            List<String>lineas=GestionarFicheros.leerArchivo(rutaArchivo);
            
            if(!lineas.isEmpty()){
                
                String coordenadaSuperior=lineas.get(0);                
                this.evaluarProcesarCoordenadaSuperior(coordenadaSuperior);
                
                int i=1;
                while(i<lineas.size()){
                    
                    String posicionInicial=lineas.get(i++);
                    try{
                        Explorador exp=this.evaluarProcesarPosicionInicial(posicionInicial);
                        char[] datosNavegacion=this.evaluarProcesarDatosNavegacion(lineas.get(i++));
                        resultadoProcesoExploracion+=this.ejecutarExploracion(exp, datosNavegacion)+"\n";
                    }catch(Exception e){
                        resultadoProcesoExploracion+=e.getMessage()+"\n\n";
                    }                                            
                }//end while
                
            }else{
                resultadoProcesoExploracion="El contenido del Archivo es vacío";
            }                      
            
        }catch(Exception e){
            resultadoProcesoExploracion+= e.getMessage();
        }   
        
        return resultadoProcesoExploracion;
        
    }//end method procesarEntrada
    
    /**
     * Este método permite verificar una cadena respecto a una expresión regular
     * @param expresion String expresion regular a evaluar
     * @param cadena String cadena a evaluar
     * @return 
     */
    private boolean validarExpresionRegular(String expresion, String cadena){
        
        boolean evaluacion=false;
        Matcher matcher = Pattern.compile(expresion).matcher(cadena);
        
        if(matcher.find()) {
            evaluacion=true;
        }
        
        return evaluacion;
        
    }//end method validarExpresionRegular
        
    /**
     * Este método tendrá la funcionalidad de evaluar y procesar la coordenada superior derecha
     * @param valorCoordenada String valor de la línea
     * @Exception si se detecta invalidez se lanza una excepción
     */
    private void evaluarProcesarCoordenadaSuperior(String valorCoordenada)throws Exception{
        //verifico la validez de la primera línea
        if(this.validarExpresionRegular("^\\d+\\ \\d+$", valorCoordenada)){

            String []coordenadas=valorCoordenada.split(" ");
            int x=Integer.parseInt(coordenadas[0])+1;
            int y=Integer.parseInt(coordenadas[1])+1;
            //configuramos las superficie del terreno con su coordenada superior
            this.superficieMarte=new Superficie(x,y);

        }else{
            throw new Exception("El valor de la Coordenada Superior no es válido. Por Ejemplo: 4 8 número espacio número");
        }
    }//end method evaluarProcesarCoordenadaSuperior
    
    /**
     * Este método permite evaluar el valor que corresponde a la posición inicial. Si es válida crea un Objeto Explorador y lo agrega en la lista
     * @param valorPosicionInicial String contiene el valor de la posició inicial
     * @return Explorador Objeto creado a partir de la posicion inicial
     * @throws Exception En caso de ser inválido se emite una excepción
     */
    private Explorador evaluarProcesarPosicionInicial(String valorPosicionInicial)throws Exception{
        
        //verificar la validez de la Posicion Inicial
        if(this.validarExpresionRegular("^\\d+\\ \\d+\\ [/N/O/E/S]$", valorPosicionInicial)){
            String []posicion=valorPosicionInicial.split(" ");
            int pX=Integer.parseInt(posicion[0]);
            int pY=Integer.parseInt(posicion[1]);
            char pOrientacion=posicion[2].charAt(0);
            return new Explorador(pX,pY,pOrientacion);
        }else{
            throw new Exception("Valor de Posicion Inicial No Válido. Debe ser Número Espacio Número [N,O,E,S]");
        }
    }//end method evaluarProcesarPosicionInicial
    
    /**
     * Este método evalua los datos de navegación para un Explorador
     * @param navegacion String movimientos expresados en I D A
     * @return char[] con los caracteres de movimiento
     * @throws Exception si es invalido se lanza una excepcion
     */
    private char[] evaluarProcesarDatosNavegacion(String navegacion)throws Exception{
        //verificar la validez de los datos de navegación
        if(this.validarExpresionRegular("^[/I/D/A]+$", navegacion)){
            return navegacion.toCharArray();
        }else{
            throw new Exception("El valor de los Datos de Exploración no son Válidos. Los valores deben ser I D A");
        }
    }//end method evaluarProcesarDatosNavegacion
    
    /**
     * Este método ejecuta la exploración basada en a cadena de datos de navegación
     * @param exp Explorador Objeto a quien se le ejecutarán los movimientos
     * @param movimientos char[] los movimientos para el explorador
     * @return String de la posición y orientación final
     */
    private String ejecutarExploracion(Explorador exp, char[]movimientos){
        
        for(char movimiento:movimientos){
            switch(movimiento){
                case 'I':exp.movimientoI();break;
                case 'D':exp.movimientoD();break;
                case 'A':exp=this.movimientoA(exp);break;
            }
        }//end for
        return exp.getPosicion();
    }//end method ejecutarExploracion
    
    /**
     * Este método se mueve una posicó hacia adelante respecto a su orientación actual
     */
    private Explorador movimientoA(Explorador exp){
        
        switch(exp.getOrientacion()){
            case 'N': {
                        if(exp.getY()+1<=this.superficieMarte.lengthY()-1){
                            exp.setY(exp.getY()+1);
                        }
                        break;
                      }
                
            case 'O': {
                        if(exp.getX()-1>=0){
                            exp.setX(exp.getX()-1);
                        }
                        break;
                      }
            case 'S': {
                        if(exp.getY()-1>=0){
                            exp.setY(exp.getY()-1);
                        }
                        break;
                      }
            case 'E': {
                        if(exp.getX()+1<=this.superficieMarte.lengthX()-1){
                            exp.setX(exp.getX()+1);
                        }
                        break;
                      }
        }//end switch
        
        return exp;
        
    }//end method movimientoA
    
}//end class
