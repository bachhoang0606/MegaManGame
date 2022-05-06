/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.userinterface;

import com.bach.effect.CacheDataLoader;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author HOANG XUAN BACH
 */

// cửa sổ
public class GameFrame extends JFrame {
    
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 600;
    
    GamePanel gamePanel;
   
    // constructer
    public GameFrame(){
    
        // get size of screen 
        Toolkit toolkit = this.getToolkit();
        
        // dimention is object save value pair (cặp giá trị)
        Dimension dimension = toolkit.getScreenSize();
        
        // x, y is location, width, height is game frame  size
        this.setBounds((dimension.width - SCREEN_WIDTH)/2,(dimension.height - SCREEN_HEIGHT)/2, SCREEN_WIDTH, SCREEN_HEIGHT);
        
        try {
            CacheDataLoader.getInstance().loadData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        gamePanel = new GamePanel();
        add(gamePanel);
        
        this.addKeyListener(gamePanel);
    }
    
    public void startGame(){
        gamePanel.startGame();
    }
    
    public static void main(String arg[]){
        GameFrame gameFrame = new GameFrame();
                
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.startGame();
    }
    
}
