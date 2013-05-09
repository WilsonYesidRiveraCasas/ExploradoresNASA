/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NASA;

/**
 *
 * @author WRIVER1
 */
public class Superficie {
    
    private int terreno[][];
    
    /**
     * Constructor
     * @param sizeX int tamaño en X
     * @param sizeY int tamño en Y
     */
    public Superficie(int sizeX, int sizeY){        
        //inicializo la grilla de la superficie
        this.terreno=new int[sizeX][sizeY];        
    }
    
    public int[][] getTerreno() {
        return terreno;
    }

    public void setTerreno(int[][] terreno) {
        this.terreno = terreno;
    }
    
    /**
     * Obtiene un valor de la grilla es una posicion espeficifa
     * @param x int posición X
     * @param y int posición Y
     * @return int indicando 1=está el explorador  0=no está el explorador
     */
    public int getValorPosicionTerreno(int x, int y){
        return this.terreno[x][y];
    }
    
    /**
     * Este método modifica el valor almacenado en una posicion x,y de la matriz
     * @param x int posición X
     * @param y int posición Y
     * @param valor int valor a almacenar
     */
    public void setValorPosicionTerreno(int x, int y, int valor){        
        this.terreno[x][y]=valor;        
    }
    
    public int lengthX(){
        return this.terreno[0].length;
    }
    
    public int lengthY(){
        return this.terreno.length;
    }
    
    
}
