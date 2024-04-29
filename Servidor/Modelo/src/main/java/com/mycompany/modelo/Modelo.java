/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.modelo;

import endpoint.MessageReceiver;

/**
 *
 * @author salce
 */
public class Modelo {

    public static void main(String[] args) {
    
        System.out.println("Iniciando servidor");

        MessageReceiver mensajeReceiver = new MessageReceiver();

        mensajeReceiver.iniciarConsumidor();
    }
}
