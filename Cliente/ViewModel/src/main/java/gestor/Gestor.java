/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import Dominio.Line;
import Dominio.Mensaje;
import Dominio.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import endpoint.MessageReceiver;
import endpoint.MessageSender;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import observador.IObservadorEvento;



/**
 *
 * @author salce
 */
public class Gestor implements IObservadorEvento{
    
    private MessageSender mensajeSender;
    private Gson gson;
    //Agregado
    private MessageReceiver mensajeReceiver;
    private GestorElementosGraficos.GestorElementosGraficos gestorElementosGraficos;
    private GestorJugador.GestorCuenta gestorJugador;
    private Player jugadorPrincipal;
    
        public Gestor(GestorElementosGraficos.GestorElementosGraficos gestorelementosgraficos) {
        this.mensajeSender = new MessageSender();
        this.gson = new GsonBuilder().create();
        this.mensajeReceiver = new MessageReceiver();
        this.gestorElementosGraficos = gestorelementosgraficos;
        mensajeReceiver.agregarObservador(this);
    }
    
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
    
        public void enviarEvento(Mensaje eventosTimbiriche) {

            String jsonEvento = gson.toJson(eventosTimbiriche);
            mensajeSender.enviarMensaje(jsonEvento);

    }
        /**
         * 
         * @param setting jugadoresPrincipales (en turno) 
         */
                public void setJugadorPrincipal(Player jugadorPrincipal) {
            this.jugadorPrincipal = jugadorPrincipal;
    }
                public Player getJugadorPrincipal() {
            return jugadorPrincipal;
    }
        
    @Override
        public void nuevoMensajeRecibido(String mensaje) {

        System.out.println("..........Logica");
        Mensaje evt = gson.fromJson(mensaje, Mensaje.class);
        if (evt.getDistinatario().equals("logica")) {
            if (evt.getTipo().equals("linea")) {
                Line linea = gson.fromJson(gson.toJsonTree(evt.getObject()), Line.class);
                System.out.println(linea.toString());
                gestorElementosGraficos.addLinea(linea);
            } else if (evt.getTipo().equals("jugadorNuevo")) {

                Player jugador = gson.fromJson(gson.toJsonTree(evt.getObject()), Player.class);
                gestorJugador.addPlayer(jugador);
            } else if (evt.getTipo().equals("distancia")) {
                Double distancia = gson.fromJson(gson.toJsonTree(evt.getObject()), Double.class);
                System.out.println(distancia.toString());
                gestorElementosGraficos.setDistanciaPuntos(distancia);
            }
        }
    }
    
}