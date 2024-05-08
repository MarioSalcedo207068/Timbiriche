/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dominio.Game;
import Dominio.Player;
import com.google.gson.Gson;
import formato.Mensaje;
import java.util.List;
import observador.IObservador;

/**
 *
 * @author salce
 */
public class Controlador implements IObservador {

    private final static Gson GSON = new Gson();

    private Game game = Game.getInstance();

    public Controlador() {
    }

    @Override
    public void procesarMensaje(String mensajeBody) {
        Mensaje mensaje = GSON.fromJson(mensajeBody, Mensaje.class);
        if (mensaje.getTipo() == "lista-jugadores") {

            List<Player> jugadores = (List<Player>) mensaje.getObject();
            game.setPlayers(jugadores);
            for (Player jugador : jugadores) {
                System.out.println(jugador.toString());
            }
        }
    }

}
