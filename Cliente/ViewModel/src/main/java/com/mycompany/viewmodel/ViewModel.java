/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.viewmodel;

import Dominio.Game;
import ViewModel.viewModelLobbyEspera;
import ViewModel.viewModelTablero;
import ViewModel.viewModel_PantallaInicio;
import ViewModel.viewModel_PantallaRegistro;
import ViewModel.viewModel_PartidaNueva;
import controlador.Controlador;
import endpoint.MessageReceiver;
import gestor.Gestor;

/**
 *
 * @author salce
 */
public class ViewModel {

    public static void main(String[] args) {
        System.out.println("Iniciando jugador");
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
        

        controlador.agregarObservador(lobbyEspera);
        controlador.agregarObservador(viewModelTablero);

        viewModel_PantallaInicio.setLobbyEspera(lobbyEspera);
        viewModel_PantallaInicio.setViewModel_PartidaNueva(viewModel_PartidaNueva);
        new viewModel_PantallaRegistro(viewModel_PantallaInicio).inciarPantalla();
    }
}
