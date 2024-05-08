/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dominio.Board;
import Dominio.Box;
import Dominio.Dot;
import Dominio.Game;
import Dominio.Line;
import Dominio.Player;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import formato.Mensaje;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import observador.IObservadorPantalla;
import observador.IObservable;

/**
 *
 * @author salce
 */
public class Controlador implements IObservable {

    private final static Gson GSON = new Gson();

    private Game game = Game.getInstance();

    private List<IObservadorPantalla> observadores = new ArrayList<>();

    public Controlador() {
    }

    
    public void procesarMensaje(String mensajeBody) {
        Mensaje mensaje = GSON.fromJson(mensajeBody, Mensaje.class);
        if (mensaje.getTipo().equals("lista-jugadores")) {

            Type tipoListaObjetos = new TypeToken<List<Player>>() {
            }.getType();
            List<Player> players = GSON.fromJson(GSON.toJson(mensaje.getObject()), tipoListaObjetos);

            game.setPlayers(players);

        }
        if(mensaje.getTipo().equals("puntos-calculados")){
            
            Type tipoListaObjetos = new TypeToken<List<Dot>>(){
            }.getType();
            List<Dot> dots = GSON.fromJson(GSON.toJson(mensaje.getObject()), tipoListaObjetos);
            
            game.getBoard().setDots(dots);
        }
        if(mensaje.getTipo().equals("agregar-linea")){
        
            Type tipoListaObjetos = new TypeToken<List<Line>>() {
            }.getType();
            List<Line> line = GSON.fromJson(GSON.toJson(mensaje.getObject()), tipoListaObjetos);
            
            game.getBoard().setLines(line);
        }
        if(mensaje.getTipo().equals("agregar-cuadrado")){
        
            Type tipoListaObjetos = new TypeToken<List<Box>>() {
            }.getType();
            List<Box> box = GSON.fromJson(GSON.toJson(mensaje.getObject()), tipoListaObjetos);
            
            game.getBoard().setBoxes(box);
        }
        
        actualizarTodos();
    }

    @Override
    public void actualizarTodos() {
        for (IObservadorPantalla observadore : observadores) {
            observadore.actualizarPantalla();
        }
    }

    @Override
    public void agregarObservador(IObservadorPantalla observador) {
        this.observadores.add(observador);
    }

}
