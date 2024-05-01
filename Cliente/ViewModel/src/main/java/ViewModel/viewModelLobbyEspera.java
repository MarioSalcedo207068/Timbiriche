/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import View.LobbyEspera;
import gestor.Gestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author salce
 */
public class viewModelLobbyEspera implements ActionListener{
    Gestor gestor;
    LobbyEspera lobbyEspera;
    viewModelTablero viewModelTablero;
    viewModel_PantallaInicio viewModel_PantallaInicio;

    public viewModelLobbyEspera() {
        this.gestor = gestor;
        this.lobbyEspera = lobbyEspera;
        this.lobbyEspera.btnAceptar.addActionListener(this);
        this.lobbyEspera.btnSalir.addActionListener(this);
    }
    
    public void iniciarPantalla(){
        this.lobbyEspera.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lobbyEspera.btnAceptar) {
            //ESTO SE SOLUCIONA CON EVENTOS
            viewModelTablero = new viewModelTablero(0, gestor);
            viewModelTablero.iniciar();
            lobbyEspera.dispose();
        } if (e.getSource() == lobbyEspera.btnSalir) {
            viewModel_PantallaInicio = new viewModel_PantallaInicio(gestor);
            viewModel_PantallaInicio.iniciarPantalla();
            lobbyEspera.dispose();
        }
    }
}