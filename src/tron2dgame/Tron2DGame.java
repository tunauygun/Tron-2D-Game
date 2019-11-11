/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron2dgame;

import java.awt.Color;

/**
 *
 * @author S347391269
 */
public class Tron2DGame {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainWindow Window = new MainWindow();
        Player player1 = new Player(1, Color.BLUE, "ARROWKEYS", "Player1 (Blue)");
        Player player2 = new Player(-1, Color.RED, "WASD", "Player2 (Red)");
        GameBoard Board = new GameBoard(player1,player2);
        Window.setupWindow(Board);
    }
    

    
}
