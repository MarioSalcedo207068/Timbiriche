/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dominio.Board;
import Dominio.Dot;
import Dominio.Line;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class TableroController {

    private Board tablero;
    private List<Dot> dots;

    public TableroController(int size) {
        dots = new ArrayList<>();
        tablero=new Board();
        iniciarTablero(size);
    }

    public Board iniciarTablero(int size) {
        tablero.setNumberOfDots(size);
        generaPosiciones(size);
        return tablero;
    }

    private void generaPosiciones(int size) {
        int intervalo = size / 10; // Intervalo entre las posiciones
        for (int i = 0; i < size; i += intervalo) {
            for (int j = 0; j < size; j += intervalo) {
                dots.add(new Dot(i, j));
            }
        }
    }   

    public List<Dot> getPosiciones() {
        return dots;
    }

    public Line conectarPuntos(Dot puntoInicio, Dot puntoFin) {
        return new Line(puntoInicio, puntoFin);
    }
}
