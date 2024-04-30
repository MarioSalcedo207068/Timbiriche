/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import GestorJugador.GestorCuenta;
import View.PartidaNueva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author salce
 */
public class viewModel_PartidaNueva implements ActionListener {

    PartidaNueva partidaNueva;
    GestorCuenta gestorCuenta;
    Integer dimension;
    viewModelTablero viewModelTablero;

    public viewModel_PartidaNueva() {
    }


    /*public ControladorPartidaNueva(TableroData tablero) {
        this.gestorCuenta = tablero;
        this.partidaNueva = new PartidaNueva();
        this.gestorCuenta.agregarObservador(partidaNueva);
        this.generarEventosConfiguracion();

    }*/

    private void generarEventosConfiguracion() {
        this.partidaNueva.btn10.addActionListener(this);
        this.partidaNueva.btn20.addActionListener(this);
        this.partidaNueva.btn30.addActionListener(this);
        this.partidaNueva.btnStart.addActionListener(this);
    }

    /*public void iniciarPantalla() {
        this.tableroData.iniciarJugador();
        this.partidaNueva.setCargarInfo(this.tableroData);
        this.partidaNueva.setVisible(true);
        this.tableroData.mandarJugadorPrincipal();

    }*/

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
                //this.viewModelTablero = new viewModelTablero(dimension, tableroData);
                //controladorTablero.iniciar();
                partidaNueva.dispose();
            }
        }
    }

    public void comenzarPartidaNueva(boolean listo) {
        /*if (listo == true) {
            this.controladorTablero = new ControladorTablero(dimension, tableroData);
            controladorTablero.iniciar();
            partidaNueva.dispose();

        }*/
    }
}
