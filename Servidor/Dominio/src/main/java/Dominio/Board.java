
package Dominio;

import java.util.List;


/**
 * Clase para representar el tablero dentro del proyecto Timbiriche.
 * @author Equipo 01
 */
public class Board {
    private int Height;
    private int Width;
    private int NumberOfDots;
    private List<Box> boxes;
    private List<Dot> dots;
    private List<Line> lines;

    /**
     * Método constructor base de la clase.
     */
    public Board() {
    }

    /**
     * Método constructor con parámetros de la clase. 
     * @param Height Número de puntos con los que contará el tablero de manera vertical.
     * @param Width Número de puntos con los que contará el tablero de manera horizontal.
     * @param NumberOfDots Número de puntos con los que contará el tablero en general.
     */
    public Board(int Height, int Width, int NumberOfDots) {
        this.Height = Height;
        this.Width = Width;
        this.NumberOfDots = NumberOfDots;
    }

    /**
     * Método que regresará el número total de puntos del tablero.
     * @return Entero con el número total de puntos del tablero.
     */
    public int getNumberOfDots() {
        return NumberOfDots;
    }

    /**
     * Método que establecerá el número total de puntos del tablero.
     * @param NumberOfDots Número total de puntos que deseamos asignar al tablero.
     */
    public void setNumberOfDots(int NumberOfDots) {
        this.NumberOfDots = NumberOfDots;
    }

    /**
     * Método que regresará el número de filas que contendrá el tablero. 
     * @return Entero con el número de filas que contendrá el tablero.
     */
    public int getHeight() {
        return Height;
    }

    /**
     * Método que establecerá el número de filas que contendrá el tablero. 
     * @param Height Número de filas que contendrá el tablero.
     */
    public void setHeight(int Height) {
        this.Height = Height;
    }

    /**
     * Método que regresará el número de columnas que contendrá el tablero. 
     * @return Entero con el número de columnas que contendrá el tablero.
     */
    public int getWidth() {
        return Width;
    }

    /**
     * Método que establecerá el número de columnas que contendrá el tablero. 
     * @param Width Número de columnas que contendrá el tablero.
     */    
    public void setWidth(int Width) {
        this.Width = Width;
    }
    
        public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public List<Dot> getDots() {
        return dots;
    }

    public void setDots(List<Dot> dots) {
        this.dots = dots;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public void addLine(Line line) {
        this.lines.add(line);
    }

    public void addBox(Box box) {
        this.boxes.add(box);
    }
    
}