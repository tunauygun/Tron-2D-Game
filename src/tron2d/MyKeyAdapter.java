package tron2d;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Tuna Uygun
 */
public class MyKeyAdapter extends KeyAdapter {
    
    Player p1;
    Player p2;
    
    public MyKeyAdapter(Player plyr1, Player plyr2){
        p1 = plyr1;
        p2 = plyr2;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_LEFT) && (!p1.rightDirection)) {
            p1.leftDirection = true;
            p1.upDirection = false;
            p1.downDirection = false;
        }

        if ((key == KeyEvent.VK_RIGHT) && (!p1.leftDirection)) {
            p1.rightDirection = true;
            p1.upDirection = false;
            p1.downDirection = false;
        }

        if ((key == KeyEvent.VK_UP) && (!p1.downDirection)) {
            p1.upDirection = true;
            p1.rightDirection = false;
            p1.leftDirection = false;
        }

        if ((key == KeyEvent.VK_DOWN) && (!p1.upDirection)) {
            p1.downDirection = true;
            p1.rightDirection = false;
            p1.leftDirection = false;
        }
        
        if ((key == KeyEvent.VK_A) && (!p2.rightDirection)) {
            p2.leftDirection = true;
            p2.upDirection = false;
            p2.downDirection = false;
        }

        if ((key == KeyEvent.VK_D) && (!p2.leftDirection)) {
            p2.rightDirection = true;
            p2.upDirection = false;
            p2.downDirection = false;
        }

        if ((key == KeyEvent.VK_W) && (!p2.downDirection)) {
            p2.upDirection = true;
            p2.rightDirection = false;
            p2.leftDirection = false;
        }

        if ((key == KeyEvent.VK_S) && (!p2.upDirection)) {
            p2.downDirection = true;
            p2.rightDirection = false;
            p2.leftDirection = false;
        }
        if (key == KeyEvent.VK_ENTER) {
            GameBoard.start = true;
        }
    }
}
