/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Dominio.Dot;
import View.Configuracion;
import View.Tablero;
import View.TableroPanel;
import gestor.Gestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import observador.IObservadorPantalla;

/**
 *
 * @author salce
 */
public class viewModelTablero {

/*    Tablero tablero;
    Configuracion configuracion;
    TableroPanel tableroPanel;
    Gestor gestor;
    viewModelPanelTablero viewModelPanelTablero;

    public viewModelTablero(int numeroPuntos, Gestor gestor) {
        this.tablero = new Tablero(gestor);
        this.tableroPanel = new TableroPanel();
        tableroPanel.setSize(600, 600);
        this.gestor = gestor;
        this.gestor.iniciarTablero(numeroPuntos,
                tableroPanel.getWidth(), tableroPanel.getHeight());
        gestor.setJugadores(gestor.getJugadores());
        this.tableroPanel.cargarInformacion(gestor);
        this.configuracion = new Configuracion();

        gestor.agregarObservador((IObservadorPantalla) tableroPanel);

        this.viewModelPanelTablero = new viewModelPanelTablero(tablero,
                tableroPanel, gestor);
        this.generarEventosConfiguracion();

    }

    private void generarEventosConfiguracion() {
        this.tablero.btnConfiguracion.addActionListener(this);

    }

    public void iniciar() {
        List<Dot> puntos = gestor.getPuntos();
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
