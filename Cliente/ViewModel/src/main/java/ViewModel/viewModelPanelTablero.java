/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import View.Tablero;
import View.TableroPanel;
import gestor.Gestor;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;

/**
 *
 * @author salce
 */
public class viewModelPanelTablero implements MouseListener {

    //TableroPanel tableroPanel;
    Tablero tablero;
    Gestor gestor;

    public viewModelPanelTablero(Tablero tablero, TableroPanel tableroPanel, Gestor gestor) {
//        this.tableroPanel = tableroPanel;
        this.tablero = tablero;
        this.gestor = gestor;

        this.generarEventosConfiguracion();
    }

    private void generarEventosConfiguracion() {
        tablero.panelPrincipal.addMouseListener(this);

    }

    /*public boolean seleccionarPunto(MouseEvent me) {
        Punto punto = new Punto(me.getX(), me.getY());
        boolean respuesta = tableroData.validarPunto(punto);
        return respuesta;
    }*/

    @Override
    public void mouseClicked(MouseEvent me) {
        switch (me.getButton()) {
            case MouseEvent.BUTTON1:
                //seleccionarPunto(me);
                break;
            case MouseEvent.BUTTON3:
                //gestor.vaciarPuntos();
                break;

        }
    }

    @Override
    public void mousePressed(MouseEvent me
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent me
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {
        this.tablero.panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
    }
}