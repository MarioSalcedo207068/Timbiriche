package com.mycompany.controladortablero;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorTablero extends JFrame {
    private final int TAMANO = 10; // Tamaño del tablero (30x30)
    private JToggleButton[][] botones;
    private LineaHorizontal[][] lineasHorizontales;
    private LineaVertical[][] lineasVerticales;
    private int botonesSeleccionados = 0;
    private JToggleButton botonAnterior = null;

    public ControladorTablero() {
        setTitle("Tablero de Timbiriche");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Crear el arreglo bidimensional de botones y líneas
        botones = new JToggleButton[TAMANO][TAMANO];
        lineasHorizontales = new LineaHorizontal[TAMANO - 1][TAMANO];
        lineasVerticales = new LineaVertical[TAMANO][TAMANO - 1];

        // Crear el panel principal para contener los botones y las líneas
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(TAMANO * 2 - 1, TAMANO * 2 - 1));

        // Crear y agregar los botones y líneas al panel
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                botones[i][j] = new JToggleButton();
                botones[i][j].setPreferredSize(new Dimension(20, 20));
                
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
                                    conectarBotones(botonAnterior, botonActual);
                                botonesSeleccionados=0;
                                }
                                botonAnterior = botonActual;
                            } else {
                            }
                        } else {
                            botonesSeleccionados--;
                            if (botonAnterior == botonActual) {
                                botonAnterior = null;
                            }
                        }
                    }
                });
                panelPrincipal.add(botones[i][j]);

                if (j < TAMANO - 1) {
                    lineasVerticales[i][j] = new LineaVertical();
                    panelPrincipal.add(lineasVerticales[i][j]);
                }
            }
            if (i < TAMANO - 1) {
                for (int j = 0; j < TAMANO; j++) {
                    lineasHorizontales[i][j] = new LineaHorizontal();
                    panelPrincipal.add(lineasHorizontales[i][j]);
                    if (j < TAMANO - 1) {
                        panelPrincipal.add(new JLabel());
                    }
                }
            }
        }

        add(panelPrincipal);
        setVisible(true);
    }

    // Método para conectar dos botones con una línea
    private void conectarBotones(JToggleButton boton1, JToggleButton boton2) {
        int filaBoton1 = -1;
        int columnaBoton1 = -1;
        int filaBoton2 = -1;
        int columnaBoton2 = -1;

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
            lineasVerticales[filaBoton1][columnaInicio].conectar();

        } else if (columnaBoton1 == columnaBoton2) {
            // Están en la misma columna
            int filaInicio = Math.min(filaBoton1, filaBoton2);
            lineasHorizontales[filaInicio][columnaBoton1].conectar();
        }

    }

    // Clase interna para representar una línea horizontal
    private class LineaHorizontal extends JPanel {
        public LineaHorizontal() {
            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(20, 2));
            setVisible(false);
        }

        public void conectar() {
            setVisible(true);
        }
    }

    // Clase interna para representar una línea vertical
    private class LineaVertical extends JPanel {
        public LineaVertical() {
            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(2, 20));
            setVisible(false);
        }

        public void conectar() {
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ControladorTablero();
            }
        });
    }
}
