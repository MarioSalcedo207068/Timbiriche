
package Dominio;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase para representar los cuadrados dentro del proyecto Timbiriche.
 * @author Equipo 01
 */
public class Box {
    private Dot pointA;
    private Dot pointB;
    private Dot pointC;
    private Dot pointD;
    private String color;

    /**
     * Método constructor con parámetros de la clase.
     * @param pointA Primer punto que conforma al cuadrado.
     * @param pointB Segundo punto que conforma al cuadrado.
     * @param pointC Tercer punto que conforma al cuadrado.
     * @param pointD Cuarto punto que conforma al cuadrado.
     * @param color Color al cual pertenece el cuadrado.
     */
    public Box(Dot pointA, Dot pointB, Dot pointC, Dot pointD, String color) {
        
        List<Dot> dots = new ArrayList<>();
        dots.add(pointA);
        dots.add(pointB);
        dots.add(pointC);
        dots.add(pointD);
        
        Collections.sort(dots, Comparator.comparingInt(Dot::suma));
        
        this.pointA = dots.get(0);
        this.pointB = dots.get(1);
        this.pointC = dots.get(2);
        this.pointD = dots.get(3);
        
        
        this.color = color;
    }
    
    

    /**
     * Método para obtener el primer punto que conforma al cuadrado.
     * @return Objeto tipo Dot con la información del primer punto. 
     */
    public Dot getPointA() {
        return pointA;
    }

    /**
     * Método para obtener el segundo punto que conforma al cuadrado.
     * @return Objeto tipo Dot con la información del segundo punto. 
     */
    public Dot getPointB() {
        return pointB;
    }

        /**
     * Método para obtener el tercer punto que conforma al cuadrado.
     * @return Objeto tipo Dot con la información del tercer punto. 
     */
    public Dot getPointC() {
        return pointC;
    }

    /**
     * Método para obtener el cuarto punto que conforma al cuadrado.
     * @return Objeto tipo Dot con la información del cuarto punto. 
     */    
    public Dot getPointD() {
        return pointD;
    }

    /**
     * Método para obtener el color que conforma al cuadrado.
     * @return Cadena con el color.
     */
    public Color getColor() {
        return Color.decode(color);
    }

    /**
     * Método para establecer el color del cuadrado.
     * @param color Cadena con el color que tendrá el cuadrado.
     */
    public void setColor(String color) {
        this.color = color;
    }


}