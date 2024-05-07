/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import Dominio.Box;
import Dominio.Line;
import Dominio.Player;
import com.google.gson.Gson;
import endpoint.MessageReceiver;
import endpoint.MessageSender;
import formato.Mensaje;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salce
 */
public class Gestor  {
    private MessageSender mensajeSender;
    private Gson gson;
    //Agregado
    private MessageReceiver mensajeReceiver;

    public Gestor() {
        this.mensajeSender = new MessageSender();
        this.gson = new Gson();
    }

    // Correcto
    public void agregarJugador(Player player) {
        Mensaje mensaje = new Mensaje("agregar-jugador", player);
        String messageBody = convertirMensaje(mensaje);
        mensajeSender.enviarMensaje(messageBody);
    }

    
    // Correcto
    public void calcularPuntosTablero(int cantidadPuntos, int anchoTablero, int altoTablero) {
        List<Integer> puntosTablero = new ArrayList<>();
        puntosTablero.add(cantidadPuntos);
        puntosTablero.add(anchoTablero);
        puntosTablero.add(altoTablero);
        Mensaje mensaje = new Mensaje("calcular-puntos-tablero", puntosTablero);
        String messageBody = convertirMensaje(mensaje);
        mensajeSender.enviarMensaje(messageBody);
    }
    
    public void agregarLinea(Line line){
        Mensaje mensaje = new Mensaje("dibujar-linea", line);
        String messageBody = convertirMensaje(mensaje);
        mensajeSender.enviarMensaje(messageBody);
    }
    
//    public void agregarCuadrado(Box box){
//        Mensaje mensaje = new Mensaje("dibujar-cuadrado", box);
//        String messageBody = convertirMensaje(mensaje);
//        mensajeSender.enviarMensaje(messageBody);
//    }

/*
    public void iniciarTablero(int cantidadPuntos, int anchoTablero, int altoTablero) {
        //editado
        List<Integer> iniciarTablero = new ArrayList<>();
        iniciarTablero.add(cantidadPuntos);
        iniciarTablero.add(anchoTablero);
        iniciarTablero.add(altoTablero);
        Mensaje mensaje = new Mensaje("iniciarTablero", iniciarTablero);
        this.lineas = new ArrayList<>();
        this.cuadrados = new ArrayList<>();
        this.calcularDistancia();
    }
     */
    private String convertirMensaje(Mensaje mensaje) {
        return gson.toJson(mensaje);
    }

    public void enviarEvento(Mensaje eventosTimbiriche) {

        String jsonEvento = gson.toJson(eventosTimbiriche);
        mensajeSender.enviarMensaje(jsonEvento);

    }

}
