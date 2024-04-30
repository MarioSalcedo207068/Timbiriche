/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package endpoint;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.util.ArrayList;
import java.util.List;
import observador.IObservableEvento;
import observador.IObservadorEvento;

/**
 *
 * @author salce
 */
public class MessageReceiver implements IObservableEvento{
    
    private List<IObservadorEvento> observadores = new ArrayList<>();
    
    private final static String EXCHANGE_NAME = "exchange-jugadores";

    public void iniciarCOnsumidor() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("root");
        factory.setPassword("1234");

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
            String queueName = channel.queueDeclare().getQueue();

            channel.queueBind(queueName, EXCHANGE_NAME, "");

            System.out.println(" [*] Esperando mensajes. Para salir, presiona CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Recibido desde lado del Cliente: '" + message + "'");
                // Implementa la lógica para procesar el mensaje aquí
            };

            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
        }

    }

    @Override
    public void actualizarTodos(String evento) {
                for (IObservadorEvento observador : observadores) {
            observador.nuevoMensajeRecibido(evento);
        }
    }

    @Override
    public void agregarObservador(IObservadorEvento observador) {
                this.observadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObservadorEvento observador) {
        this.observadores.remove(observador);
    }

}