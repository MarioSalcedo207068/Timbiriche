
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para representar el juego dentro del proyecto Timbiriche.
 * @author Equipo 01
 */
public class Game {
    //Declarando instancia de juego
    private static Game instance;
    private List<Player> players=new ArrayList<Player>();
    private Board board;
    //agregado
    //private Line line;
    //private Box box;
    
    public void startGame(){}
    
    public void endGame(){}
    
    public void addPlayer(Player player){
    this.addPlayer(player);
    }
    public void leaveGame(){}

    /**
     * Constructor privado para evitar crear otra instancia fuera de la clase.
     */
    private Game(){
        this.board=new Board();
    }
    
    /**
     * Implementación Singleton
     * @return instance de Game
     */
    public static Game getInstance(){
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
    
    /**
     * Método para obtener la lista de jugadores que conforman el juego.
     * @return Objeto Lista de tipo Player con los jugadores activos.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Método para establecer la lista de jugadores dentro del juego.
     * @param players Objeto Lista de tipo Player con los jugadores a insertar.
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    public void setBoard(Board board) {
        this.board = board;
    }
    //agregado
//        public void setLine(Line line) {
//        this.line = line;
//    }
//        public void setBox(Box box){
//        this.box = box;
//        }

    public Board getBoard() {
        return board;
    }
        
}