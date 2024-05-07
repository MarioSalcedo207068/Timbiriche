/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

/**
 * Interfaz que será heredada por los observables dentro del proyecto Timbiriche.
 * @author Equipo 01
 */
public interface IObservable {

    public void actualizarTodos(String mensajeBody);

    public void agregarObservador(IObservador observador);

}
