/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import View.FinJuego;
import gestor.Gestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author salce
 */
public class viewModelFinJuego implements ActionListener{
    
    private FinJuego finJuego;
    private Gestor gestor = Gestor.getInstance();
    private viewModel_PantallaInicio viewModel_PantallaInicio;
    private viewModel_PartidaNueva viewModel_PartidaNueva;
    
    public viewModelFinJuego(){
        this.finJuego = finJuego;
        this.finJuego.btnMenu.addActionListener(this);
        this.finJuego.btnNewGame.addActionListener(this);
//        finJuego.imgGanador.setIcon(tableroData.getJugadorPrincipal().getIcono());
    }
    
    public void iniciarPantalla(){
        this.finJuego.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == finJuego.btnMenu) {
            
            viewModel_PantallaInicio.iniciarPantalla();
            finJuego.dispose();
            
        } if (e.getSource() == finJuego.btnNewGame) {
            
            viewModel_PartidaNueva = new viewModel_PartidaNueva();
            viewModel_PartidaNueva.iniciarPantalla();
            finJuego.dispose();
        }
    }
}