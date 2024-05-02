/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorElementosGraficos;
import Dominio.Line;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author santi
 */
public class GestorLinea {

        List<Line> lineas = new ArrayList<>();

    public List<Line> getLineas() {
        return lineas;
    }

    public void setLineas(List<Line> lineas) {
        this.lineas = lineas;
    }
        
     public void addLinea(Line line){
         lineas.add(line);
     }
        
}
