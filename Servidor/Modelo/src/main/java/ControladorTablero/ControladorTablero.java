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
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class ControladorTablero {
    private Board tablero;
    private Game game;
    private List<Dot> dots;
    private GestorLinea gestorLineas;
    private Line[][] lineasHorizontales;
    private Line[][] lineasVerticales;
    
    public ControladorTablero(int size) {
        dots = new ArrayList<>();
        tablero=new Board();
        game=Game.getInstance();
          gestorLineas=new GestorLinea();
        lineasHorizontales = new Line[size-1][size];
        lineasVerticales = new Line[size][size-1];
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
                System.out.println(dots.get(j));
            }
        }
    }   

   public void addLineHorizontal(Line line, int posicionHorizontal,int posicionVerical){
       lineasHorizontales[posicionHorizontal][posicionVerical]=line;
   }
  
    
   public void addLineVertical(Line line, int posicionHorizontal,int posicionVerical){
       lineasHorizontales[posicionHorizontal][posicionVerical]=line;
   }
    public List<Dot> getPosiciones() {
        return dots;
    }

    public Line conectarPuntos(Dot puntoInicio, Dot puntoFin) {
        Line line=new Line(puntoInicio,puntoFin);
        gestorLineas.addLinea(line);
        return line;
    }
    
   public void terminarJuego() {
        dots.clear();
        
    }
    public boolean esTurno(int turno) {
      if(game.getPlayers().get(turno).equals(turno)){
      return true;
      }
      return false;
    }
}
