
package Dominio;

import com.google.gson.annotations.SerializedName;

/**
 * Clase para representar los mensajes usados para la comunicación entre proyectos para el proyecto Timbiriche.
 * @author Equipo 01
 */
public class Mensaje {
    @SerializedName("tipo")
    private String tipo;
    @SerializedName("objeto")
    private Object object;
    @SerializedName("distinatario")
    private String distinatario = "jugadores";
    
    /**
     * Método constructor base de la clase.
     */  
    public Mensaje() {
    }

    /**
     * Método constructor con parámetros de la clase. 
     * @param tipo Cadena con el tipo de mensaje que se mandará. 
     * @param object Objeto con el contenido del mensaje.
     */
    public Mensaje(String tipo, Object object) {
        this.tipo = tipo;
        this.object = object;
    }

    /**
     * Método para obtener el tipo de mensaje que conforma el mensaje. 
     * @return Cadena con el tipo de mensaje.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método para establecer el tipo de mensaje que se mandará.
     * @param tipo Cadena con el tipo de mensaje.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

     /**
     * Método para obtener el objeto que conforma el mensaje. 
     * @return Objeto que tiene el mensaje.
     */   
    public Object getObject() {
        return object;
    }

    /**
     * Método para establecer el objeto que conforma el mensaje. 
     * @param object Objeto que se mandará el mensaje.
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * Método para obtener el destinatario del mensaje. 
     * @return Cadena con el destinatario.
     */
    public String getDistinatario() {
        return distinatario;
    }
    
    

}