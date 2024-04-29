/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Dominio.Mensaje;
import Dominio.Player;
import View.Registro;
import gestor.Gestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author salce
 */
public class viewModel_PantallaRegistro implements ActionListener {

    private Registro pantallaRegistro;
    private Gestor gestor;

    public viewModel_PantallaRegistro() {
        this.pantallaRegistro = new Registro();
        this.gestor = new Gestor();
        this.pantallaRegistro.btnRegistrar.addActionListener(this);

    }

    public void inciarPantalla() {
        pantallaRegistro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pantallaRegistro.btnRegistrar) {
            String nombreJugador = pantallaRegistro.txtUserName.getText();
            Player player = new Player(nombreJugador);
            gestor.agregarJugador(player);
            
            if (nombreJugador.equals("")) {
                JOptionPane.showMessageDialog(null, "El nickname del jugador está vacío");
            }
        }
    }
}