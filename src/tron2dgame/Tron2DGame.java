/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron2dgame;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author S347391269
 */
public class Tron2DGame {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MainWindow GameWindow = new MainWindow("Tron", 900, 700);
        GameWindow.setupWindow();
        GameBoard Board = new GameBoard(5, GameWindow.width, GameWindow.height);
        GameWindow.runGameBoard(Board);
    }
    
}
