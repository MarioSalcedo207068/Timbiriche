/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dominio.Mensaje;
import Dominio.Player;
import GestorJugador.GestorCuenta;
import GestorJugador.IGestorCuenta;
import com.google.gson.Gson;
import endpoint.MessageSender;

/**
 *
 * @author salce
 */
public class Controlador {
    
    private final static Gson GSON = new Gson();
    IGestorCuenta gestorCuenta;
    
    private MessageSender mensajeSender;
    
    public Controlador() {
        this.mensajeSender = new MessageSender();
        this.gestorCuenta = new GestorCuenta();
    }
    
    public void procesarMensaje(String mensajeBody) {
        Mensaje mensaje = GSON.fromJson(mensajeBody, Mensaje.class);
        if (mensaje.getTipo() == "agregar-jugador") {
            gestorCuenta.addPlayer((Player) mensaje.getObject());
            
            Mensaje mensajeRespuesta = new Mensaje("lista-jugadores", gestorCuenta.getListPlayer());
            
            String respuestaJson = GSON.toJson(mensajeRespuesta);
            
            mensajeSender.enviarMensaje(respuestaJson);
        }
    }
    
}