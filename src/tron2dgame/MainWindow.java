/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron2dgame;

import javax.swing.JFrame;

/**
 *
 * @author S347391269
 */
public class MainWindow extends JFrame {
    int width;
    int height;
    String winTitle;
    
    public MainWindow(String title, int w, int h){
        width = w;
        height = h;
        winTitle = title;
    }
    
    public void setupWindow(){
        JFrame window = new JFrame(winTitle);
        //window.add(new Game2());
	window.setSize(width, height);
	window.setVisible(true);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
