/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import com.google.gson.annotations.SerializedName;
import java.awt.Color;
import java.util.Objects;

/**
 *
 * @author salce
 */
public class Line {
    @SerializedName("start")
    private Dot start;
    @SerializedName("end")
    private Dot end;
    @SerializedName("color")
    private Color color;

    public Line() {
    }

    public Line(Dot start, Dot end) {
        this.start = start;
        this.end = end;
    }

    public Dot getStart() {
        return start;
    }

    public void setStart(Dot start) {
        this.start = start;
    }

    public Dot getEnd() {
        return end;
    }

    public void setEnd(Dot end) {
        this.end = end;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public boolean joinDots(Line line)
    {
        return this.start.equals(line.start) || this.start.equals(line.end)
                || this.end.equals(line.start) || this.end.equals(line.end);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.start);
        hash = 29 * hash + Objects.hashCode(this.end);
        hash = 29 * hash + Objects.hashCode(this.color);
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
        final Line other = (Line) obj;
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }

    @Override
    public String toString() {
        return "Line{" + "start=" + start + ", end=" + end + ", color=" + color + '}';
    }
    
}