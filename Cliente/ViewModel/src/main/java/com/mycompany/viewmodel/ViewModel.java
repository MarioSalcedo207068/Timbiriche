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
<<<<<<< HEAD
        MessageReceiver mensajeReceiver = new MessageReceiver();
        new viewModel_PantallaRegistro().inciarPantalla();
=======
        Game.getInstance();
        Gestor.getInstance();

        Controlador controlador = new Controlador();
        MessageReceiver mensajeReceiver = new MessageReceiver(controlador);
        mensajeReceiver.iniciarCOnsumidor();

        viewModel_PantallaInicio viewModel_PantallaInicio = new viewModel_PantallaInicio();
        viewModelTablero viewModelTablero = new viewModelTablero();
        viewModel_PartidaNueva viewModel_PartidaNueva = new viewModel_PartidaNueva();
        viewModel_PartidaNueva.setViewModelTablero(viewModelTablero);
        //--Editado
        //viewModelLobbyEspera lobbyEspera = new viewModelLobbyEspera(viewModel_PantallaInicio);
        viewModelLobbyEspera lobbyEspera = new viewModelLobbyEspera(viewModel_PantallaInicio, viewModelTablero);
>>>>>>> d5e76cb (ajustes v2)
        
        mensajeReceiver.iniciarCOnsumidor();
    }
}
