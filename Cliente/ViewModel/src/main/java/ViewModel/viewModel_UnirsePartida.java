/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Dominio.Player;
import View.CodigoPartida;
import View.PantallaInicio;
import gestor.Gestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author salce
 */
public class viewModel_UnirsePartida implements ActionListener {

    CodigoPartida vistaCodigoPartida;
    PantallaInicio pantallaInicio;
    Gestor gestor;

    viewModel_PartidaNueva viewModel_PartidaNueva;

    public viewModel_UnirsePartida(Gestor gestor) {
        this.vistaCodigoPartida = new CodigoPartida();
        this.gestor = gestor;
        this.pantallaInicio = new PantallaInicio();

        this.viewModel_PartidaNueva = new viewModel_PartidaNueva();

    }

    public void generarEventos() {
        this.vistaCodigoPartida.btnEntrar.addActionListener(this);
        this.vistaCodigoPartida.btnSalir.addActionListener(this);
    }

    public void iniciarPantalla() {
        this.vistaCodigoPartida.setVisible(true);
    }

    public void unirsePartida(Player jugador) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Entrar") {
        } else {
            pantallaInicio.setVisible(true);
            this.vistaCodigoPartida.dispose();
        }
    }
}
