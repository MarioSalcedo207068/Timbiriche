/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salce
 */
public class Game {
    //Declarando instancia de juego
    private static Game instance;
    private List<Player> players=new ArrayList<Player>();
    private Board board;
    
    public void startGame(){};
    public void endGame(){};
    public void addPlayer(Player player){};
    public void leaveGame(){};

    /**
     * Constructor privado para evitar crear otra instancia fuera de la clase
     */
    private Game(){}
    
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
    
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
            
}