/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron2dgame;

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
        MainWindow Window = new MainWindow();
        GameBoard Board = new GameBoard();
        Player player1 = new Player(1);
        Window.setupWindow(Board);
    }
    
}
