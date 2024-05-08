package GestorJugador;

import Dominio.Game;
import Dominio.Player;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import observador.IObservador;

/**
 * Clase para representar el gestor de cuentas dentro del proyecto Timbiriche.
 *
 * @author Equipo 01
 */

public class GestorCuenta implements IGestorCuenta {

    private List<IObservador> observadoresPantalla;
    private Player jugadorPrincipal;
    private Game game = Game.getInstance();

    List<Player> jugadores = new ArrayList<>();

    /**
     * Constructor con parámetros de la clase.
     *
     * @param name Objeto tipo cadena representando el nombre del jugador.
     * @param color Objeto tipo cadena representando el color del jugador.
     * @param pathImage Objeto tipo cadena representando el enlace a la imágen
     * del jugador.
     * @return Objeto tipo Player con la instancia de jugador creada en base a
     * la información proporcionada.
     */
    @Override
    public Player buildPlayer(String name, String color, String pathImage) {

        Player player = new Player(name, color, pathImage, 0);
        return player;

    }

    /**
     * Método para modificar el atributo del nombre del jugador.
     *
     * @param player Objeto tipo Player el cual será modificado.
     * @param name Objeto tipo cadena con el nuevo nombre del jugador.
     * @return Objeto tipo Player con el jugador entrante actualizado.
     */
    @Override
    public Player modifyName(Player player, String name) {
        player.setName(name);
        return player;
    }

    /**
     * Método para modificar el atributo del color del jugador.
     *
     * @param player Objeto tipo Player el cual será modificado.
     * @param color Objeto tipo cadena con el nuevo color del jugador.
     * @return Objeto tipo Player con el jugador entrante actualizado.
     */
    @Override
    public Player modifyColor(Player player, String color) {
        player.setColor(color);
        return player;
    }

    /**
     * Método para modificar el enlace a la imágen del nombre del jugador.
     *
     * @param player Objeto tipo Player el cual será modificado.
     * @param pathImage Objeto tipo cadena con el nuevo enlace a la imágen del
     * jugador.
     * @return Objeto tipo Player con el jugador entrante actualizado.
     */
    @Override
    public Player modifyImage(Player player, String pathImage) {
        player.setPathImage(pathImage);
        return player;
    }

    /**
     * Método para añadir una cantidad fija a la puntuación establecida del
     * jugador proporcionado.
     *
     * @param player Objeto tipo Player el cual será modificado.
     * @param scoreToAdd Cadena con la cantidad de puntuación a añadir.
     * @return Objeto tipo Player con el jugador entrante actualizado.
     */
    @Override
    public Player addToScore(Player player, int scoreToAdd) {
        int currentScore = player.getScore();
        player.setScore(scoreToAdd + currentScore);
        return player;
    }

    /**
     * Método que regresará el ícono establecido para el jugador entrante.
     *
     * @param player Objeto tipo Player con la información del ícono a extraer.
     * @return Objeto tipo Icon del jugador entrante.
     */
    @Override
    public Icon getPlayerIcon(Player player) {
        return player.getIcon();
    }

    /**
     * Método para agregar un jugador a la entidad Game.
     *
     * @param player Objeto tipo Player el cual será añadido a la lista de
     * jugadores.
     */
    @Override
    public void addPlayer(Player player) {
        game.addPlayer(player);
    }

    /**
     * Método para regresar la lista de jugadores activos en el juego.
     *
     * @return Lista tipo Player con todos los jugadores que han sido
     * registrados.
     */
    @Override
    public List<Player> getListPlayer() {
        return game.getPlayers();
    }

    /**
     * Método para obtener el jugador asignado como principal.
     *
     * @return Objeto tipo Player el cual fue designado como el principal.
     */
    public Player getJugadorPrincipal() {
        return jugadorPrincipal;
    }

    /**
     * Método para establecer al jugador principal para la entidad Game.
     *
     * @param jugadorPrincipal Objeto tipo Player el cual será el principal
     * dentro del juego.
     */
    public void setJugadorPrincipal(Player jugadorPrincipal) {
        this.jugadorPrincipal = jugadorPrincipal;
    }

    /*public void iniciarJugador() {
        try {
            recibirEvento.recibirEvento();
        } catch (IOException ex) {
            Logger.getLogger(ProcesarEvento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(ProcesarEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    //agregado para configuracion
    /* public void setColorJugador(String color, int jugador) {
        List<Player> listaDeJugadores = tableroData.getJugadores();
        Player jugadorActual = listaDeJugadores.get(jugador);
        jugadorActual.setColor(color);
    }*/
}
