/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import Dominio.Mensaje;
import Dominio.Player;
import com.google.gson.Gson;
import endpoint.MessageSender;

/**
 *
 * @author salce
 */
public class Gestor {
    
    private MessageSender mensajeSender;
    private Gson gson;
    
    public Gestor() {
        this.mensajeSender = new MessageSender();
        this.gson = new Gson();
    }
    
    public void agregarJugador(Player player) {
        Mensaje mensaje = new Mensaje("agregar-jugador", player);
        String messageBody = convertirMensaje(mensaje);
        mensajeSender.enviarMensaje(messageBody);
    }
    
    private String convertirMensaje(Mensaje mensaje) {
        return gson.toJson(mensaje);
    }
    
}