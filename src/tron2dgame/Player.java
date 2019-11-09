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
import java.util.ArrayList;

/**
 *
 * @author S347391269
 */
public class Player {
    ArrayList<Integer> playerPoints;
    int playerX;
    int playerY;
    int playerId;
    
    public Player (int Id){
        playerId = Id;
    }
    
    
    public void paint(Graphics g) {
        //super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);
	drawPlayer(g);
    }

    private void drawPlayer(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        playerX = findCenterTile()[0] + this.playerId;
        playerY = findCenterTile()[1];
        g2d.fillRect(playerX, playerY, GameBoard.gridSize, GameBoard.gridSize);
    }
    
    private int[] findCenterTile(){
        int verticalCenter = (GameBoard.width/GameBoard.gridSize)/2;
        int horizontalCenter = (GameBoard.height/GameBoard.gridSize)/2;
        int[] centerTileCoorfinates = new int[] {(verticalCenter*GameBoard.gridSize),(horizontalCenter*GameBoard.gridSize)};
        return centerTileCoorfinates;
    } 
    
    
    
    
}
