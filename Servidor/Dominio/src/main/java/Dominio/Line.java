
package Dominio;

import com.google.gson.annotations.SerializedName;
import java.awt.Color;
import java.util.Objects;


/**
 * Clase para representar la línea dentro del proyecto Timbiriche.
 * @author Equipo 01
 */
public class Line {
    @SerializedName("start")
    private Dot start;
    @SerializedName("end")
    private Dot end;
    //@SerializedName("color")
    private String color;

    /**
     * Método constructor base de la clase.
     */    
    public Line() {
    }

    /**
     * Método constructor con parámetros de la clase. 
     * @param start Objeto Dot con los datos del punto inicial.
     * @param end Objeto Dot con los datos del punto final.
     */
    public Line(Dot start, Dot end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Método que regresará el punto inicial de la línea.
     * @return Objeto tipo Dot con los datos del punto inicial.
     */
    public Dot getStart() {
        return start;
    }

    /**
     * Método para establecer el punto inicial de la línea.
     * @param start Objeto tipo Dot con los datos del punto inicial a establecer.
     */
    public void setStart(Dot start) {
        this.start = start;
    }

    /**
     * Método que regresará el punto final de la línea.
     * @return Objeto tipo Dot con los datos del punto final.
     */    
    public Dot getEnd() {
        return end;
    }
    /**
     * Método para establecer el punto final de la línea.
     * @param end Objeto tipo Dot con los datos del punto final a establecer.
     */
    public void setEnd(Dot end) {
        this.end = end;
    }

    /**
     * Método para obtener el color de la línea.
     * @return Cadena con el color de la línea.
     */
    public Color getColor() {
        return Color.decode(color);
    }

    /**
     * Método para establecer el color de la línea.
     * @param color Cadena con el color de la línea.
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Método para determinar si la línea entrante está conectada de alguna forma. 
     * @param line Objeto tipo Line el cual se le estará comparando.
     * @return Objeto tipo boolean con la respuesta de la comparativa.
     */
    public boolean joinDots(Line line)
    {
        return this.start.equals(line.start) || this.start.equals(line.end)
                || this.end.equals(line.start) || this.end.equals(line.end);
    }
    
    /**
     * Método para general el código hash de la clase.
     * @return Entero con el código Hash de la clase. 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.start);
        hash = 29 * hash + Objects.hashCode(this.end);
        hash = 29 * hash + Objects.hashCode(this.color);
        return hash;
    }
    
    /**
     * Método para determinar si el objeto entrante es el mismo al que fue usado.
     * @param obj Objeto a comparar.
     * @return Boolean con la respuesta de la comparativa.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Line other = (Line) obj;
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }
    
    /**
     * Método para transformar los datos del objeto a una sola cadena. 
     * @return Cadena con los datos del objeto, incluyendo las coordenadas X y Y.
     */
    @Override
    public String toString() {
        return "Line{" + "start=" + start + ", end=" + end + ", color=" + color + '}';
    }
    
}