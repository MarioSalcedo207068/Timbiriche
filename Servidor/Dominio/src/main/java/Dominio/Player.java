package Dominio;

import com.google.gson.annotations.SerializedName;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Clase para representar al jugador dentro del proyecto Timbiriche.
 * @author Equipo 01
 */
public class Player {

    @SerializedName("name")
    private String name;
    private String color;
    @SerializedName("pathImage")
    private String pathImage;
    private int score;
    private List<Line> lineas = new ArrayList<>();
    private List<Box> boxes = new ArrayList<>();

    /**
     * Método constructor base de la clase.
     */
    public Player() {
    }

    public Player(String name, String color) {
        this.name = name;
        this.setColor(color);
    }
        
    /**
     * Método constructor con parámetros de la clase.
     *
     * @param name Cadena con el nombre del jugador.
     * @param pathImage Cadena con la dirección de la imágen a usar.
     * @param color Cadena con el color del jugador.
     */
    public Player(String name, String pathImage, String color) {
        this.name = name;
        this.color = color;
        this.pathImage = pathImage;
    }

    /**
     * Método constructor con parámetros de la clase.
     *
     * @param name Cadena con el nombre del jugador.
     * @param pathImage Cadena con la dirección de la imágen a usar.
     * @param color Cadena con el color del jugador.
     * @param score Entero con la puntuación del jugador.
     */
    public Player(String name, String color, String pathImage, int score) {
        this.name = name;
        this.color = color;
        this.pathImage = pathImage;
        this.score = score;
    }

    /**
     * Método constructor con parámetros de la clase.
     *
     * @param name Cadena con el nombre del jugador.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Método para añadir cantidad de puntos a la ya establecida del jugador.
     *
     * @param score Entero con la puntuación a añadir.
     * @return Entero con el resultado total de puntos.
     */
    private int addScore(int score) {
        return this.score;
    }

    /**
     * Método que regresa el nombre del jugador.
     *
     * @return Cadena con el nombre del jugador.
     */
    public String getName() {
        return name;
    }

    /**
     * Método para establecer el nombre del jugador.
     *
     * @param name Cadena con el nombre a establecer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que regresa el color del jugador.
     *
     * @return Cadena con el color del jugador.
     */
    public String getColor() {
        return color;
    }

    /**
     * Método para establecer el color del jugador.
     *
     * @param color Cadena con el color a establecer.
     */
    public void setColor(String color) {
        for (Line linea : lineas) {
            linea.setColor(color);
        }
        for (Box box : boxes) {
            box.setColor(color);
        }
        this.color = color;
    }

    /**
     * Método que regresa la dirección de la imágen del jugador.
     *
     * @return Cadena con la dirección de la imágen del jugador.
     */
    public String getPathImage() {
        return pathImage;
    }

    /**
     * Método para establecer la dirección de la imágen del jugador.
     *
     * @param pathImage Cadena la dirección de la imágen a establecer.
     */
    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    /**
     * Método que regresa la puntuación del jugador.
     *
     * @return Entero con la puntuación del jugador.
     */
    public int getScore() {
        return score;
    }

    /**
     * Método para establecer la puntuación del jugador.
     *
     * @param score Entero con la puntiación a establecer.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Método que obtiene el path url y hace un scale para que pueda usarse como
     * imagen del jugador
     *
     * @return Objeto tipo Icon con la imágen ya escalada.
     */
    public Icon getIcon() {
        try {
            URL imageUrl = getClass().getClassLoader().getResource(this.pathImage);
            Image originalImage = ImageIO.read(imageUrl);

            int newWidth = 100, newHeight = 100;
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            return new ImageIcon(resizedImage);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se cargó la imágen: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Método para general el código hash de la clase.
     * @return Entero con el código Hash de la clase. 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.color);
        hash = 37 * hash + Objects.hashCode(this.pathImage);
        hash = 37 * hash + this.score;
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
        final Player other = (Player) obj;
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.pathImage, other.pathImage)) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }
    
        public List<Line> getLineas() {
        return lineas;
    }

    public void setLineas(List<Line> lineas) {
        this.lineas = lineas;
    }

    public void addLine(Line line) {
        this.lineas.add(line);
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public void addBox(Box box) {
        this.boxes.add(box);
    }
    
    /**
     * Método para transformar los datos del objeto a una sola cadena. 
     * @return Cadena con los datos del objeto, incluyendo las coordenadas X y Y.
     */
    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", color=" + color + ", pathImage=" + pathImage + ", score=" + score + '}';
    }

}
