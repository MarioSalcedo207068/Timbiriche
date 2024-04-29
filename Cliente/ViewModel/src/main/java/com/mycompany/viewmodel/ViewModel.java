/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.viewmodel;

import ViewModel.viewModel_PantallaRegistro;
import endpoint.MessageReceiver;

/**
 *
 * @author salce
 */
public class ViewModel {

    public static void main(String[] args) {
        System.out.println("Iniciando jugador");
        MessageReceiver mensajeReceiver = new MessageReceiver();
        new viewModel_PantallaRegistro().inciarPantalla();
        
        mensajeReceiver.iniciarCOnsumidor();
    }
}
