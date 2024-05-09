package Pruebas;

import Dominio.Dot;
import Dominio.Box;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class PruebaJuego extends JFrame {

    private final int TAMANO;
    private JToggleButton[][] botones;
    private JPanel[][] lineasHorizontales;
    private JPanel[][] lineasVerticales;
    private JPanel[][] centros;
    private int botonesSeleccionados = 0;
    private JToggleButton botonAnterior = null;
    private Set<JPanel> cuadrosCompletos = new HashSet<>();

    public PruebaJuego(int tamano) {
        this.TAMANO = tamano;
        setTitle("Tablero de Timbiriche");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el arreglo bidimensional de botones, líneas y centros
        botones = new JToggleButton[TAMANO][TAMANO];
        lineasHorizontales = new JPanel[TAMANO - 1][TAMANO];
        lineasVerticales = new JPanel[TAMANO][TAMANO - 1];
        centros = new JPanel[TAMANO - 1][TAMANO - 1];

        // Crear el panel principal para contener los botones, líneas y centros
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Crear los paneles de los jugadores en los lados
        JPanel panelIzquierdo = new JPanel(new GridLayout(0, 1));
        JPanel panelDerecho = new JPanel(new GridLayout(0, 1));

        // Crear y agregar los botones al panel principal
        JPanel panelBotones = new JPanel(new GridLayout(TAMANO * 2, TAMANO * 2));
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
                                if (botonAnterior != null) {
                                    if (sonAdyacentes(botonAnterior, botonActual)) {
                                        conectarBotones(botonAnterior, botonActual, Color.YELLOW);
                                        botonesSeleccionados = 0;
                                    }
                                }
                                botonAnterior = botonActual;
                                botonesSeleccionados++;
                            }
                        } else {
                            botonesSeleccionados--;
                            if (botonAnterior == botonActual) {
                                botonAnterior = null;
                            }
                        }
                    }
                });
                panelBotones.add(botones[i][j]);

                if (j < TAMANO - 1) {
                    lineasVerticales[i][j] = new JPanel();
                    lineasVerticales[i][j].setVisible(false);
                    lineasVerticales[i][j].setPreferredSize(new Dimension(2, 20));
                    panelBotones.add(lineasVerticales[i][j]);
                }
            }
            if (i < TAMANO - 1) {
                for (int j = 0; j < TAMANO; j++) {
                    lineasHorizontales[i][j] = new JPanel();
                    lineasHorizontales[i][j].setVisible(false);
                    lineasHorizontales[i][j].setPreferredSize(new Dimension(20, 2));
                    panelBotones.add(lineasHorizontales[i][j]);
                    if (j < TAMANO - 1) {
                        centros[i][j] = new JPanel();
                        centros[i][j].setVisible(false);
                        centros[i][j].setPreferredSize(new Dimension(20, 20));
                        panelBotones.add(centros[i][j]);
                    }
                }
            }
        }

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Agregar los paneles de información de los jugadores a los lados del tablero
        for (int i = 0; i < 4; i++) {
            JPanel panelJugador = new JPanel(new BorderLayout());
            JLabel labelNombre = new JLabel(" Jugador " + (i + 1)); // Puedes cambiar esto por el nombre del jugador
            JLabel labelPuntuacion = new JLabel(" Puntuación: 0 "); // Aquí se mostraría la puntuación del jugador
            JLabel labelImagen = new JLabel(new ImageIcon("C:\\Users\\aroco\\Desktop\\Timbiriche\\Timbiriche\\Servidor\\ControladorTablero\\src\\main\\java\\img\\def avatar.jpg")); // Cambia la ruta de la imagen según tus necesidades
            JPanel panelInfo = new JPanel(new GridLayout(0, 1));
            panelInfo.add(labelNombre);
            panelInfo.add(labelPuntuacion);
            panelJugador.add(labelImagen, BorderLayout.CENTER);
            panelJugador.add(panelInfo, BorderLayout.EAST);

            if (i < 2) {
                panelIzquierdo.add(panelJugador);
            } else {
                panelDerecho.add(panelJugador);
            }
        }

        panelPrincipal.add(panelIzquierdo, BorderLayout.WEST);
        panelPrincipal.add(panelDerecho, BorderLayout.EAST);

        add(panelPrincipal);
        setVisible(true);
    }

    // Método para verificar si dos botones son adyacentes
    private boolean sonAdyacentes(JToggleButton boton1, JToggleButton boton2) {
        int fila1 = getBotonFila(boton1);
        int columna1 = getBotonColumna(boton1);
        int fila2 = getBotonFila(boton2);
        int columna2 = getBotonColumna(boton2);
        System.out.println(fila1);
        System.out.println(fila2);
        System.out.println(columna1);
        System.out.println(columna2);
        return (fila1 == fila2 && Math.abs(columna1 - columna2) == 1)
                || (columna1 == columna2 && Math.abs(fila1 - fila2) == 1);
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
        
// // Método para conectar dos botones con una línea
//    private void conectarBotones(JToggleButton boton1, JToggleButton boton2, Color color) {
//        int fila1 = getBotonFila(boton1);
//        int columna1 = getBotonColumna(boton1);
//        int fila2 = getBotonFila(boton2);
//        int columna2 = getBotonColumna(boton2);
//   
//        if (sonAdyacentes(boton1, boton2)) {
//            if (fila1 == fila2) {
//                // Están en la misma fila
//                int columnaInicio = Math.min(columna1, columna2);
//                lineasVerticales[fila1][columnaInicio].setVisible(true);
//                lineasVerticales[fila1][columnaInicio].setBackground(color);
//                verificarCuadroCompleto(boton1, boton2);
//            } else if (columna1 == columna2) {
//                // Están en la misma columna
//                int filaInicio = Math.min(fila1, fila2);
//                lineasHorizontales[filaInicio][columna1].setVisible(true);
//                lineasHorizontales[filaInicio][columna1].setBackground(color);
//                verificarCuadroCompleto(boton1, boton2);
//            }
//        }
    
    
 private void conectarBotones(JToggleButton boton1, JToggleButton boton2, Color color) {
        for (int i = 0; i < TAMANO - 1; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (botones[i][j] == boton1 && botones[i + 1][j] == boton2) {
                    lineasHorizontales[i][j].setBackground(color);
                    lineasHorizontales[i][j].setVisible(true);
                    verificarCuadroCompleto(boton1,boton2);
                    return;
                }
                if (botones[i][j] == boton2 && botones[i + 1][j] == boton1) {
                    lineasHorizontales[i][j].setBackground(color);
                    lineasHorizontales[i][j].setVisible(true);
                    verificarCuadroCompleto(boton1,boton2);
                    return;
                }
            }
        }

        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO - 1; j++) {
                if (botones[i][j] == boton1 && botones[i][j + 1] == boton2) {
                    lineasVerticales[i][j].setBackground(color);
                    lineasVerticales[i][j].setVisible(true);
                    verificarCuadroCompleto(boton1,boton2);
                    return;
                }
                if (botones[i][j] == boton2 && botones[i][j + 1] == boton1) {
                    lineasVerticales[i][j].setBackground(color);
                    lineasVerticales[i][j].setVisible(true);
                    verificarCuadroCompleto(boton1,boton2);
                    return;
                }
            }
        }
    }

private void verificarCuadroCompleto(JToggleButton boton1, JToggleButton boton2) {
        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;

        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (botones[i][j] == boton1) {
                    x1 = i;
                    y1 = j;
                } else if (botones[i][j] == boton2) {
                    x2 = i;
                    y2 = j;
                }
            }
        }

        if (x1 == x2) {
            // Verificar cuadro arriba y abajo
            if (x1 > 0) {
                if (lineasHorizontales[x1 - 1][Math.min(y1, y2)].isVisible() &&
                        lineasHorizontales[x1 - 1][Math.max(y1, y2)].isVisible() &&
                        lineasVerticales[x1 - 1][Math.min(y1, y2)].isVisible()) {
                                                                                centros[Math.min(x1, x2)][y1].setBackground(Color.YELLOW);
                    centros[x1 - 1][Math.min(y1, y2)].setVisible(true);
                    cuadrosCompletos.add(centros[x1 - 1][Math.min(y1, y2)]);
                }
            }
            if (x1 < TAMANO - 1) {
                if (lineasHorizontales[x1][Math.min(y1, y2)].isVisible() &&
                        lineasHorizontales[x1][Math.max(y1, y2)].isVisible() &&
                        lineasVerticales[x1][Math.min(y1, y2)].isVisible()) {
                                                                                centros[Math.min(x1, x2)][y1].setBackground(Color.YELLOW);

                    centros[x1][Math.min(y1, y2)].setVisible(true);
                    cuadrosCompletos.add(centros[x1][Math.min(y1, y2)]);
                }
            }
        } else if (y1 == y2) {
            // Verificar cuadro izquierda y derecha
            if (y1 > 0) {
                if (lineasVerticales[Math.min(x1, x2)][y1 - 1].isVisible() &&
                        lineasVerticales[Math.max(x1, x2)][y1 - 1].isVisible() &&
                        lineasHorizontales[Math.min(x1, x2)][y1 - 1].isVisible()) {
                                                            centros[Math.min(x1, x2)][y1].setBackground(Color.YELLOW);

                    centros[Math.min(x1, x2)][y1 - 1].setVisible(true);
                    cuadrosCompletos.add(centros[Math.min(x1, x2)][y1 - 1]);
                }
            }
            if (y1 < TAMANO - 1) {
                if (lineasVerticales[Math.min(x1, x2)][y1].isVisible() &&
                        lineasVerticales[Math.max(x1, x2)][y1].isVisible() &&
                        lineasHorizontales[Math.min(x1, x2)][y1].isVisible()) {
                                        centros[Math.min(x1, x2)][y1].setBackground(Color.YELLOW);

                    centros[Math.min(x1, x2)][y1].setVisible(true);
                    cuadrosCompletos.add(centros[Math.min(x1, x2)][y1]);
                }
            }
              Dot p1 = new Dot(x1 - 1, Math.min(y1, y2));
                Dot p2 = new Dot(x1 - 1, Math.max(y1, y2));
                Dot p3 = new Dot(x1, Math.min(y1, y2));
                Dot p4 = new Dot(x1, Math.max(y1, y2));
                Box box=new Box(p1, p2, p3, p4, "color"); // Asegúrate de establecer el color adecuadamente
                System.out.println(box);
        }
}


//  
//private void verificarCuadrosCompletos() {
//    boolean cuadroCompletado = false;
//    for (int i = 0; i < TAMANO - 1; i++) {
//        for (int j = 0; j < TAMANO - 1; j++) {
//            if (centros[i][j].isVisible()) continue;
//
//            if (lineasHorizontales[i][j].isVisible() && lineasHorizontales[i + 1][j].isVisible() &&
//                    lineasVerticales[i][j].isVisible() && lineasVerticales[i][j + 1].isVisible()) {
//                                centros[i][j].setBackground(Color.YELLOW);
//                centros[i][j].setVisible(true);
//                cuadrosCompletos.add(centros[i][j]);
//                cuadroCompletado = true;
//            }
//        }
//    }
//
//    if (cuadroCompletado) {
//        // Aquí puedes agregar la lógica para actualizar la puntuación de los jugadores
//        actualizarPuntuacion();
//    }
//}

//private void actualizarPuntuacion() {
//    // Lógica para actualizar la puntuación de los jugadores
//    // Por ejemplo, aquí puedes aumentar la puntuación del jugador activo
//}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PruebaJuego(4); // Puedes cambiar el tamaño aquí (10, 20, o 30)
            }
        });
    }
}
