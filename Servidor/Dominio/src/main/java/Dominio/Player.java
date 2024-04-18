/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.awt.Color;

/**
 *
 * @author salce
 */
public class Player {
    private String name;
    private Color color;
    private String pathImage;
    private int score;

    public Player() {
    }

    public Player(String name, Color color, String pathImage, int score) {
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
        return color;
    }

    public void setColor(Color color) {
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
    
    
}