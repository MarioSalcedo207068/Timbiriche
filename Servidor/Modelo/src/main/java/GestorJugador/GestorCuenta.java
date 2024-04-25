
package GestorJugador;

import Dominio.Player;
import java.awt.Color;
import javax.swing.Icon;



public class GestorCuenta implements IGestorCuenta
{
    
    @Override
    public Player buildPlayer(String name, Color color, String pathImage)
    {
        
        Player player = new Player( name,  color,  pathImage, 0);
        return player;
        
    }
    
    @Override
    public Player modifyName(Player player, String name)
    {
        player.setName(name);
        return player;
    }
    
    @Override
    public Player modifyColor(Player player, Color color)
    {
        player.setColor(color);
        return player;
    }
    
    
    @Override
    public Player modifyImage(Player player, String pathImage)
    {
        player.setPathImage(pathImage);
        return player;
    }
    
    
    @Override
    public Player addToScore(Player player, int scoreToAdd)
    {
        int currentScore = player.getScore();
        player.setScore(scoreToAdd + currentScore);
        return player;
    }
    
    public Icon getPlayerIcon(Player player)
    {
        return player.getIcon();
    }
    
}
