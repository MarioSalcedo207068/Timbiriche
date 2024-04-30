/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observador;

/**
 *
 * @author Daniel Alameda
 */
public interface IObservableEvento {

    public  void actualizarTodos(String evento);

    public void agregarObservador(IObservadorEvento observador);

    public void eliminarObservador(IObservadorEvento observador);

}
