/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import View.PantallaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gestor.Gestor;
/**
 *
 * @author salce
 */

public class viewModel_PantallaInicio implements ActionListener{
    
    private Gestor gestor;
    private PantallaInicio pantallaInicio;
    private viewModel_PartidaNueva viewModel_PartidaNueva;
    private viewModel_UnirsePartida viewModel_UnirsePartida;
    
        public viewModel_PantallaInicio(Gestor gestor) {
        this.gestor = gestor;
        
/*        if (gestor != null && gestor.getJugadorPrincipal() != null) {
            System.out.println(gestor.getJugadorPrincipal().getName());
        } else {
            // Maneja el caso en que gestor es null
            System.out.println("Gestor es null");
        }*/
        this.pantallaInicio = new PantallaInicio();

        this.pantallaInicio.btnNuevaPartida.addActionListener(this);
        this.pantallaInicio.btnUnirse.addActionListener(this);

    }
        
    public void iniciarPantalla() {
        this.viewModel_PartidaNueva = new viewModel_PartidaNueva(gestor);
        this.viewModel_UnirsePartida = new viewModel_UnirsePartida(gestor);
        this.pantallaInicio.setVisible(true);
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
                if (e.getSource() == this.pantallaInicio.btnNuevaPartida) {
            this.pantallaInicio.dispose();
            viewModel_PartidaNueva.iniciarPantalla();
        }
        if (e.getSource() == this.pantallaInicio.btnUnirse) {
            this.pantallaInicio.dispose();
            viewModel_UnirsePartida.iniciarPantalla();
        }
    }
    
}
