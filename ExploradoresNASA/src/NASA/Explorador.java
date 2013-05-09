/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NASA;

/**
 *
 * @author WRIVER1
 */
public class Explorador {

    /**Coordenada respecto a X*/
    private int x;
    /**Coordenada respecto a Y*/
    private int y;
    /**Letra que indica la orientación. Está dada por N=norte, S= sur, O=oeste, E=este*/
    private char orientacion;

    /**
     * Constructor de un Explorador
     * @param x int Coordenada de X
     * @param y int Coordenada de Y
     * @param orientacion char orientación en cardinalidad
     */
    public Explorador(int x, int y, char orientacion) {
        this.x = x;
        this.y = y;
        this.orientacion = orientacion;
    }

    
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the orientacion
     */
    public char getOrientacion() {
        return orientacion;
    }

    /**
     * @param orientacion the orientacion to set
     */
    public void setOrientacion(char orientacion) {
        this.orientacion = orientacion;
    }
    
    /**
     * Este método imprime la posicion y orientación en un determinado mimento
     * @return String poscion y orientación
     */
    public String getPosicion(){
        return this.getX()+" "+this.getY()+" "+this.getOrientacion();
    }
    
    /**
     * Este método gira 90 grados a la izquierda respecto a la orientación actual, 
     * sin moverse de la posición (x,y)
     */
    public void movimientoI(){
        
        switch(this.orientacion){
            case 'N': this.setOrientacion('O');break;
            case 'O': this.setOrientacion('S');break;
            case 'S': this.setOrientacion('E');break;
            case 'E': this.setOrientacion('N');break;
        }
    }
    
    /**
     * Este método gira 90 grados a la derecha respecto a la orientación actual,
     * sin moverse de la posición (x,y)
     */
    public void movimientoD(){
        switch(this.orientacion){
            case 'N': this.setOrientacion('E');break;
            case 'E': this.setOrientacion('S');break;
            case 'S': this.setOrientacion('O');break;
            case 'O': this.setOrientacion('N');break;
        }
    }    
    
}//end class
