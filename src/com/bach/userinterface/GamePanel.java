/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.userinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author HOANG XUAN BACH
 */

// Thùng chứa thuộc cửa sổ
// Runnable tạo cho chương trình chạy 
// Keylistioner nghe từ bàn phím
public class GamePanel extends JPanel implements Runnable, KeyListener{
    
    private Thread thread;
    
    private boolean isRunning;
    
    private InputManger inputManger;
    
    // object image in java
    //BufferedImage image;
    //BufferedImage subImage;
    
    public GamePanel(){
        
        inputManger = new InputManger();
        
        //try {
            // Khởi tạo đối tượng file ảnh đọc file ảnh và gán cho đối tượng image
            //image = ImageIO.read(new File("data/megasprite.png"));
            
            // Get subImage of object image
            //subImage = image.getSubimage(2, 5, 30, 100);
            
        //} catch (IOException ex) {
            //ex.printStackTrace();
        //}
    }
    // Graphics is object draw in java
    @Override
    public void paint(Graphics g){
        // draw fill rectangle with x, y, width, height
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
        
    }

    // khởi động threfad để khỏi động run
    public void startGame(){
        if(thread == null){
            this.isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    // Phương thức implement từ runnable
    @Override
    public void run() {
        // Frame per second
        long FPS = 80;
        
        // chu kỳ đơn vị nano time
        long period = 1000*100000/FPS; 
        
        // thời gian bắt đầu chu kỳ
        long beginTime;
        
        // thời gian ngủ của 1 frame
        long sleepTime;
        
        int a = 1;
        
        // thiết lập beginTime đầu tiên
        // phương thức nanoTime lấy thời gian thực theo nanoTime
        beginTime = System.nanoTime();
        
        while(isRunning){
            // Sử dụng phương pháp để khiến game mượt hơn bằng cách
            // updateTime + RenderTime (drawTime)= t
            // t + + sleep() = T (chu kỳ 1 frame)
            
            //System.out.println("a = " + a++);

            // Update game
            // Render game
            
            
            // Tính được thời gian xử lý của Update và Render là bao nhiêu
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;
            
            try {
                if(sleepTime > 0)  
                    // sleep use unit mili
                    Thread.sleep(sleepTime/1000000);
                else Thread.sleep(period/2000000);
            } catch (InterruptedException ex) {}
        }
        
    }   

    // callback method
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        
        inputManger.processKeyPressed(e.getKeyCode());
            
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
        inputManger.processKeyReleased(e.getKeyCode());
        
    }
}
