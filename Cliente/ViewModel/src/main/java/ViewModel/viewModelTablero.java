/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Dominio.Dot;
import Dominio.Game;
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
public class viewModelTablero implements ActionListener, IObservadorPantalla{
    
     Gestor gestor= Gestor.getInstance();
     Tablero tablero;
     viewModelPanelTablero viewModelPanelTablero;
     viewModelConfiguracion viewModelConfiguracion;
     viewModelFinJuego viewModelFinJuego;
     Game game = Game.getInstance();
    
        public viewModelTablero() {
            this.tablero = new Tablero();
    }
        
        public void agregarJugaresPantalla() {
        if (!game.getPlayers().isEmpty()) {
            if (game.getPlayers().size() >= 1 && game.getPlayers().get(0) != null) {
                tablero.txtPlayer1.setText(game.getPlayers().get(0).getName());
                tablero.txtPlayer1.setForeground(game.getPlayers().get(0).getColor());
                tablero.colorPlayer1.setOpaque(true);
                tablero.colorPlayer1.setBackground(game.getPlayers().get(0).getColor());
            }
            if (game.getPlayers().size() >= 2 && game.getPlayers().get(1) != null) {
                tablero.txtPlayer2.setText(game.getPlayers().get(1).getName());
                tablero.txtPlayer2.setForeground(game.getPlayers().get(1).getColor());
                tablero.colorPlayer2.setOpaque(true);
                tablero.colorPlayer2.setBackground(game.getPlayers().get(1).getColor());
            }

            if (game.getPlayers().size() >= 3 && game.getPlayers().get(2) != null) {
                tablero.txtPlayer3.setText(game.getPlayers().get(2).getName());
                tablero.txtPlayer3.setForeground(game.getPlayers().get(2).getColor());
                tablero.colorPlayer3.setOpaque(true);
                tablero.colorPlayer3.setBackground(game.getPlayers().get(2).getColor());
            }

            if (game.getPlayers().size() >= 4 && game.getPlayers().get(3) != null) {
                tablero.txtPlayer4.setText(game.getPlayers().get(3).getName());
                tablero.txtPlayer4.setForeground(game.getPlayers().get(3).getColor());
                tablero.colorPlayer4.setOpaque(true);
                tablero.colorPlayer4.setBackground(game.getPlayers().get(3).getColor());
            }

        }

    }
    
    public void iniciarPantalla() {
        
        this.tablero.setVisible(true);
    }

    public viewModelPanelTablero getViewModelPanelTablero() {
        return viewModelPanelTablero;
    }

    public void setViewModelPanelTablero(viewModelPanelTablero viewModelPanelTablero) {
        this.viewModelPanelTablero = viewModelPanelTablero;
    }

    public viewModelConfiguracion getViewModelConfiguracion() {
        return viewModelConfiguracion;
    }

    public void setViewModelConfiguracion(viewModelConfiguracion viewModelConfiguracion) {
        this.viewModelConfiguracion = viewModelConfiguracion;
    }

    public viewModelFinJuego getViewModelFinJuego() {
        return viewModelFinJuego;
    }

    public void setViewModelFinJuego(viewModelFinJuego viewModelFinJuego) {
        this.viewModelFinJuego = viewModelFinJuego;
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        @Override
    public void actualizarPantalla() {
        agregarJugaresPantalla();
        tablero.repaint();
    }
/*    
    TableroPanel tableroPanel;
    Gestor gestor;
    

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
