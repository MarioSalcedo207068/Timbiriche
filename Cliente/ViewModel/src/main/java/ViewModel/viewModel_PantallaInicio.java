/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import GestorJugador.GestorCuenta;
import View.PantallaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author salce
 */
public class viewModel_PantallaInicio implements ActionListener{
    
    private GestorCuenta gestorCuenta;
    private PantallaInicio pantallaInicio;
    private viewModel_PartidaNueva viewModel_PartidaNueva;
    private viewModel_UnirsePartida viewModel_UnirsePartida;
    
        public viewModel_PantallaInicio(GestorCuenta gestorCuenta) {
        this.gestorCuenta = gestorCuenta;
        // Verifica si tableroData y el líder no son nulos antes de intentar acceder al nombre
        if (gestorCuenta != null && gestorCuenta.getJugadorPrincipal() != null) {
            System.out.println(gestorCuenta.getJugadorPrincipal().getName());
        } else {
            // Maneja el caso en que tableroData o el líder es null
            System.out.println("TableroData o el líder es null");
        }
        this.pantallaInicio = new PantallaInicio();

        this.pantallaInicio.btnNuevaPartida.addActionListener(this);
        this.pantallaInicio.btnUnirse.addActionListener(this);

    }
        
            public void iniciarPantalla() {
        //this.viewModel_PartidaNueva = new viewModel_PartidaNueva(tableroData);
        //this.viewModel_UnirsePartida = new viewModel_UnirsePartida(tableroData);
        this.pantallaInicio.setVisible(true);
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
                if (e.getSource() == this.pantallaInicio.btnNuevaPartida) {
            this.pantallaInicio.dispose();
            //viewModel_PartidaNueva.iniciarPantalla();
        }
        if (e.getSource() == this.pantallaInicio.btnUnirse) {
            this.pantallaInicio.dispose();
            //viewModel_UnirsePartida.iniciarPantalla();
        }
    }
    
}
