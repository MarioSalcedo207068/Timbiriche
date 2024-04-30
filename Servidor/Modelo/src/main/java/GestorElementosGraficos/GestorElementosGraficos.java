/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorElementosGraficos;

import Dominio.Box;
import Dominio.Dot;
import Dominio.Line;
import Dominio.Mensaje;
import Dominio.Player;
import gestor.Gestor;
import java.util.ArrayList;
import java.util.List;
import observador.IObservable;
import observador.IObservador;

/**
 *
 * @author salce
 */
public class GestorElementosGraficos implements IObservable{
    
    
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
    
    
        public List<Dot> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Dot> puntos) {
        this.puntos = puntos;
    }

    public List<Line> getLineas() {
        return lineas;
    }

    public void setLineas(List<Line> lineas) {
        this.lineas = lineas;
    }

    /*public void addLinea(Line linea) {
        this.lineas.add(linea);
        actualizarTodos();
    }*/

    public Double getDistanciaPuntos() {
        return distanciaPuntos;
    }

    public void setDistanciaPuntos(Double distanciaPuntos) {
        this.distanciaPuntos = distanciaPuntos;
    }

        public void vaciarPuntos() {
        this.puntoA = null;
        this.puntoB = null;
        actualizarTodos();
    }

    public void addLinea(Line linea) {
        if (!validarLineaExistente(linea)) {
            validarCuadrado(linea);
            this.lineas.add(linea);
            gestor.enviarEvento(new Mensaje("linea", linea));
        }
    }
    
    public void addCuadrado(Box cuadrado) {
        this.cuadrados.add(cuadrado);
        gestor.enviarEvento(new Mensaje("cuadrado", cuadrado));
    }
    
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
                        puntoDSup, puntoCSup, linea.getColor());
                addCuadrado(cuadrado);

            }
            if (validarLineaExistente(lineaInf)
                    && validarLineaExistente(lineaADSuperiorNegativo)
                    && validarLineaExistente(lineaBCInferiorNegativo)) {

                System.out.println("Cuadrado");
                Box cuadrado = new Box(linea.getStart(), linea.getEnd(),
                        puntoDInf, puntoCInf, linea.getColor());
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
                        puntoBSup, puntoCSup, linea.getColor());
                addCuadrado(cuadrado);

            }
            if (validarLineaExistente(lineaInf)
                    && validarLineaExistente(lineaABSuperiorNegativo)
                    && validarLineaExistente(lineaDCSuperiorNegativo)) {

                System.out.println("Cuadrado");
                Box cuadrado = new Box(linea.getStart(), linea.getEnd(),
                        puntoBInf, puntoCInf, linea.getColor());
                addCuadrado(cuadrado);
            }

        }
    }
    
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
        public boolean validarPunto(Dot puntoValidar) {
        for (Dot punto : getPuntos()) {
            if (puntoValidar.getX() >= punto.getX() - 10
                    && puntoValidar.getX() <= punto.getX() + 10
                    && puntoValidar.getY() >= punto.getY() - 10
                    && puntoValidar.getY() <= punto.getY() + 10) {
                if (puntoA == null) {
                    puntoA = punto;
                    actualizarTodos();
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
            private void calcularDistancia() {
        Dot puntoA = this.puntos.get(0);
        Dot puntoB = this.puntos.get(1);;
        Double distanciaX = Math.pow((puntoB.getX() - puntoA.getX()), 2);
        Double distanciaY = Math.pow((puntoB.getY() - puntoA.getY()), 2);
        this.distanciaPuntos = Math.sqrt(distanciaX + distanciaY);
        gestor.enviarEvento(new Mensaje("distancia", distanciaPuntos));
    }
        
            private boolean validarLinea() {
        Dot puntoA = this.puntoA;
        Dot puntoB = this.puntoB;

        Double distanciaX = Math.pow((puntoB.getX() - puntoA.getX()), 2);
        Double distanciaY = Math.pow((puntoB.getY() - puntoA.getY()), 2);
        Double distancia = Math.sqrt(distanciaX + distanciaY);
        if (distancia.equals(distanciaPuntos)) {

            Line linea = acomodarCordenadas(new Line(puntoA, puntoB));
            linea.setColor(jugadorPrincipal.getColor());
            this.gestor.enviarEvento(new Mensaje("linea", linea));
            return true;
        } else {
            return false;
        }
    }
            private Line acomodarCordenadas(Line linea) {
        int valorA = linea.getStart().getX() + linea.getStart().getY();
        int valorB = linea.getEnd().getX() + linea.getEnd().getY();
        if (valorA < valorB) {
            return new Line(puntoA, puntoB);
        } else {
            return new Line(puntoB, puntoA);
        }
    }
            
        public boolean validarLineaExistente(Line linea) {
        for (int i = 0; i < this.lineas.size(); i++) {
            if (lineas.get(i).equals(linea)) {
                return true;
            }
        }
        return false;
    }
        

    @Override
    public void actualizarTodos() {
        for (IObservador observadores : observadoresPantalla) {
            observadores.actualizar();
        }
    }

    @Override
    public void agregarObservador(IObservador observador) {
        this.observadoresPantalla.add(observador);
    }

    @Override
    public void eliminarObservador(IObservador observador) {
        this.observadoresPantalla.remove(observador);
    }
}