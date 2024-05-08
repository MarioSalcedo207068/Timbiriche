/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import View.PartidaNueva;
import gestor.Gestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author salce
 */
public class viewModel_PartidaNueva implements ActionListener {

    private Gestor gestor= Gestor.getInstance();
    PartidaNueva partidaNueva;
    Integer dimension;
    viewModelTablero viewModelTablero;
    private viewModelLobbyEspera lobbyEspera;

    public viewModel_PartidaNueva() {
        this.partidaNueva = new PartidaNueva();
        this.partidaNueva.btn10.addActionListener(this);
        this.partidaNueva.btn20.addActionListener(this);
        this.partidaNueva.btn30.addActionListener(this);
        this.partidaNueva.btnStart.addActionListener(this);
    }



    /*private void generarEventosConfiguracion() {
        this.partidaNueva.btn10.addActionListener(this);
        this.partidaNueva.btn20.addActionListener(this);
        this.partidaNueva.btn30.addActionListener(this);
        this.partidaNueva.btnStart.addActionListener(this);
    }*/

    public void iniciarPantalla() {
        //this.gestor.iniciarJugador();
        //this.partidaNueva.setCargarInfo(this.gestor);
        this.partidaNueva.setVisible(true);
        //this.gestor.mandarJugadorPrincipal();

    }

    public viewModelTablero getViewModelTablero() {
        return viewModelTablero;
    }

    public void setViewModelTablero(viewModelTablero viewModelTablero) {
        this.viewModelTablero = viewModelTablero;
    }

    public viewModelLobbyEspera getLobbyEspera() {
        return lobbyEspera;
    }

    public void setLobbyEspera(viewModelLobbyEspera lobbyEspera) {
        this.lobbyEspera = lobbyEspera;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() != "Comenzar") {
            dimension = Integer.parseInt(e.getActionCommand());
            System.out.println(dimension);
            System.out.println("DIMENSION: " + e.getActionCommand());
        } else {
            //LOGICA PARA COMENZAR PARTIDA
            if (dimension == null) {
                JOptionPane.showMessageDialog(null, "Seleccione una dimensión primero");
            } else {
                System.out.println("COMENZAR");
                //this.viewModelTablero = new viewModelTablero(dimension, gestor);
                //viewModelTablero.iniciar();
                partidaNueva.dispose();
            }
        }
    }

    public void comenzarPartidaNueva(boolean listo) {
        if (listo == true) {
            //this.viewModelTablero = new viewModelTablero(dimension, gestor);
            //viewModelTablero.iniciar();
            partidaNueva.dispose();

        }
    }
}
