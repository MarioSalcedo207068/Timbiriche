/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.modelo;

import Dominio.Game;
import controlador.Controlador;
import endpoint.MessageReceiver;

/**
 *
 * @author salce
 */
public class Modelo {

    public static void main(String[] args) {
    
        System.out.println("Iniciando servidor");
        Game.getInstance();
        MessageReceiver mensajeReceiver = new MessageReceiver();
        Controlador controlador = new Controlador();
        mensajeReceiver.agregarObservador(controlador);
        mensajeReceiver.iniciarConsumidor();
    }
}
