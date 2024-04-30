/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import Dominio.Box;
import Dominio.Dot;
import Dominio.Line;
import Dominio.Mensaje;
import Dominio.Player;
import View.Tablero;
import View.TableroPanel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import endpoint.MessageReceiver;
import endpoint.MessageSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import observador.IObservable;
import observador.IObservador;
import observador.IObservadorEvento;



/**
 *
 * @author salce
 */
public class Gestor implements IObservable{
    private List<IObservador> observadoresPantalla;
    private MessageSender mensajeSender;
    private Gson gson;
    //Agregado
    private MessageReceiver mensajeReceiver;
    private Gestor gestor;
    //Cambiar esto
    private GestorElementosGraficos.GestorElementosGraficos gestorElementosGraficos;
    private GestorJugador.GestorCuenta gestorJugador;
    private Player jugadorPrincipal;
    private List<Player> jugadores;
    private List<Dot> puntos;
    private List<Line> lineas;
    private List<Box> cuadrados;
    private Double distanciaPuntos;
    Tablero tablero;
    
    TableroPanel tableroPanel;
    
        public Gestor(GestorElementosGraficos.GestorElementosGraficos gestorelementosgraficos) {
        this.mensajeSender = new MessageSender();
        this.gson = new GsonBuilder().create();
        this.mensajeReceiver = new MessageReceiver();
        this.gestorElementosGraficos = gestorelementosgraficos;
        //Se cambió a casteo
        mensajeReceiver.agregarObservador((IObservadorEvento) this);
    }
    
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
    public void calcularPuntosTablero(int cantidadPuntos, int anchoTablero, int altoTablero){
        List<Integer> puntosTablero = new ArrayList<>();
        puntosTablero.add(cantidadPuntos);
        puntosTablero.add(anchoTablero);
        puntosTablero.add(altoTablero);
        Mensaje mensaje = new Mensaje("calcularPuntosTablero", puntosTablero);
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

    @Override
    public void actualizarTodos() {
        for (IObservador observadores : observadoresPantalla) {
            observadores.actualizar();
        }
    }

    @Override
    public void agregarObservador(IObservador observador) {
        this.observadoresPantalla.add(observador);
    }

    @Override
    public void eliminarObservador(IObservador observador) {
        this.observadoresPantalla.remove(observador);
    }
    
    
    //últimos métodos agregados
        public List<Player> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Player> jugadores) {
        this.jugadores = jugadores;
    }
    
    public void iniciarTablero(int cantidadPuntos, int anchoTablero, int altoTablero) {
        this.puntos = calcularPuntosTablero(cantidadPuntos, anchoTablero, altoTablero);
        this.lineas = new ArrayList<>();
        this.cuadrados = new ArrayList<>();
        this.calcularDistancia();
    }
        private void calcularDistancia() {
        Dot puntoA = this.puntos.get(0);
        Dot puntoB = this.puntos.get(1);;
        Double distanciaX = Math.pow((puntoB.getX() - puntoA.getX()), 2);
        Double distanciaY = Math.pow((puntoB.getY() - puntoA.getY()), 2);
        this.distanciaPuntos = Math.sqrt(distanciaX + distanciaY);
        gestor.enviarEvento(new Mensaje("distancia", distanciaPuntos));
    }
    
            public List<Dot> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Dot> puntos) {
        this.puntos = puntos;
    }
    
        private List<Dot> calcularPuntosTablero(int cantidadPuntos, int anchoTablero, int altoTablero) {
        List<Dot> puntos = new ArrayList<>();
        int espacioAltura = altoTablero / cantidadPuntos;
        int espacioAncho = anchoTablero / cantidadPuntos;

        for (int i = (espacioAltura / 2); i <= altoTablero - (espacioAltura / 2); i += espacioAltura) {
            for (int j = (espacioAncho / 2); j <= anchoTablero - (espacioAncho / 2); j += espacioAncho) {
                puntos.add(new Dot(j, i));
            }

        }
        return puntos;
    }
        
            public void iniciar() {
        List<Dot> puntos = gestor.getPuntos();
        tablero.cargarTablero(tableroPanel);
//        ingresarJugadores();
        tablero.setVisible(true);
    }
}