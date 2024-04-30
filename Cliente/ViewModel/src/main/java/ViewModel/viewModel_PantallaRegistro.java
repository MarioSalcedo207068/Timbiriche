/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Dominio.Mensaje;
import Dominio.Player;
import GestorJugador.GestorCuenta;
import View.Registro;
import gestor.Gestor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author salce
 */
public class viewModel_PantallaRegistro implements ActionListener {

    private Registro pantallaRegistro;
    private Gestor gestor;
    private String color;
    private String colorSeleccionado;
    private GestorCuenta gestorCuenta;
    private String direccionImg;
    
    private viewModel_PantallaInicio viewModel_PantallaInicio;

    public viewModel_PantallaRegistro() {
        this.pantallaRegistro = new Registro();
        this.gestor = new Gestor();
        this.pantallaRegistro.btnRegistrar.addActionListener(this);
        this.pantallaRegistro.cbxColor.addActionListener(this);

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
                JOptionPane.showMessageDialog(null, "El nombre del jugador está vacío");
            } /*else {
                this.gestorCuenta.setJugadorPrincipal(new Player(nombreJugador, direccionImg, color));
                viewModel_PantallaInicio = new viewModel_PantallaInicio(gestorCuenta);
                viewModel_PantallaInicio.iniciarPantalla();
                pantallaRegistro.dispose();
            }*/
        }
        
        /**
         * Para los colores
         */
        /*if (e.getSource() == pantallaRegistro.cbxColor) {
            try {
                color = Color.decode(extraerColor(pantallaRegistro.cbxColor));
            } catch (NumberFormatException ex) {
                color = null;
                System.out.println(ex.getMessage());
            }

        }*/
        
        
    }
        private String extraerColor(JComboBox<String> comboBox) {
        colorSeleccionado = (String) comboBox.getSelectedItem();
        String colorJava = "";
        switch (colorSeleccionado.toLowerCase()) {
            case "negro":
                colorJava = "#000000";
                break;
            case "blanco":
                colorJava = "#FFFFFF";
                break;
            case "rojo":
                colorJava = "#FF0000";
                break;
            case "verde":
                colorJava = "#00FF00";
                break;
            case "azul":
                colorJava = "#0000FF";
                break;
            case "amarillo":
                colorJava = "#FFFF00";
                break;
            case "cian":
                colorJava = "#00FFFF";
                break;
            case "morado":
                colorJava = "#800080";
                break;
            case "gris claro":
                colorJava = "#CCCCCC";
                break;
            case "gris oscuro":
                colorJava = "#666666";
                break;
        }
        return colorJava;
    }
}