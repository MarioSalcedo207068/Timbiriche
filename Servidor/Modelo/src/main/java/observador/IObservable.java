/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observador;

/**
 *
 * @author salce
 */
public interface IObservable {

    public void actualizarTodos(String mensajeBody);

    public void agregarObservador(IObservador observador);

}
