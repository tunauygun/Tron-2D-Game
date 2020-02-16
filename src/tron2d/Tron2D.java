package tron2d;

/**
 *
 * @author Tuna Uygun
 */
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Tron2D extends JFrame {    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame GameWindow = new Tron2D();      
            Player p1 = new Player(GameBoard.boardWidth/2 + GameBoard.gridSize, GameBoard.boardHeight/2);
            Player p2 = new Player(GameBoard.boardWidth/2 - GameBoard.gridSize, GameBoard.boardHeight/2);
            GameBoard board = new GameBoard(p1, p2);
            GameWindow.add(board);
            GameWindow.setResizable(false);
            GameWindow.pack();
            GameWindow.setVisible(true);
            GameWindow.setTitle("Tron");
            GameWindow.setLocationRelativeTo(null);
            GameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
