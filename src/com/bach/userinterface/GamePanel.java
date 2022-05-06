/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.userinterface;

import com.bach.effect.Animation;
import com.bach.effect.CacheDataLoader;
import com.bach.effect.FrameImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    
    // Tạo một khung hình toàn cục
    private BufferedImage bufImage;
    // Cây bút để vẽ lên bufImage
    private Graphics2D bufG2D;
    
    
    //FrameImage frame1, frame2, frame3;
    //Animation anim;
    // object image in java
    //BufferedImage image;
    //BufferedImage subImage;
    
    public GamePanel(){
        
        inputManger = new InputManger();
        
        // TYPE_INT_ARGB Chế độ 3 màu chính
        bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        
        //try {
            // Khởi tạo đối tượng file ảnh đọc file ảnh và gán cho đối tượng image
            //BufferedImage image = ImageIO.read(new File("data/megasprite.png"));
            
            // Get subImage of object image
            //BufferedImage image1 = image.getSubimage(525, 38, 90, 100);
            //frame1 = new FrameImage("frame1", image1);
            
            //BufferedImage image2 = image.getSubimage(612, 38, 90, 100);
            //frame2 = new FrameImage("frame2", image2);
            
            //BufferedImage image3 = image.getSubimage(700, 38, 90, 100);
            //frame3 = new FrameImage("frame3", image3);
            
            //anim = new Animation();
            //anim.add(frame1, 200*1000000);
            //anim.add(frame2, 200*1000000);
            //anim.add(frame3, 200*1000000);
            
        //frame1 = CacheDataLoader.getInstance().getFrameImage("idle2");
        //anim = CacheDataLoader.getInstance().getAnimation("idle");
        //anim.flipAllImage();
       //} catch (IOException ex) {}
    }
    // Graphics is object draw in java
    @Override
    public void paint(Graphics g){
        // draw fill rectangle with x, y, width, height
        
        g.drawImage(bufImage, 0, 0, this);
        
        // Ép kiểu
        //Graphics2D g2 = (Graphics2D) g;
        
        //anim.Update(System.nanoTime());
        //anim.draw(g2, 100, 130);
        
        //frame1.draw(g2, 30, 30);
        //anim.draw(g2, 200, 200);
        //g.drawImage(img, WIDTH, WIDTH, this);
    }

    // Vẽ lên bufImage dùng với ký thuật vẽ đệm
    public void RenderGame(){
        if(bufImage == null){
            bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }
        
        if(bufImage != null){
            bufG2D = (Graphics2D) bufImage.getGraphics();
        }
        
        if(bufG2D != null){
            bufG2D.setColor(Color.WHITE);
            bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
        }
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
            //anim.Update(System.nanoTime());
            
            RenderGame();
            repaint();
            // Repain call pain method
            repaint();
            
            
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
