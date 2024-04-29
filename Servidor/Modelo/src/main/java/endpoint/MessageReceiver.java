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
//import controlador.Controlador;
/**
 *
 * @author salce
 */
public class MessageReceiver {
    
private final static String EXCHANGE_NAME = "exchange-timbiriche";
    private final static String ROUTING_KEY = "model";
    private final static String QUEUE_NAME = "queue-model";
    private final static MessageSender SENDER = new MessageSender();

    public void iniciarConsumidor() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("root");
        factory.setPassword("1234");

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

            System.out.println(" [*] Esperando mensajes desde API Gateway. Para salir, presiona CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {

                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Recibido desde el servidor: '" + message + "'");
                // Implementa la lógica para procesar el mensaje aquí
                //new Controlador().procesarMensaje(message);

            };

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {

        }

    }

}