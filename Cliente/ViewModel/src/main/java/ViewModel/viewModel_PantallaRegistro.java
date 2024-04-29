/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import View.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author salce
 */
public class viewModel_PantallaRegistro implements ActionListener{

        private Registro pantallaRegistro;

    
        public void inciarPantalla() {
            pantallaRegistro.setVisible(true);
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
