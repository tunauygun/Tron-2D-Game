package tron2d;

/**
 *
 * @author Tuna Uygun
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements ActionListener {

    public static int boardWidth = 500;
    public static int boardHeight = 500;
    public static int gridSize = 10;
    public static int delay = 125;
    public static boolean start = false;

    private Timer timer;
    public Player p1;
    public Player p2;
    

    public GameBoard(Player ply1, Player ply2) {
        p1 = ply1;
        p2 = ply2;
        initBoard();
    }
    
    private void initBoard() {
        addKeyListener(new MyKeyAdapter(p1,p2));
        setBackground(Color.WHITE);
        setFocusable(true);
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        if (!start){
            gameDescription(g);
        }else if (p1.alive && p2.alive) {
            setBackground(Color.WHITE);
            drawGrid(g);
            for (int z = 0; z < p1.length; z++) {      
                    g.setColor(Color.RED);
                    g.fillRect(p1.playerPointsX[z], p1.playerPointsY[z], gridSize,gridSize);
                    g.setColor(Color.BLUE);
                    g.fillRect(p2.playerPointsX[z], p2.playerPointsY[z], gridSize,gridSize);
            }
            Toolkit.getDefaultToolkit().sync();
        } else {
            timer.stop();
            gameOver(g);
        }        
    }

    private void gameDescription(Graphics g){
        setBackground(Color.getHSBColor(150, 40, 60));
        
        String title = "Welcome to Tron2D Game";
        Font titleFont = new Font("Helvetica", Font.BOLD, 25);
        FontMetrics metrTitle = getFontMetrics(titleFont);
        Font descFont = new Font("Helvetica", Font.PLAIN, 12);
        FontMetrics metrDesc = getFontMetrics(descFont);

        String Desc2 = "Each player controls a snake and tries to avoid crashing.";
        String Desc1 = "This game is played with 2 players.";
        String Desc3 = "The first player to crash loses the game.";
        String Desc4 = "The red snake is controled with arrow keys.";
        String Desc5 = "The blue snake is controlled with the wasd keys.";
        String Desc6 = "Press ENTER to start.";
        
        g.setColor(Color.white);
        g.setFont(titleFont);
        g.drawString(title, (boardWidth - metrTitle.stringWidth(title)) / 2, boardHeight / 2);
        
        g.setFont(descFont);
        g.drawString(Desc1, (boardWidth - metrDesc.stringWidth(Desc1)) / 2, boardHeight / 2 + 30);
        g.drawString(Desc2, (boardWidth - metrDesc.stringWidth(Desc2)) / 2, boardHeight / 2 + 45);
        g.drawString(Desc3, (boardWidth - metrDesc.stringWidth(Desc3)) / 2, boardHeight / 2 + 60);
        g.drawString(Desc4, (boardWidth - metrDesc.stringWidth(Desc4)) / 2, boardHeight / 2 + 75);
        g.drawString(Desc5, (boardWidth - metrDesc.stringWidth(Desc5)) / 2, boardHeight / 2 + 90);
        g.drawString(Desc6, (boardWidth - metrDesc.stringWidth(Desc6)) / 2, boardHeight / 2 + 115);
    }
    
    private void gameOver(Graphics g) {
        String msg;
        if(p1.alive){
            msg = "Red Player Wins!";
            setBackground(Color.RED);
        }else{
            msg = "Blue Player Wins!";
            setBackground(Color.BLUE);
        }
        
        Font winnerFont = new Font("Helvetica", Font.BOLD, 30);
        FontMetrics metr = getFontMetrics(winnerFont);

        g.setColor(Color.white);
        g.setFont(winnerFont);
        g.drawString(msg, (boardWidth - metr.stringWidth(msg)) / 2, boardHeight / 2);
    }  
    
    private void drawGrid(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        for(int i = 0; i<=boardWidth; i+=gridSize){
            g.drawLine(i, 0, i, boardHeight);
        }
        for(int i = 0; i<=boardHeight; i+=gridSize){
            g.drawLine(0, i, boardWidth, i);
        }
    }
    
    public void checkExternalCollisions(){
        for (int i = p1.length-2; i > 0; i--) {
            if ((i > 4) && (p1.playerPointsX[p1.length-1] == p2.playerPointsX[i]) && (p1.playerPointsY[p1.length-1] == p2.playerPointsY[i])) {
                p1.alive = false;
                System.out.println("P1 crashed into p2.");
            }
            if ((i > 4) && (p2.playerPointsX[p2.length-1] == p1.playerPointsX[i]) && (p2.playerPointsY[p2.length-1] == p1.playerPointsY[i])) {
                p2.alive = false;
                System.out.println("P2 crashed into p1.");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (p1.alive && p2.alive && start) {
            p1.checkInternalCollision();
            p2.checkInternalCollision();
            checkExternalCollisions();
            p1.move();
            p2.move();
        }
        repaint();
    }
    
}
