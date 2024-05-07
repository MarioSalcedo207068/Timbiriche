/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package endpoint;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para representar el emisor de mensajes dentro del proyecto Timbiriche.
 * @author Equipo 01
 */
public class MessageSender {
    
    private final static String EXCHANGE_NAME = "exchange-jugadores";
        
    /**
     * Método constructor base de la clase.
     */
    public MessageSender() {
    }

    /**
     * Método con el cual se enviarán los mensajes de todo tipo.
     * @param mensaje Objeto tipo Cadena con el mensaje a enviar.
     */
    public void enviarMensaje(String mensaje) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("root");
        factory.setPassword("1234");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
            channel.basicPublish(EXCHANGE_NAME, "", null, mensaje.getBytes());
            System.out.println(" [x] Enviado desde Servidor: '" + mensaje + "'");
        } catch (IOException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}