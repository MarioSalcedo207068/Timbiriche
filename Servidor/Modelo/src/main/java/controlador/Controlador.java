/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dominio.Dot;
import Dominio.Player;
import GestorJugador.GestorCuenta;
import GestorJugador.IGestorCuenta;
import com.google.gson.Gson;
import endpoint.MessageSender;
import formato.Mensaje;
import java.util.List;
import observador.IObservador;

/**
 *
 * @author salce
 */
public class Controlador implements IObservador {

    private final static Gson GSON = new Gson();

    IGestorCuenta gestorCuenta;
    
    GestorElementosGraficos.GestorElementosGraficos gestorElementosGraficos;
    //procesar el evento (mensajeSender)
    private MessageSender mensajeSender;

    public Controlador() {
        this.mensajeSender = new MessageSender();
        this.gestorCuenta = new GestorCuenta();
        this.gestorElementosGraficos = new GestorElementosGraficos.GestorElementosGraficos();
    }

   
    @Override
    public void procesarMensaje(String mensajeBody) {
        Mensaje mensaje = GSON.fromJson(mensajeBody, Mensaje.class);

        if ("agregar-jugador".equals(mensaje.getTipo())) {
            Player player = GSON.fromJson(GSON.toJsonTree(mensaje.getObject()), Player.class);

            gestorCuenta.addPlayer(player);
            System.out.println("3");
            Mensaje mensajeRespuesta = new Mensaje("lista-jugadores", gestorCuenta.getListPlayer());
            System.out.println("4");
            String respuestaJson = GSON.toJson(mensajeRespuesta);
            System.out.println("5");
            mensajeSender.enviarMensaje(respuestaJson);
        }

        if (mensaje.getTipo() == "calcularPuntosTablero") {
            List<Integer> puntosTablero = (List<Integer>) mensaje.getObject();
            List<Dot> puntos
                    = gestorElementosGraficos.calcularPuntosTablero(puntosTablero.get(0), puntosTablero.get(1), puntosTablero.get(2));
            Mensaje mensajeRespuesta = new Mensaje("puntosCalculados", puntos);

            //Convertir json
            String respuestaJson = GSON.toJson(mensajeRespuesta);
            //envía a través del rabbit sender
            mensajeSender.enviarMensaje(respuestaJson);

        }
    }

}