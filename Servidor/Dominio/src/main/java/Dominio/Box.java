/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author salce
 */
public class Box {
    private Dot pointA;
    private Dot pointB;
    private Dot pointC;
    private Dot pointD;
    private String color;

    public Box(Dot pointA, Dot pointB, Dot pointC, Dot pointD, String color) {
        
        List<Dot> dots = new ArrayList<>();
        dots.add(pointA);
        dots.add(pointB);
        dots.add(pointC);
        dots.add(pointD);
        
        Collections.sort(dots, Comparator.comparingInt(Dot::suma));
        
        this.pointA = dots.get(0);
        this.pointB = dots.get(1);
        this.pointC = dots.get(2);
        this.pointD = dots.get(3);
        
        
        this.color = color;
    }
    
    

    public Dot getPointA() {
        return pointA;
    }

    public Dot getPointB() {
        return pointB;
    }

    public Dot getPointC() {
        return pointC;
    }

    public Dot getPointD() {
        return pointD;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}