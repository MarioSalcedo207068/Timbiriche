/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import Dominio.Dot;
import Dominio.Line;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import Dominio.Box;

/**
 *
 * @author salce
 */
public class GestorPanel {

    public void dibujarPuntos(Graphics g, List<Dot> puntos,
            Dot puntoA, Dot puntoB) {
        for (int i = 0; i < puntos.size(); i++) {
            g.setColor(Color.WHITE);
            int posicionX = puntos.get(i).getX();
            int posicionY = puntos.get(i).getY();
            if (puntoA != null
                    && puntoA.equals(puntos.get(i))
                    || puntoB != null
                    && puntoB.equals(puntos.get(i))) {
                g.setColor(Color.GREEN);
            }
            g.fillOval(posicionX, posicionY, 10, 10);
        }
    }

    public void dibujarLineas(Graphics g, List<Line> lineas) {
        if (lineas != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(5));
            for (int i = 0; i < lineas.size(); i++) {
                g.setColor(lineas.get(i).getColor());
                Dot a = lineas.get(i).getStart();
                Dot b = lineas.get(i).getEnd();
                g.drawLine(a.getX() + 10 / 2,
                        a.getY() + 10 / 2,
                        b.getX() + 10 / 2,
                        b.getY() + 10 / 2);
            }
        }
    }

    public void dibujarCuadrados(Graphics g, List<Box> cuadrados, int lado) {
        if (cuadrados != null) {
            for (int i = 0; i < cuadrados.size(); i++) {
                g.setColor(cuadrados.get(i).getColor());
                g.fillRect(cuadrados.get(i).getPointA().getX(),
                        cuadrados.get(i).getPointA().getY(),
                        lado + 10, lado + 10);
            }
        }
    }
}