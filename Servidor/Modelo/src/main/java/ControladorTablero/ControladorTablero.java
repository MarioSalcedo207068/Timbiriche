/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorTablero;

import Dominio.Board;
import Dominio.Dot;
import Dominio.Game;
import Dominio.Line;
import GestorElementosGraficos.GestorLinea;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para representar el controlador de tablero dentro del proyecto
 * Timbiriche.
 *
 * @author Equipo 01
 */
public class ControladorTablero {

    private Board tablero;
    private Game game;
    private List<Dot> dots;
    private GestorLinea gestorLineas;
    private Line[][] lineasHorizontales;
    private Line[][] lineasVerticales;

    /**
     * Método constructor de la clase con un parámetro.
     *
     * @param size Objeto tipo Entero con el tamaño del tablero a construir.
     */
    public ControladorTablero(int size) {
        dots = new ArrayList<>();
        tablero = new Board();
        game = Game.getInstance();
        gestorLineas = new GestorLinea();
        lineasHorizontales = new Line[size - 1][size];
        lineasVerticales = new Line[size][size - 1];
        iniciarTablero(size);
    }

    /**
     * Método para la creacíon de los puntos del tablero correspondiente.
     *
     * @param size Objeto tipo Entero con la cantidad de posiciones que se
     * generarán.
     * @return Objeto tipo Board con la configuración de los puntos realizada.
     */
    public Board iniciarTablero(int size) {
        tablero.setNumberOfDots(size);
        generaPosiciones(size);
        return tablero;
    }

    /**
     * Método para generar las posiciones de los puntos dentro del tablero.
     *
     * @param size Objeto tipo Entero con el tamaño que tendrán los intervalos.
     */
    private void generaPosiciones(int size) {
        int intervalo = size / 10; // Intervalo entre las posiciones
        for (int i = 0; i < size; i += intervalo) {
            for (int j = 0; j < size; j += intervalo) {
                dots.add(new Dot(i, j));
                System.out.println(dots.get(j));
            }
        }
    }

    /**
     * Método para agregar una línea horizontal dependiendo de las coordenadas
     * insertadas en los parámetros.
     *
     * @param line Objeto tipo Line con la información de la línea a generar.
     * @param posicionHorizontal Objeto tipo Entero con la posición horizontal
     * de la línea.
     * @param posicionVerical Objeto tipo Entero con la posición vertical de la
     * línea.
     */
    public void addLineHorizontal(Line line, int posicionHorizontal, int posicionVerical) {
        lineasHorizontales[posicionHorizontal][posicionVerical] = line;
    }

    /**
     * Método para agregar una línea vertical dependiendo de las coordenadas
     * insertadas en los parámetros.
     *
     * @param line Objeto tipo Line con la información de la línea a generar.
     * @param posicionHorizontal Objeto tipo Entero con la posición horizontal
     * de la línea.
     * @param posicionVerical Objeto tipo Entero con la posición vertical de la
     * línea.
     */
    public void addLineVertical(Line line, int posicionHorizontal, int posicionVerical) {
        lineasHorizontales[posicionHorizontal][posicionVerical] = line;
    }

    /**
     * Método para obtener la lista de puntos que representan las posiciones.
     *
     * @return Lista tipo Dot con la información de los puntos ocupados.
     */
    public List<Dot> getPosiciones() {
        return dots;
    }

    /**
     * Método para conectar dos puntos proporcionados.
     *
     * @param puntoInicio Objeto tipo Dot con la información del punto inicial.
     * @param puntoFin Objeto tipo Dot con la información del punto final.
     * @return Objeto tipo Line con ambos puntos proporcionados ya unidos.
     */
    public Line conectarPuntos(Dot puntoInicio, Dot puntoFin) {
        Line line = new Line(puntoInicio, puntoFin);
        gestorLineas.addLinea(line);
        return line;
    }

    /**
     * Método ejecutado al terminar el juego para limpiar el tablero.
     */
    public void terminarJuego() {
        dots.clear();

    }

    /**
     * Método para determianr el turno de un jugador a partir de un número
     * proporcionado.
     *
     * @param turno Objeto tipo Entero con el índice del jugador al que se
     * quiere obtener su información.
     * @return Objeto tipo Boolean con la respuesta de las comparativas.
     */
    public boolean esTurno(int turno) {
        if (game.getPlayers().get(turno).equals(turno)) {
            return true;
        }
        return false;
    }
}
