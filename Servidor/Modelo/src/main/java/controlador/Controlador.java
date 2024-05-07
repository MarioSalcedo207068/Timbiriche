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
 * Clase para representar el controlador de mensajes dentro del proyecto Timbiriche.
 * @author Equipo 01
 */
public class Controlador implements IObservador {
    
<<<<<<< HEAD
    private final static Gson GSON = new Gson();
    //Tablero data
    IGestorCuenta gestorCuenta;
    GestorElementosGraficos.GestorElementosGraficos gestorElementosGraficos;
=======
    GestorElementosGraficos gestorElementosGraficos;
>>>>>>> d5e76cb (ajustes v2)
    //procesar el evento (mensajeSender)
    private MessageSender mensajeSender;
    
    /**
     * Método constructor base de la clase.
     */
    public Controlador() {
        this.mensajeSender = new MessageSender();
        this.gestorCuenta = new GestorCuenta();
        this.gestorElementosGraficos = new GestorElementosGraficos();
    }
    
    /**
     * Método para procesar un mensaje entrante e interpretarlo dependiendo de su contenido.
     * @param mensajeBody Objeto tipo Cadena con el mensaje a interpretar.
     */
    @Override
    public void procesarMensaje(String mensajeBody) {
        Mensaje mensaje = GSON.fromJson(mensajeBody, Mensaje.class);
        
        if (mensaje.getTipo() == "agregar-jugador") {
            Player player = GSON.fromJson(GSON.toJsonTree(mensaje.getObject()), Player.class);
<<<<<<< HEAD
            gestorCuenta.addPlayer((Player) mensaje.getObject());
            
            Mensaje mensajeRespuesta = new Mensaje("lista-jugadores", gestorCuenta.getListPlayer());
            
            String respuestaJson = GSON.toJson(mensajeRespuesta);
            
            mensajeSender.enviarMensaje(respuestaJson);
        }
        
        /*if (mensaje.getTipo() == "calcularPuntosTablero") {
            List<Integer> puntosTablero = (List<Integer>) mensaje.getObject();
            List<Dot> puntos = 
            gestorElementosGraficos.calcularPuntosTablero
            (puntosTablero.get(0),puntosTablero.get(1),puntosTablero.get(2));
            Mensaje mensajeRespuesta = new Mensaje("puntosCalculados",puntos);
=======

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
>>>>>>> d5e76cb (ajustes v2)
            
            //Convertir json
            String respuestaJson = GSON.toJson(mensajeRespuesta);
            //envía a través del rabbit sender
            mensajeSender.enviarMensaje(respuestaJson);
<<<<<<< HEAD
            
        }*/
    }
    
    
    
}
=======

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
>>>>>>> d5e76cb (ajustes v2)
