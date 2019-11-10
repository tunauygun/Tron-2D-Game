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
    Color color;
    
    public Player (int Id, Color c){
        playerId = Id;
        color = c;
    }
    
    public void drawPlayer(Graphics g) {
        Graphics2D p2D = (Graphics2D) g;
        p2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        p2D.setColor(color);
        playerX = findCenterTile()[0] + playerId*GameBoard.gridSize;
        playerY = findCenterTile()[1];
        p2D.fillRect(playerX, playerY, GameBoard.gridSize, GameBoard.gridSize);
    }
    
    private int[] findCenterTile(){
        int verticalCenter = (GameBoard.width/GameBoard.gridSize)/2;
        int horizontalCenter = (GameBoard.height/GameBoard.gridSize)/2;
        int[] centerTileCoorfinates = new int[] {(verticalCenter*GameBoard.gridSize),(horizontalCenter*GameBoard.gridSize)};
        return centerTileCoorfinates;
    } 
    
    
    
    
}
