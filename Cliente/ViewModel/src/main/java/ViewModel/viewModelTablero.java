/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Dominio.Dot;
import View.Configuracion;
import View.Tablero;
import View.TableroPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author salce
 */
public class viewModelTablero {

    Tablero tablero;
    Configuracion configuracion;
    TableroPanel tableroPanel;
    GestorElementosGraficos.GestorElementosGraficos gestorElementosGraficos;
    //ControladorPanelTablero controladorPanelTablero;

    /*public ControladorTablero(int numeroPuntos,
            TableroData tableroData) {
        this.tablero = new Tablero(tableroData);
        this.tableroPanel = new TableroPanel();
        tableroPanel.setSize(600, 600);
        this.tableroData = tableroData;
        this.tableroData.iniciarTablero(numeroPuntos,
                tableroPanel.getWidth(), tableroPanel.getHeight());
        tableroData.setJugadores(tableroData.getJugadores());
        this.tableroPanel.cargarInformacion(tableroData);
        this.configuracion = new Configuracion();

        tableroData.agregarObservador(tableroPanel);

        this.controladorPanelTablero = new ControladorPanelTablero(tablero,
                tableroPanel, tableroData);
        this.generarEventosConfiguracion();

    }

    private void generarEventosConfiguracion() {
        this.tablero.btnConfiguracion.addActionListener(this);

    }

    public void iniciar() {
        List<Dot> puntos = tableroData.getPuntos();
        tablero.cargarTablero(tableroPanel);
//        ingresarJugadores();
        tablero.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source instanceof JButton) {
            JButton buttonClicked = (JButton) source;
            String comando = ae.getActionCommand();

            if (comando.equals("configuracion")) {
                this.configuracion.setVisible(true);
            }
        }

    }*/

}
