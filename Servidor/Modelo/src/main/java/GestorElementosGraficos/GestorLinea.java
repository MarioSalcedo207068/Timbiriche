/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorElementosGraficos;
import Dominio.Line;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase para representar el gestor de líneas dentro del proyecto
 * Timbiriche.
 * @author Equipo 01
 */
public class GestorLinea {

        List<Line> lineas = new ArrayList<>();

     /**
      * Método para regresar la lista de líneas.
      * @return Objeto lista de tipo Line con la información de todas las líneas disponibles.
      */
    public List<Line> getLineas() {
        return lineas;
    }

    /**
     * Método para implementar una lista de líneas completamente nueva.
     * @param lineas Objeto lista de tipo Line con toda la información de las nuevas líneas.
     */
    public void setLineas(List<Line> lineas) {
        this.lineas = lineas;
    }
        
    /**
     * Método para agregar una línea específica a la lista general de líneas.
     * @param line Objeto tipo Line con la información de la línea entrante.
     */
     public void addLinea(Line line){
         lineas.add(line);
     }
        
}
