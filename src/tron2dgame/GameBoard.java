/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron2dgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author S347391269
 */
public class GameBoard extends JPanel {
    public static int gridSize = 10;
    public static int width = 510;
    public static int height = 510;
    
    Player p1;
    Player p2;
    
    public GameBoard(Player plyr1, Player plyr2){
        p1 = plyr1;
        p2 = plyr2;
        KeyListener listener1 = new MyKeyListener(p1);
        KeyListener listener2 = new MyKeyListener(p2);
	addKeyListener(listener1);
        addKeyListener(listener2);
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics g) {
        //super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(g2d);
        p1.drawPlayer(g2d);
        p2.drawPlayer(g2d);
        
        while (true) {
        //p1.drawPlayer(g2d);
        /*    try {           
                p1.updatePosition();
            } catch (InterruptedException ex) {
                System.out.println("Position Update loop error!");
            }*/
        }
        
        
        //p2.updatePosition();
    }
    
    private void drawGrid(Graphics2D g2d){
        g2d.setColor(Color.LIGHT_GRAY);
        for(int i = 0; i<=width; i+=gridSize){
            g2d.drawLine(i, 0, i, height);
        }
        for(int i = 0; i<=height; i+=gridSize){
            g2d.drawLine(0, i, width, i);
        }
    }
    
}
