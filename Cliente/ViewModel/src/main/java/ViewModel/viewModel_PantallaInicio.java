/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import View.PantallaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gestor.Gestor;
/**
 *
 * @author salce
 */

public class viewModel_PantallaInicio implements ActionListener{
    
    private Gestor gestor= Gestor.getInstance();
    private PantallaInicio pantallaInicio;
    private viewModel_PartidaNueva viewModel_PartidaNueva;
    private viewModelLobbyEspera lobbyEspera;
    
        public viewModel_PantallaInicio() {
            
        this.pantallaInicio = new PantallaInicio();

        this.pantallaInicio.btnNuevaPartida.addActionListener(this);
        this.pantallaInicio.btnUnirse.addActionListener(this);

    }
        
    public void iniciarPantalla() {
        
        this.pantallaInicio.setVisible(true);
    }
    
        public viewModel_PartidaNueva getViewModel_PartidaNueva() {
        return viewModel_PartidaNueva;
    }

    public void setViewModel_PartidaNueva(viewModel_PartidaNueva viewModel_PartidaNueva) {
        this.viewModel_PartidaNueva = viewModel_PartidaNueva;
    }

    public viewModelLobbyEspera getLobbyEspera() {
        return lobbyEspera;
    }

    public void setLobbyEspera(viewModelLobbyEspera lobbyEspera) {
        this.lobbyEspera = lobbyEspera;
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.pantallaInicio.btnNuevaPartida) {
            this.pantallaInicio.dispose();
            viewModel_PartidaNueva.iniciarPantalla();
        }
        if (e.getSource() == this.pantallaInicio.btnUnirse) {
            this.pantallaInicio.dispose();
            lobbyEspera.iniciarPantalla();
        }
    }
    
}
