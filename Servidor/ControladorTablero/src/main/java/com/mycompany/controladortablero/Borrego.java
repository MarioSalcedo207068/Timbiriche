/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.controladortablero;

import Controller.TableroController;
import Dominio.Dot;
import Dominio.Line;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class Borrego extends javax.swing.JFrame {

        private final TableroController tableroController;
    private final int TAMANO;
    private JToggleButton[][] botones;
    private JPanel[][] lineasHorizontales; // Usaremos JPanel para representar las líneas
    private JPanel[][] lineasVerticales;   // Usaremos JPanel para representar las líneas
    private int botonesSeleccionados = 0;
    private JToggleButton botonAnterior = null;

    public Borrego(int tamano) {
         initComponents();
        this.TAMANO = tamano;
        this.tableroController = new TableroController(TAMANO);
        setTitle("Tablero de Timbiriche");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Crear el arreglo bidimensional de botones y líneas
        botones = new JToggleButton[TAMANO][TAMANO];
        lineasHorizontales = new JPanel[TAMANO-1][TAMANO];
        lineasVerticales = new JPanel[TAMANO][TAMANO-1];

        // Crear y agregar los botones y líneas al panel|
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                botones[i][j] = new JToggleButton();
                botones[i][j].setPreferredSize(new Dimension(10, 10));

                final int fila = i;
                final int columna = j;
                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JToggleButton botonActual = botones[fila][columna];
                        if (botonActual.isSelected()) {
                            if (botonesSeleccionados < 2) {
                                botonesSeleccionados++;
                                if (botonAnterior != null) {
                                    conectarBotones(botonAnterior, botonActual,Color.YELLOW);
                                    botonesSeleccionados = 0;
                                }
                                botonAnterior = botonActual;
                            }
                        } else {
                            botonesSeleccionados--;
                            if (botonAnterior == botonActual) {
                                botonAnterior = null;
                            }
                        }
                    }
                });
                this.panelPrincipal.add(botones[i][j]);
                 
                if (j < TAMANO - 1) {
                    lineasVerticales[i][j] = new JPanel(); // Usamos JPanel para representar las líneas verticales
                    lineasVerticales[i][j].setVisible(true);
                    lineasVerticales[i][j].setPreferredSize(new Dimension(2, 20));
                    this.panelPrincipal.add(lineasVerticales[i][j]);
                }
            }
            if (i < TAMANO - 1) {
                for (int j = 0; j < TAMANO; j++) {
                    lineasHorizontales[i][j] = new JPanel(); // Usamos JPanel para representar las líneas horizontales
                    lineasHorizontales[i][j].setVisible(true);
                    lineasHorizontales[i][j].setPreferredSize(new Dimension(20, 2));

                    this.panelPrincipal.add(lineasHorizontales[i][j]);
                    if (j < TAMANO - 1) {
                       this.panelPrincipal.add(new JLabel());
                    }
                }
            
            }
        }

        add(panelPrincipal);
        setVisible(true);
                this.panelPrincipal.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));

    }

  
        // Método para conectar dos botones con una línea
    private void conectarBotones(JToggleButton boton1, JToggleButton boton2,Color color) {
        int filaBoton1 = -1;
        int columnaBoton1 = -1;
        int filaBoton2 = -1;
        int columnaBoton2 = -1;

        Dot puntoInicio = tableroController.getPosiciones().get(getBotonFila(boton1));
        Dot puntoFin = tableroController.getPosiciones().get(getBotonFila(boton2));
        Line linea = tableroController.conectarPuntos(puntoInicio, puntoFin);
        System.out.println(linea);
        // Encontrar la posición de los botones
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (botones[i][j] == boton1) {
                    filaBoton1 = i;
                    columnaBoton1 = j;
                }
                if (botones[i][j] == boton2) {
                    filaBoton2 = i;
                    columnaBoton2 = j;
                }
            }
        }

        // Determinar si los botones están en la misma fila o columna
        if (filaBoton1 == filaBoton2) {
            // Están en la misma fila
            int columnaInicio = Math.min(columnaBoton1, columnaBoton2);
            lineasVerticales[filaBoton1][columnaInicio].setVisible(true);
            lineasVerticales[filaBoton1][columnaInicio].setBackground(color);

        } else if (columnaBoton1 == columnaBoton2) {
            // Están en la misma columna
            int filaInicio = Math.min(filaBoton1, filaBoton2);
            lineasHorizontales[filaInicio][columnaBoton1].setVisible(true);
            lineasHorizontales[filaInicio][columnaBoton1].setBackground(color);
            
        }

    }



    // Método auxiliar para obtener la fila de un botón
    private int getBotonFila(JToggleButton boton) {
        
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (botones[i][j] == boton) {
                    return i;
            }
        }
        }
        return -1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelPrincipal = new javax.swing.JPanel();
        imgPlayer3 = new javax.swing.JLabel();
        imgPlayer2 = new javax.swing.JLabel();
        imgPlayer4 = new javax.swing.JLabel();
        imgPlayer1 = new javax.swing.JLabel();
        txtPlayer2 = new javax.swing.JLabel();
        txtPlayer3 = new javax.swing.JLabel();
        txtPlayer4 = new javax.swing.JLabel();
        score1 = new javax.swing.JLabel();
        txtPlayer1 = new javax.swing.JLabel();
        score2 = new javax.swing.JLabel();
        score3 = new javax.swing.JLabel();
        score4 = new javax.swing.JLabel();
        btnConfiguracion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPrincipalMouseClicked(evt);
            }
        });
        panelPrincipal.setLayout(new java.awt.GridLayout());
        jPanel1.add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 672, 390));
        jPanel1.add(imgPlayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 269, -1, -1));
        jPanel1.add(imgPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(834, 21, -1, -1));
        jPanel1.add(imgPlayer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(834, 269, -1, -1));
        jPanel1.add(imgPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 21, -1, -1));

        txtPlayer2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPlayer2.setText("Player 2");
        jPanel1.add(txtPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, -1, -1));

        txtPlayer3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPlayer3.setText("Player 3");
        jPanel1.add(txtPlayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 281, -1, -1));

        txtPlayer4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPlayer4.setText("Player 4");
        jPanel1.add(txtPlayer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, -1, -1));

        score1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        score1.setText("Score");
        jPanel1.add(score1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        txtPlayer1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPlayer1.setText("Player 1");
        jPanel1.add(txtPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        score2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        score2.setText("Score");
        jPanel1.add(score2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, -1, -1));

        score3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        score3.setText("Score");
        jPanel1.add(score3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 312, -1, -1));

        score4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        score4.setText("Score");
        jPanel1.add(score4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, -1, -1));

        btnConfiguracion.setBackground(new java.awt.Color(153, 204, 255));
        btnConfiguracion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnConfiguracion.setText("Configuración");
        jPanel1.add(btnConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPrincipalMouseClicked
        System.out.println("aqui toy");
    }//GEN-LAST:event_panelPrincipalMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Borrego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Borrego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Borrego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Borrego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Borrego(30).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnConfiguracion;
    public javax.swing.JLabel imgPlayer1;
    public javax.swing.JLabel imgPlayer2;
    public javax.swing.JLabel imgPlayer3;
    public javax.swing.JLabel imgPlayer4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel score1;
    private javax.swing.JLabel score2;
    private javax.swing.JLabel score3;
    private javax.swing.JLabel score4;
    private javax.swing.JLabel txtPlayer1;
    private javax.swing.JLabel txtPlayer2;
    private javax.swing.JLabel txtPlayer3;
    private javax.swing.JLabel txtPlayer4;
    // End of variables declaration//GEN-END:variables
}
