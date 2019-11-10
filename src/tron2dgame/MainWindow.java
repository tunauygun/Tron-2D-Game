/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron2dgame;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author S347391269
 */
public class MainWindow extends JFrame {
    public static int width = 510;
    public static int height= 510;
    
    public void setupWindow(JPanel jp){
        this.setTitle("Tron");
        this.getContentPane().add("Center", jp);
	this.setSize(width+16, height+40);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(width, height));
        this.setLocationRelativeTo(null);
    }
    
}

