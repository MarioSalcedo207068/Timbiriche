/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Dominio.Player;
import GestorJugador.GestorCuenta;
import View.Registro;
import gestor.Gestor;
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
    private Gestor gestor = Gestor.getInstance();
    private String color;
    private String colorSeleccionado;
    private String direccionImg;
    
    private viewModel_PantallaInicio viewModel_PantallaInicio;
    //private int contador = 0;
    //private Icon icon;
    private GestorCuenta gestorCuenta;
    

    public viewModel_PantallaRegistro(viewModel_PantallaInicio viewModel_PantallaInicio) {
        this.viewModel_PantallaInicio = viewModel_PantallaInicio;
        this.pantallaRegistro = new Registro();
        this.pantallaRegistro.btnRegistrar.addActionListener(this);
        this.pantallaRegistro.cbxColor.addActionListener(this);

    }

    public void inciarPantalla() {
        pantallaRegistro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Player player = new Player();
        if (e.getSource() == pantallaRegistro.btnRegistrar) {
            String nombreJugador = pantallaRegistro.txtUserName.getText();
            player.setName(nombreJugador);
        
            if (nombreJugador.equals("")) {
                JOptionPane.showMessageDialog(null, "El nombre del jugador está vacío");
            }   else if (color == null) {
                JOptionPane.showMessageDialog(null, "El color del jugador está vacío");
            }  else {
                        
                /*direccionImg = "images/" + contador + ".jpg";
        icon = cargarImagen(direccionImg);
        //new ImageIcon(getClass().getClassLoader().getResource("images/" + contador + ".jpg"));
        pantallaRegistro.imgAvatar.setIcon(icon);*/
                
                player.setColor(color);
                System.out.println(color.toString());
                gestor.agregarJugador(player);
               
                viewModel_PantallaInicio.iniciarPantalla();
                pantallaRegistro.dispose();
            }
        }
    // Para los colores
        if(e.getSource() == pantallaRegistro.cbxColor) {
            try {
                color = (extraerColor(pantallaRegistro.cbxColor));
            } catch (NumberFormatException ex) {
                color = null;
                System.out.println(ex.getMessage());
            }

        }

    }
    
    
    /*private Icon cargarImagen(String path) {
        try {
            URL imageUrl = getClass().getClassLoader().getResource(path);
            Image originalImage = ImageIO.read(imageUrl);

            int newWidth = 100;
            int newHeight = 100;

            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + e.getMessage());
            return null;
        }
    }*/
    
    
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
        }
        return colorJava;
    }
}