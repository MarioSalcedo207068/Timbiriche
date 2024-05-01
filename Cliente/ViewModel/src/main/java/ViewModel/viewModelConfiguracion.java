/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Dominio.Player;
import View.Configuracion;
import View.Tablero;
import gestor.Gestor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author salce
 */
public class viewModelConfiguracion implements ActionListener {

    Configuracion configuracion;
    Tablero tablero;
    Player jugador;
    Gestor gestor;
    private String colorSeleccionado;

    public viewModelConfiguracion() {
        this.tablero = new Tablero();
        this.configuracion = new Configuracion();
        //this.cargarIcons();
        this.generarEventos();

    }

    public void iniciar() {
        configuracion.setVisible(true);
//         List<Jugador> listaDeJugadores = tableroData.getJugadores();
//        Jugador jugadorActual = listaDeJugadores.get(0);
//        configuracion.imgJugador1.setText(jugadorActual.getIcono());
    }

    public void generarEventos() {
        this.configuracion.btnAceptar.addActionListener(this);
        this.configuracion.btnCancelar.addActionListener(this);

        this.configuracion.cbxColor1.addActionListener(this);
        this.configuracion.cbxColor2.addActionListener(this);
        this.configuracion.cbxColor3.addActionListener(this);
        this.configuracion.cbxColor4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTONES ACTION
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton buttonClicked = (JButton) source;
            if (buttonClicked.equals(configuracion.btnCancelar)) {
                tablero.setVisible(true);
            }
            if (buttonClicked.equals(configuracion.btnAceptar)) {
                tablero.setVisible(true);
            }
        }

        //COMBOBOX ACTION
        if (e.getSource() == configuracion.cbxColor1) {
            Color color = Color.decode(extraerColor(configuracion.cbxColor1));
            //setColorJugador(color, 0);
        }
        if (e.getSource() == configuracion.cbxColor2) {
            Color color = Color.decode(extraerColor(configuracion.cbxColor2));
            //setColorJugador(color, 1);
        }
        if (e.getSource() == configuracion.cbxColor3) {
            Color color = Color.decode(extraerColor(configuracion.cbxColor3));
            //setColorJugador(color, 2);
        }
        if (e.getSource() == configuracion.cbxColor4) {
            Color color = Color.decode(extraerColor(configuracion.cbxColor4));
            //setColorJugador(color, 3);
        }
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