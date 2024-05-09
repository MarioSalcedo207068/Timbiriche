package com.mycompany.controladortablero;
import Controller.TableroController;
import Dominio.Dot;
import Dominio.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prueba extends JFrame {
    private final TableroController tableroController;
    private final int TAMANO;
    private JToggleButton[][] botones;
    private JPanel[][] lineasHorizontales; // Usaremos JPanel para representar las líneas
    private JPanel[][] lineasVerticales;   // Usaremos JPanel para representar las líneas
    private int botonesSeleccionados = 0;
    private JToggleButton botonAnterior = null;

    public Prueba(int tamano) {
        this.TAMANO = tamano;
        this.tableroController = new TableroController(TAMANO);
        setTitle("Tablero de Timbiriche");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el arreglo bidimensional de botones y líneas
        botones = new JToggleButton[TAMANO][TAMANO];
        lineasHorizontales = new JPanel[TAMANO - 1][TAMANO];
        lineasVerticales = new JPanel[TAMANO][TAMANO - 1];
        
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
                panelPrincipal.add(botones[i][j]);

                if (j < TAMANO - 1) {
                    lineasVerticales[i][j] = new JPanel(); // Usamos JPanel para representar las líneas verticales
                    lineasVerticales[i][j].setVisible(false);
                    lineasVerticales[i][j].setPreferredSize(new Dimension(2, 20));
                    panelPrincipal.add(lineasVerticales[i][j]);
                }
            }
            if (i < TAMANO - 1) {
                for (int j = 0; j < TAMANO; j++) {
                    lineasHorizontales[i][j] = new JPanel(); // Usamos JPanel para representar las líneas horizontales
                    lineasHorizontales[i][j].setVisible(false);
                    lineasHorizontales[i][j].setPreferredSize(new Dimension(20, 2));
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
    private void conectarBotones(JToggleButton boton1, JToggleButton boton2, Color color) {
        Dot puntoInicio = tableroController.getPosiciones().get(getBotonFila(boton1));
        Dot puntoFin = tableroController.getPosiciones().get(getBotonFila(boton2));
        Line linea = tableroController.conectarPuntos(puntoInicio, puntoFin);
        
        int filaBoton1 = getBotonFila(boton1);
        int columnaBoton1 = getBotonColumna(boton1);
        int filaBoton2 = getBotonFila(boton2);
        int columnaBoton2 = getBotonColumna(boton2);

        // Encontrar la posición de los botones
        if (filaBoton1 == filaBoton2) {
            // Están en la misma fila
            int columnaInicio = Math.min(columnaBoton1, columnaBoton2);
            lineasVerticales[filaBoton1][columnaInicio].setVisible(true);
            lineasVerticales[filaBoton1][columnaInicio].setBackground(color);
            // Validar si se ha cerrado un cuadrado
            validarCuadrado(filaBoton1, columnaInicio);
        } else if (columnaBoton1 == columnaBoton2) {
            // Están en la misma columna
            int filaInicio = Math.min(filaBoton1, filaBoton2);
            lineasHorizontales[filaInicio][columnaBoton1].setVisible(true);
            lineasHorizontales[filaInicio][columnaBoton1].setBackground(color);
            // Validar si se ha cerrado un cuadrado
            validarCuadrado(filaInicio, columnaBoton1);
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
  
    // Método auxiliar para obtener la columna de un botón
    private int getBotonColumna(JToggleButton boton) {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (botones[i][j] == boton) {
                    return j;
                }
            }
        }
        return -1;
    }

    // Método para validar si se ha cerrado un cuadrado
    private void validarCuadrado(int fila, int columna) {
        // Verifica si se han conectado los cuatro lados del cuadrado
        boolean arriba = lineasHorizontales[fila][columna].isVisible();
        boolean abajo = lineasHorizontales[fila + 1][columna].isVisible();
        boolean izquierda = lineasVerticales[fila][columna].isVisible();
        boolean derecha = lineasVerticales[fila][columna + 1].isVisible();

        // Si se ha cerrado el cuadrado, rellénalo de color
        if (arriba && abajo && izquierda && derecha) {
            botones[fila][columna].setBackground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Prueba(30); // Puedes cambiar el tamaño aquí (10, 20, o 30)
            }
        });
    }
}