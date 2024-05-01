/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dominio.Dot;
import Dominio.Mensaje;
import Dominio.Player;
import GestorJugador.GestorCuenta;
import GestorJugador.IGestorCuenta;
import com.google.gson.Gson;
import endpoint.MessageSender;
import java.util.List;

/**
 *
 * @author salce
 */
public class Controlador {
    
    private final static Gson GSON = new Gson();
    //Tablero data
    IGestorCuenta gestorCuenta;
    GestorElementosGraficos.GestorElementosGraficos gestorElementosGraficos;
    //procesar el evento (mensajeSender)
    private MessageSender mensajeSender;
    
    public Controlador() {
        this.mensajeSender = new MessageSender();
        this.gestorCuenta = new GestorCuenta();
        this.gestorElementosGraficos = new GestorElementosGraficos.GestorElementosGraficos();
    }
    
    public void procesarMensaje(String mensajeBody) {
        Mensaje mensaje = GSON.fromJson(mensajeBody, Mensaje.class);
        if (mensaje.getTipo() == "agregar-jugador") {
            gestorCuenta.addPlayer((Player) mensaje.getObject());
            
            Mensaje mensajeRespuesta = new Mensaje("lista-jugadores", gestorCuenta.getListPlayer());
            
            String respuestaJson = GSON.toJson(mensajeRespuesta);
            
            mensajeSender.enviarMensaje(respuestaJson);
        }
        
        if (mensaje.getTipo() == "calcularPuntosTablero") {
            List<Integer> puntosTablero = (List<Integer>) mensaje.getObject();
            List<Dot> puntos = 
            gestorElementosGraficos.calcularPuntosTablero
            (puntosTablero.get(0),puntosTablero.get(1),puntosTablero.get(2));
            Mensaje mensajeRespuesta = new Mensaje("puntosCalculados",puntos);
            
            //Convertir json
            String respuestaJson = GSON.toJson(mensajeRespuesta);
            //envía a través del rabbit sender
            mensajeSender.enviarMensaje(respuestaJson);
            
        }
    }
    
    
    
}