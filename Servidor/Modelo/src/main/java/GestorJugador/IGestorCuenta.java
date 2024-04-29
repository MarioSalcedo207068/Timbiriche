/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GestorJugador;

import Dominio.Player;
import java.awt.Color;
import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author PC
 */
public interface IGestorCuenta 
{
    public Player buildPlayer(String name, String color, String pathImage);
    public Player modifyName(Player player, String name);
    public Player modifyColor(Player player, String color);
    public Player modifyImage(Player player, String pathImage);
    public Player addToScore(Player player, int scoreToAdd);
    public Icon getPlayerIcon(Player player);
    public void addPlayer(Player player);
    public List<Player> getListPlayer();
    
}
