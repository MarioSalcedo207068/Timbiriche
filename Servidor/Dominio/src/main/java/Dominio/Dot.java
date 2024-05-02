
package Dominio;

import com.google.gson.annotations.SerializedName;

/**
 * Clase para representar los puntos dentro del proyecto Timbiriche.
 * @author Equipo 01
 */
public class Dot {

    @SerializedName("x")
    int x;
    @SerializedName("y")
    int y;

    /**
     * Método constructor base de la clase.
     */
    public Dot() {
    }

    /**
     * Método constructor con parámetros de la clase. 
     * @param x Entero con la coordenada de X en el tablero.
     * @param y Entero con la coordenada de Y en el tablero.
     */
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Método para obtener el entero con la coordenada de X en el tablero.
     * @return Entero con coordenada X. 
     */
    public int getX() {
        return x;
    }

    /**
     * Método para establecer la coordenada de X en el tablero.
     * @param x Entero que definirá la coordenada X.
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Método para obtener el entero con la coordenada de Y en el tablero.
     * @return Entero con coordenada Y. 
     */
    public int getY() {
        return y;
    }

    /**
     * Método para establecer la coordenada de Y en el tablero.
     * @param y Entero que definirá la coordenada Y.
     */    
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Método para obtener la suma de ambas coordenadas X y Y.
     * @return Entero con la suma de las coordenadas.
     */
    public int suma() {
        return x + y;
    }

    /**
     * Método para general el código hash de la clase.
     * @return Entero con el código Hash de la clase. 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.x;
        hash = 67 * hash + this.y;
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
        final Dot other = (Dot) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

    /**
     * Método para transformar los datos del objeto a una sola cadena. 
     * @return Cadena con los datos del objeto, incluyendo las coordenadas X y Y.
     */
    @Override
    public String toString() {
        return "Dot{" + "x=" + x + ", y=" + y + '}';
    }

}
