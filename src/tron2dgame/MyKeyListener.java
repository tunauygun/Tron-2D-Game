/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron2dgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author uygun
 */

public class MyKeyListener implements KeyListener {
    
    Player player;
    
    public MyKeyListener(Player p){
        player = p;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (player.controlMethod) {
            case "ARROWKEYS":
                if (key == KeyEvent.VK_LEFT) {
                    player.direction = "LEFT";}
                if (key == KeyEvent.VK_RIGHT) {
                    player.direction = "RIGHT";}
                if (key == KeyEvent.VK_UP) {
                    player.direction = "UP";}
                if (key == KeyEvent.VK_DOWN) {
                    player.direction = "DOWN";}
                break;
            case "WASD":
                if (key == KeyEvent.VK_A) {
                    player.direction = "LEFT";}
                if (key == KeyEvent.VK_D) {
                    player.direction = "RIGHT";}
                if (key == KeyEvent.VK_W) {
                    player.direction = "UP";}
                if (key == KeyEvent.VK_S) {
                    player.direction = "DOWN";}
                break;
            default:
                System.out.println("Control Method Is Not Valid!");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}