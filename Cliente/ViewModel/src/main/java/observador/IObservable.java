/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observador;

/**
 *
 * @author salce
 */
public interface IObservable {

    public void actualizarTodos();

    public void agregarObservador(IObservadorPantalla observador);
}

