/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observador;

/**
 *
 * @author Daniel Alameda
 */
public interface IObservable {

    public void actualizarTodos(String mensajeBody);

    public void agregarObservador(IObservador observador);
}

