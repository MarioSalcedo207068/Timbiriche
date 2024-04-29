/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import com.google.gson.annotations.SerializedName;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author salce
 */
public class Player {
    @SerializedName("name")
    private String name;
    @SerializedName("color")
    private String color;
    @SerializedName("pathImage")
    private String pathImage;
    private int score;

    public Player() {
    }

    public Player(String name, String color, String pathImage, int score) {
        this.name = name;
        this.color = color;
        this.pathImage = pathImage;
        this.score = score;
    }

    public Player(String name) {
        this.name = name;
    }
    
    private int addScore(int score){
        return this.score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
                if (color == "rojo") {
            return Color.RED;

        } else if (color == "azul") {
            return Color.BLUE;
        }
        return null;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    /**
     * Obtiene el path url y hace un scale para que pueda usarse como imagen del jugador
     */
        public Icon getIcon() {
        try 
            {
            URL imageUrl = getClass().getClassLoader().getResource(this.pathImage);
            Image originalImage = ImageIO.read(imageUrl);

            int newWidth = 100, newHeight = 100;
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            return new ImageIcon(resizedImage);
            
            } catch (IOException e) 
            {
            JOptionPane.showMessageDialog(null, "No se cargó la imágen: " + e.getMessage());
            return null;
            }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.color);
        hash = 37 * hash + Objects.hashCode(this.pathImage);
        hash = 37 * hash + this.score;
        return hash;
    }

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

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", color=" + color + ", pathImage=" + pathImage + ", score=" + score + '}';
    }
        
        
    
}