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
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 *
 * @author S347391269
 */
public class GameBoard extends JPanel{
    int gridSize;
    int width;
    int height;

    public GameBoard(int size, int w, int h){
        gridSize = size;
        width = w;
        height = h;
    }
    
    @Override
    public void paint(Graphics g) {
        //super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(this.gridSize, this.gridSize, 30, 30);
	//drawGrid(g);
    }
    
    public void drawGrid(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        for(int i = 0; i<this.width/this.gridSize; i+=this.gridSize){
            g2d.drawLine(i, 0, i, this.width);
        }
    }
}
