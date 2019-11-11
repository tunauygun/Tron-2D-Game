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
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author S347391269
 */
public class Player{
    int playerX;
    int playerY;
    int playerId;
    String playerName;
    Color color;
    String controlMethod;
    String direction = "DOWN";
    Boolean gameOver = false;
    ArrayList<int[]> playerLocations = new ArrayList<int[]>();
    
    public Player (int Id, Color c, String cont, String pn){
        playerId = Id;
        color = c;
        controlMethod = cont;
        playerName = pn;
    }
    
    public void drawPlayer(Graphics g) {
        Graphics2D p2D = (Graphics2D) g;
        p2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        p2D.setColor(color);
        playerX = findCenterTile()[0] + playerId*GameBoard.gridSize;
        playerY = findCenterTile()[1];
        p2D.fillRect(playerX, playerY, GameBoard.gridSize, GameBoard.gridSize);
        addNewLocation(playerX,playerY);
        
    }
    
    private int[] findCenterTile(){
        int verticalCenter = (GameBoard.width/GameBoard.gridSize)/2;
        int horizontalCenter = (GameBoard.height/GameBoard.gridSize)/2;
        int[] centerTileCoorfinates = new int[] {(verticalCenter*GameBoard.gridSize),(horizontalCenter*GameBoard.gridSize)};
        return centerTileCoorfinates;
    }
    
    public void updatePosition() throws InterruptedException{
        switch (direction) {
            case "UP":
                moveUp();
                break;
            case "DOWN":
                moveDown();
                break;
            case "RIGHT":
                moveRight();
                break;
            case "LEFT":
                playerX+=10;
                //moveLeft();
                break;
            default:
                System.out.println("Invalid Direction Value");
                break;
        }
    } 
    
    public boolean checkGameOver(int newX, int newY){
        int[] newLocation = {newX,newY};
        for(int[]location: playerLocations){
            if (Arrays.equals(location, newLocation)){
                gameOver = true;
                return true;
            }            
        }
        return false;
        }
    
    public void addNewLocation(int newX, int newY){
        int[] newLocation = {newX,newY};
        playerLocations.add(newLocation);
    }
    
    public void moveUp() throws InterruptedException{
        if(checkGameOver(playerX, playerY - GameBoard.gridSize)) {
            System.out.println(playerName+ " Lost The Game!");
        } else {
            playerY = playerY - GameBoard.gridSize;
           // Thread.sleep(10);
        }
    }
    
    public void moveDown() throws InterruptedException{
        if(checkGameOver(playerX, playerY + GameBoard.gridSize)) {
            System.out.println(playerName+ " Lost The Game!");
        } else {
            playerY = playerY + GameBoard.gridSize;
           // Thread.sleep(10);
        }
    }

    public void moveLeft() throws InterruptedException{
        if(checkGameOver(playerX - GameBoard.gridSize, playerY)) {
            System.out.println(playerName+ " Lost The Game!");
        } else {
            playerX = playerX - GameBoard.gridSize;
           // Thread.sleep(10);
        }
    }
    
    public void moveRight() throws InterruptedException{
        if(checkGameOver(playerX + GameBoard.gridSize, playerY)) {
            System.out.println(playerName+ " Lost The Game!");
        } else {
            playerX = playerX + GameBoard.gridSize;
           // Thread.sleep(10);
        }
    }
}