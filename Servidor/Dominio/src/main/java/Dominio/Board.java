/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author salce
 */
public class Board implements InterfaceBoard{
    private int Height;
    private int Width;
    private int NumberOfDots;

    @Override
    public Line addLine() {
        
        return new Line();
        
    }

    public Box addBox() {
        
        return new Box();
        
    }

    @Override
    public Dot addDot() {
        
        return new Dot();
        
    }
    
}