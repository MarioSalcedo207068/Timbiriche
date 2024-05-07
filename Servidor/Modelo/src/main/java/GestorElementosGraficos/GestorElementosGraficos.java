/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorElementosGraficos;

import Dominio.Box;
import Dominio.Dot;
import Dominio.Line;
import Dominio.Player;
import formato.Mensaje;
import gestor.Gestor;
import java.util.ArrayList;
import java.util.List;
import observador.IObservador;

/**
 * Clase para representar el gestor de elementos gráficos dentro del proyecto
 * Timbiriche.
 * @author Equipo 01
 */

public class GestorElementosGraficos {
    
<<<<<<< HEAD
    

    List<Line> lineas = new ArrayList<>();
    List<Box> cuadrados = new ArrayList<>();
    //ProcesarEvento evento = new ProcesarEvento(this);
    gestor.Gestor gestor = new Gestor();
    List<Player> jugadores = new ArrayList<>();
    Double distanciaPuntos;
    private List<Dot> puntos;
    private Dot puntoA;
    private Dot puntoB;
    private Player jugadorPrincipal;
    private List<IObservador> observadoresPantalla;

    /**
     * Método para obtener los puntos almacenados en la lista de puntos.
     *
     * @return Lista tipo Dot con todos los puntos almacenados.
     */
    public List<Dot> getPuntos() {
        return puntos;
    }

    /**
     * Método para ingresar una lista de puntos, actualizando la lista de puntos
     * almacenados.
     *
     * @param puntos Lista tipo Dot con la información de los puntos entrantes.
     */
    public void setPuntos(List<Dot> puntos) {
        this.puntos = puntos;
    }

    /**
     * Método para obtener las líneas almacenadas en la lista de líneas.
     *
     * @return Lista tipo Line con todas las líneas almacenadas.
     */
    public List<Line> getLineas() {
        return lineas;
=======
    private Dot puntoA;
    private Dot puntoB;
    Double distanciaPuntos;
    //Agregado
    private Game game = Game.getInstance();
    //Agregado último
    
        public List<Line> getLineas() {
        return this.game.getBoard().getLines();
>>>>>>> d5e76cb (ajustes v2)
    }

    /**
     * Método para ingresar una lista de líneas, actualizando la lista de líneas
     * almacenadas.
     *
     * @param lineas Lista tipo Line con la información de las líneas entrantes.
     */
    public void setLineas(List<Line> lineas) {
        this.game.getBoard().setLines(lineas);
    }
    
        public List<Dot> getPuntos() {
        return this.game.getBoard().getDots();
    }

    public void setPuntos(List<Dot> puntos) {
        this.game.getBoard().setDots(puntos);
    }

    public List<Box> getBox() {
        return this.game.getBoard().getBoxes();
    }

    public void setBox(List<Box> cuadrados) {
        this.game.getBoard().setBoxes(cuadrados);
    }

    /*public void addLinea(Line linea) {
        this.lineas.add(linea);
        actualizarTodos();
    }*/
    /**
     * Método que regresará la distancia entre dos puntos previamente
     * establecidos.
     *
     * @return Double con la información exacta de la distancia.
     */
    public Double getDistanciaPuntos() {
        return distanciaPuntos;
    }

    /**
     * Método para ingresar la distancia entre dos puntos específicos.
     *
     * @param distanciaPuntos Objeto tipo Double el cual representa
     */
    public void setDistanciaPuntos(Double distanciaPuntos) {
        this.distanciaPuntos = distanciaPuntos;
    }

    /**
     * Método para establecer los dos puntos (A y B) en nulo.
     */
    public void vaciarPuntos() {
        this.puntoA = null;
        this.puntoB = null;
        //actualizarTodos();
    }

    /**
     * Método para validar y añadir una línea a la lista de líneas del objeto.
     * @param linea Objeto tipo Line el cual será validado y posteriormente agregado.
     */
    public void addLinea(Line linea) {
        if (!validarLineaExistente(linea)) {
            validarCuadrado(linea);
            this.game.getBoard().addLine(linea);
            //gestor.enviarEvento(new Mensaje("linea", linea));
        }
    }

    /**
     * Método para añadir un cuadrado a la lista de cuadrados del objeto.
     * @param cuadrado Objeto tipo Box el cual será agregado.
     */
    public void addCuadrado(Box cuadrado) {
        this.game.getBoard().addBox(cuadrado);
        //gestor.enviarEvento(new Mensaje("cuadrado", cuadrado));
    }
<<<<<<< HEAD

    /**
     * Método para validar un cuadrado en base a una línea entrante. 
     * @param linea Objeto tipo Line el cual estará siendo validado constantemente.
     */
=======
    
//Agregado
    public void addDot(Dot punto){
        if(!validarPunto(punto)){
            validarPunto(punto);
            this.game.getBoard().addDot(punto);
        }
    }
    
>>>>>>> d5e76cb (ajustes v2)
    public void validarCuadrado(Line linea) {
        Dot puntoCSup;
        Dot puntoDSup;
        Dot puntoCInf;
        Dot puntoDInf;
        Line lineaSup = null;
        Line lineaInf;
        Line lineaADSuperiorPositivo;
        Line lineaADSuperiorNegativo;
        Line lineaBCInferiorPositivo;
        Line lineaBCInferiorNegativo;

        Dot puntoBSup;
        Dot puntoBInf;
        Line lineaABSuperiorPositivo;
        Line lineaABSuperiorNegativo;
        Line lineaDCSuperiorPositivo;
        Line lineaDCSuperiorNegativo;

        if (linea.getStart().getX() == linea.getEnd().getX()) {

            puntoDSup = new Dot((int) (linea.getStart().getX() + distanciaPuntos),
                    linea.getStart().getY());
            puntoDInf = new Dot((int) (linea.getStart().getX() - distanciaPuntos),
                    linea.getStart().getY());
            puntoCSup = new Dot((int) (linea.getEnd().getX() + distanciaPuntos),
                    linea.getEnd().getY());
            puntoCInf = new Dot((int) (linea.getEnd().getX() - distanciaPuntos),
                    linea.getEnd().getY());
            lineaSup = new Line(puntoDSup, puntoCSup);
            lineaADSuperiorPositivo = new Line(linea.getStart(), lineaSup.getStart());
            lineaBCInferiorPositivo = new Line(linea.getEnd(), lineaSup.getEnd());
            lineaInf = new Line(puntoDInf, puntoCInf);
            lineaADSuperiorNegativo = new Line(lineaInf.getStart(), linea.getStart());
            lineaBCInferiorNegativo = new Line(lineaInf.getEnd(), linea.getEnd());

            if (validarLineaExistente(lineaSup)
                    && validarLineaExistente(lineaADSuperiorPositivo)
                    && validarLineaExistente(lineaBCInferiorPositivo)) {

                System.out.println("Cuadrado");
                Box cuadrado = new Box(linea.getStart(), linea.getEnd(),
                        puntoDSup, puntoCSup, linea.getColor().toString());
                addCuadrado(cuadrado);

            }
            if (validarLineaExistente(lineaInf)
                    && validarLineaExistente(lineaADSuperiorNegativo)
                    && validarLineaExistente(lineaBCInferiorNegativo)) {

                System.out.println("Cuadrado");
                Box cuadrado = new Box(linea.getStart(), linea.getEnd(),
                        puntoDInf, puntoCInf, linea.getColor().toString());
                addCuadrado(cuadrado);

            }

        } else if (linea.getStart().getY() == linea.getEnd().getY()) {
            puntoBSup = new Dot(linea.getStart().getX(),
                    (int) (linea.getStart().getY() + distanciaPuntos));
            puntoBInf = new Dot(linea.getStart().getX(),
                    (int) (linea.getStart().getY() - distanciaPuntos));
            puntoCSup = new Dot(linea.getEnd().getX(),
                    (int) (linea.getEnd().getY() + distanciaPuntos));
            puntoCInf = new Dot(linea.getEnd().getX(),
                    (int) (linea.getEnd().getY() - distanciaPuntos));
            lineaSup = new Line(puntoBSup, puntoCSup);
            lineaInf = new Line(puntoBInf, puntoCInf);
            lineaABSuperiorPositivo = new Line(linea.getStart(), lineaSup.getStart());
            lineaABSuperiorNegativo = new Line(lineaInf.getStart(), linea.getStart());
            lineaDCSuperiorPositivo = new Line(linea.getEnd(), lineaSup.getEnd());
            lineaDCSuperiorNegativo = new Line(lineaInf.getEnd(), linea.getEnd());

            if (validarLineaExistente(lineaSup)
                    && validarLineaExistente(lineaABSuperiorPositivo)
                    && validarLineaExistente(lineaDCSuperiorPositivo)) {

                System.out.println("Cuadrado");
                Box cuadrado = new Box(linea.getStart(), linea.getEnd(),
                        puntoBSup, puntoCSup, linea.getColor().toString());
                addCuadrado(cuadrado);

            }
            if (validarLineaExistente(lineaInf)
                    && validarLineaExistente(lineaABSuperiorNegativo)
                    && validarLineaExistente(lineaDCSuperiorNegativo)) {

                System.out.println("Cuadrado");
                Box cuadrado = new Box(linea.getStart(), linea.getEnd(),
                        puntoBInf, puntoCInf, linea.getColor().toString());
                addCuadrado(cuadrado);
            }

        }
    }

    /**
     * Método para calcular e insertar los puntos totales a desplegar en el tablero.
     * @param cantidadPuntos Objeto entero con la cantidad de puntos en el tablero.
     * @param anchoTablero Objeto entero con el número de anchura en el tablero.
     * @param altoTablero Objeto entero con el número de altura en el tablero.
     * @return Lista de tipo Dot con todos los puntos a desplegar. 
     */
    public List<Dot> calcularPuntosTablero(int cantidadPuntos, int anchoTablero, int altoTablero) {
        List<Dot> puntos = new ArrayList<>();
        int espacioAltura = altoTablero / cantidadPuntos;
        int espacioAncho = anchoTablero / cantidadPuntos;

        for (int i = (espacioAltura / 2); i <= altoTablero - (espacioAltura / 2); i += espacioAltura) {
            for (int j = (espacioAncho / 2); j <= anchoTablero - (espacioAncho / 2); j += espacioAncho) {
                puntos.add(new Dot(j, i));
            }

        }
        return puntos;
    }
<<<<<<< HEAD

    /**
     * Método para validar un punto específico insertado.
     * @param puntoValidar Objeto tipo Dot el cual será validado.
     * @return Boolean con la respuesta de la validación.
     */
    public boolean validarPunto(Dot puntoValidar) {
=======
        
        public boolean validarPunto(Dot puntoValidar) {
>>>>>>> d5e76cb (ajustes v2)
        for (Dot punto : getPuntos()) {
            if (puntoValidar.getX() >= punto.getX() - 10
                    && puntoValidar.getX() <= punto.getX() + 10
                    && puntoValidar.getY() >= punto.getY() - 10
                    && puntoValidar.getY() <= punto.getY() + 10) {
                if (puntoA == null) {
                    puntoA = punto;
                    //actualizarTodos();
                } else if (puntoB == null) {

                    puntoB = punto;

                    validarLinea();
                    vaciarPuntos();
                }
                return true;
            }
        }
        return false;
    }
<<<<<<< HEAD

    /**
     * Método para calcular la distancia entre los puntos del objeto.
     */
    private void calcularDistancia() {
        Dot puntoA = this.puntos.get(0);
        Dot puntoB = this.puntos.get(1);;
=======
            private void calcularDistancia() {
        Dot puntoA = this.game.getBoard().getDots().get(0);
        Dot puntoB = this.game.getBoard().getDots().get(1);;
>>>>>>> d5e76cb (ajustes v2)
        Double distanciaX = Math.pow((puntoB.getX() - puntoA.getX()), 2);
        Double distanciaY = Math.pow((puntoB.getY() - puntoA.getY()), 2);
        this.distanciaPuntos = Math.sqrt(distanciaX + distanciaY);
        //gestor.enviarEvento(new Mensaje("distancia", distanciaPuntos));
    }

    /**
     * Método para validar la línea en base a los puntos del objeto.
     * @return Boolean con la respuesta de la validación.
     */
    private boolean validarLinea() {
        Dot puntoA = this.puntoA;
        Dot puntoB = this.puntoB;

        Double distanciaX = Math.pow((puntoB.getX() - puntoA.getX()), 2);
        Double distanciaY = Math.pow((puntoB.getY() - puntoA.getY()), 2);
        Double distancia = Math.sqrt(distanciaX + distanciaY);
        if (distancia.equals(distanciaPuntos)) {

            Line linea = acomodarCordenadas(new Line(puntoA, puntoB));
<<<<<<< HEAD
            linea.setColor(jugadorPrincipal.getColor());
=======
            //linea.setColor(jugadorPrincipal.getColor().toString());
>>>>>>> d5e76cb (ajustes v2)
            //this.gestor.enviarEvento(new Mensaje("linea", linea));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para reacomodar las coordenadas en base a sus ejes. 
     * @param linea Objeto tipo Line el cual será reacomodado.
     * @return Objeto tipo Line con los datos de posición correctos.
     */
    private Line acomodarCordenadas(Line linea) {
        int valorA = linea.getStart().getX() + linea.getStart().getY();
        int valorB = linea.getEnd().getX() + linea.getEnd().getY();
        if (valorA < valorB) {
            return new Line(puntoA, puntoB);
        } else {
            return new Line(puntoB, puntoA);
        }
    }
<<<<<<< HEAD

    /**
     * Método para validar si la línea entrante está dentro de la lista de líneas.
     * @param linea Objeto tipo Line el cual será comparado con la lista existente.
     * @return Boolean con la respuesta de la validación.
     */
    public boolean validarLineaExistente(Line linea) {
        for (int i = 0; i < this.lineas.size(); i++) {
            if (lineas.get(i).equals(linea)) {
=======
            
        public boolean validarLineaExistente(Line linea) {
        for (int i = 0; i < this.game.getBoard().getLines().size(); i++) {
            if (game.getBoard().getLines().get(i).equals(linea)) {
>>>>>>> d5e76cb (ajustes v2)
                return true;
            }
        }
        return false;
    }

}





<<<<<<< HEAD
=======
    public void dibujarCuadrados(Graphics g, List<Box> cuadrados, int lado) {
        if (cuadrados != null) {
            for (int i = 0; i < cuadrados.size(); i++) {
                //g.setColor(cuadrados.get(i).getColor());
                g.setColor(game.getPlayers().get(i).getColor());
                g.fillRect(cuadrados.get(i).getPointA().getX(),
                        cuadrados.get(i).getPointA().getY(),
                        lado + 10, lado + 10);
            }
        }
    }
}
>>>>>>> d5e76cb (ajustes v2)
