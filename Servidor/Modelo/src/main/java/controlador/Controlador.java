/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dominio.Board;
import Dominio.Box;
import Dominio.Dot;
import Dominio.Line;
import Dominio.Player;
import GestorElementosGraficos.GestorElementosGraficos;
import GestorJugador.GestorCuenta;
import GestorJugador.IGestorCuenta;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import endpoint.MessageSender;
import formato.Mensaje;
import java.lang.reflect.Type;
import java.util.List;
import observador.IObservador;

/**
 *
 * @author salce
 */
public class Controlador implements IObservador {

    private final static Gson GSON = new Gson();

    IGestorCuenta gestorCuenta;
    
    GestorElementosGraficos gestorElementosGraficos;
    //procesar el evento (mensajeSender)
    private MessageSender mensajeSender;

    public Controlador() {
        this.mensajeSender = new MessageSender();
        this.gestorCuenta = new GestorCuenta();
        this.gestorElementosGraficos = new GestorElementosGraficos();
    }

   
    @Override
    public void procesarMensaje(String mensajeBody) {
        Mensaje mensaje = GSON.fromJson(mensajeBody, Mensaje.class);

        if ("agregar-jugador".equals(mensaje.getTipo())) {
            Player player = GSON.fromJson(GSON.toJsonTree(mensaje.getObject()), Player.class);

            gestorCuenta.addPlayer(player);
            Mensaje mensajeRespuesta = new Mensaje("lista-jugadores", gestorCuenta.getListPlayer());
            String respuestaJson = GSON.toJson(mensajeRespuesta);
            mensajeSender.enviarMensaje(respuestaJson);
        }

        if ("calcular-Puntos-Tablero".equals(mensaje.getTipo())) {
            Type tipoListaObjetos = new TypeToken<List<Integer>>() {
            }.getType();
            List<Integer> puntosTablero = GSON.fromJson(GSON.toJson(mensaje.getObject()), tipoListaObjetos);          
            List<Dot> puntos = gestorElementosGraficos.calcularPuntosTablero(puntosTablero.get(0), puntosTablero.get(1), puntosTablero.get(2));
            
            for (Dot punto : puntos) {
                gestorElementosGraficos.addDot(punto);
            }
            Mensaje mensajeRespuesta = new Mensaje("puntos-calculados", gestorElementosGraficos.getPuntos());
            
            //Convertir json
            String respuestaJson = GSON.toJson(mensajeRespuesta);
            //envía a través del rabbit sender
            mensajeSender.enviarMensaje(respuestaJson);

        }
        
        if ("dibujar-linea".equals(mensaje.getTipo())) {
            Line line = GSON.fromJson(GSON.toJsonTree(mensaje.getObject()), Line.class);
            
            gestorElementosGraficos.addLinea(line);
            
            Mensaje mensajeRespuesta = new Mensaje("agregar-linea", gestorElementosGraficos.getLineas() );
            String respuestaJson = GSON.toJson(mensajeRespuesta);
            mensajeSender.enviarMensaje(respuestaJson);
            
            Mensaje mensajeRespuestaCajas = new Mensaje("agregar-cuadrado", gestorElementosGraficos.getBox());
            String respuestaJsonCajas = GSON.toJson(mensajeRespuestaCajas);
            mensajeSender.enviarMensaje(respuestaJsonCajas);
        }
        
        
        
    }
}
