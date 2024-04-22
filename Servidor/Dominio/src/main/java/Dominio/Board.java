/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author salce
 */
public class Board {
    private int Height;
    private int Width;
    private int NumberOfDots;

    public Board() {
    }

    public Board(int Height, int Width, int NumberOfDots) {
        this.Height = Height;
        this.Width = Width;
        this.NumberOfDots = NumberOfDots;
    }

    public int getNumberOfDots() {
        return NumberOfDots;
    }

    public void setNumberOfDots(int NumberOfDots) {
        this.NumberOfDots = NumberOfDots;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int Width) {
        this.Width = Width;
    }
    
}