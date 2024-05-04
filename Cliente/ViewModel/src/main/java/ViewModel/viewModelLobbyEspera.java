/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Dominio.Game;
import View.LobbyEspera;
import gestor.Gestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import observador.IObservadorPantalla;

/**
 *
 * @author salce
 */
public class viewModelLobbyEspera implements ActionListener, IObservadorPantalla{
    Gestor gestor = Gestor.getInstance();
    LobbyEspera lobbyEspera;
    viewModelTablero viewModelTablero;
    viewModel_PantallaInicio viewModel_PantallaInicio;
    Game game = Game.getInstance();
    
    
    public viewModelLobbyEspera(viewModel_PantallaInicio viewModel_PantallaInicio) {
        this.viewModel_PantallaInicio = viewModel_PantallaInicio;
        this.lobbyEspera = new LobbyEspera();
        this.lobbyEspera.btnAceptar.addActionListener(this);
        this.lobbyEspera.btnSalir.addActionListener(this);
    }
        public void agregarJugaresPantalla() {
        if (!game.getPlayers().isEmpty()) {
            if (game.getPlayers().size() >= 1 && game.getPlayers().get(0) != null) {
                lobbyEspera.txtPlayer1.setText(game.getPlayers().get(0).getName());
                lobbyEspera.txtPlayer1.setForeground(game.getPlayers().get(0).getColor());
                lobbyEspera.colorPlayer1.setOpaque(true);
                lobbyEspera.colorPlayer1.setBackground(game.getPlayers().get(0).getColor());
            }
            if (game.getPlayers().size() >= 2 && game.getPlayers().get(1) != null) {
                lobbyEspera.txtPlayer2.setText(game.getPlayers().get(1).getName());
                lobbyEspera.txtPlayer2.setForeground(game.getPlayers().get(1).getColor());
                lobbyEspera.colorPlayer2.setOpaque(true);
                lobbyEspera.colorPlayer2.setBackground(game.getPlayers().get(1).getColor());
            }

            if (game.getPlayers().size() >= 3 && game.getPlayers().get(2) != null) {
                lobbyEspera.txtPlayer3.setText(game.getPlayers().get(2).getName());
                lobbyEspera.txtPlayer3.setForeground(game.getPlayers().get(2).getColor());
                lobbyEspera.colorPlayer3.setOpaque(true);
                lobbyEspera.colorPlayer3.setBackground(game.getPlayers().get(2).getColor());
            }

            if (game.getPlayers().size() >= 4 && game.getPlayers().get(3) != null) {
                lobbyEspera.txtPlayer4.setText(game.getPlayers().get(3).getName());
                lobbyEspera.txtPlayer4.setForeground(game.getPlayers().get(3).getColor());
                lobbyEspera.colorPlayer4.setOpaque(true);
                lobbyEspera.colorPlayer4.setBackground(game.getPlayers().get(3).getColor());
            }

        }

    }
        
    public void iniciarPantalla(){
        agregarJugaresPantalla();
        this.lobbyEspera.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lobbyEspera.btnAceptar) {
            //últimos cambios
            
            lobbyEspera.dispose();
        } if (e.getSource() == lobbyEspera.btnSalir) {
            viewModel_PantallaInicio.iniciarPantalla();
            lobbyEspera.dispose();
        }
    }

    @Override
    public void actualizarPantalla() {
        agregarJugaresPantalla();
        lobbyEspera.repaint();
    }
}