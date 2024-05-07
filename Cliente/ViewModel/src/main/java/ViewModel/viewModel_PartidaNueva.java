/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Dominio.Game;
import View.PartidaNueva;
import View.Tablero;
import View.TableroPanel;
import gestor.Gestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import observador.IObservador;

/**
 *
 * @author salce
 */
public class viewModel_PartidaNueva implements ActionListener {

<<<<<<< HEAD
    PartidaNueva partidaNueva;
    Gestor gestor;
    Integer dimension;
    viewModelTablero viewModelTablero;

    public viewModel_PartidaNueva() {
    }


    public viewModel_PartidaNueva(Gestor gestor) {
        this.gestor = gestor;
        this.partidaNueva = new PartidaNueva();
        //this.gestor.agregarObservador((IObservador) partidaNueva);
        //this.generarEventosConfiguracion();

    }

    /*private void generarEventosConfiguracion() {
        this.partidaNueva.btn10.addActionListener(this);
        this.partidaNueva.btn20.addActionListener(this);
        this.partidaNueva.btn30.addActionListener(this);
        this.partidaNueva.btnStart.addActionListener(this);
    }*/
=======
    private Gestor gestor= Gestor.getInstance();
    PartidaNueva partidaNueva = new PartidaNueva();
    Integer dimension;
    viewModelTablero viewModelTablero;
    private viewModelLobbyEspera lobbyEspera;
    Game game = Game.getInstance();
    private TableroPanel tableroPanel;
    
    public viewModel_PartidaNueva() {
        this.partidaNueva.btn10.addActionListener(this);
        this.partidaNueva.btn20.addActionListener(this);
        this.partidaNueva.btn30.addActionListener(this);
        this.partidaNueva.btnStart.addActionListener(this);
        
    }

    private void generarEventosConfiguracion() {
    }
>>>>>>> d5e76cb (ajustes v2)

    public void iniciarPantalla() {
        //this.gestor.iniciarJugador();
        //this.partidaNueva.setCargarInfo(this.gestor);
        this.partidaNueva.setVisible(true);
        //this.gestor.mandarJugadorPrincipal();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() != "Play") {
            dimension = Integer.parseInt(e.getActionCommand());
            System.out.println(dimension);
            System.out.println("DIMENSION: " + e.getActionCommand());
        } else {
            //LOGICA PARA COMENZAR PARTIDA
            if (dimension == null) {
                JOptionPane.showMessageDialog(null, "Seleccione una dimensión primero");
            } else {
                System.out.println("COMENZAR");
                this.tableroPanel=new TableroPanel(game);
                tableroPanel.setSize(600, 600);
                gestor.calcularPuntosTablero(dimension, 600, 600);
                 tableroPanel = new TableroPanel(game);
                viewModelTablero.setPantallaTablero(tableroPanel);
                viewModelTablero.iniciarPantalla();
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