/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import Dominio.Player;
import com.google.gson.Gson;
import endpoint.MessageReceiver;
import endpoint.MessageSender;
import formato.Mensaje;



/**
 *
 * @author salce
 */
public class Gestor  {
    private MessageSender mensajeSender;
    private Gson gson;
    private static Gestor gestor;
    //Agregado
    //private MessageReceiver mensajeReceiver;

    private Gestor() {
        this.mensajeSender = new MessageSender();
        this.gson = new Gson();
    }
        public static Gestor getInstance() {
        if (gestor == null) {
            gestor = new Gestor();
        }
        return gestor;
    }

    // Correcto
    public void agregarJugador(Player player) {
        Mensaje mensaje = new Mensaje("agregar-jugador", player);
        String messageBody = convertirMensaje(mensaje);
        mensajeSender.enviarMensaje(messageBody);
    }

    /*
    // Correcto
    public void calcularPuntosTablero(int cantidadPuntos, int anchoTablero, int altoTablero) {
        List<Integer> puntosTablero = new ArrayList<>();
        puntosTablero.add(cantidadPuntos);
        puntosTablero.add(anchoTablero);
        puntosTablero.add(altoTablero);
        Mensaje mensaje = new Mensaje("calcularPuntosTablero", puntosTablero);
        String messageBody = convertirMensaje(mensaje);
        mensajeSender.enviarMensaje(messageBody);
    }


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
