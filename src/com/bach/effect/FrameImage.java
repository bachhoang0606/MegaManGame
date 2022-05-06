/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.effect;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author HOANG XUAN BACH
 */
public class FrameImage {
    private String name;
    
    // object image in java
    private BufferedImage image;
    
    public FrameImage(){
        this.name = null;
        this.image = null;
    }
    
    public FrameImage(String name, BufferedImage image){
        this.name = name;
        this.image = image;
    }

    public FrameImage(FrameImage frameImage){
        
        image = new BufferedImage(frameImage.getImageWidth(), frameImage.getImageHeight(),
                                            frameImage.getImage().getType());
        
        
        // A Graphics2D, which can be used to draw into this image.

        Graphics g = image.getGraphics();
        
        g.drawImage(frameImage.getImage(), 0, 0, null);
        
    }
    
    public void draw(Graphics2D g2, int x, int y){
        g2.drawImage(image, x - image.getWidth()/2, y - image.getHeight()/2, null);
    }
    
    // get height and width of image
    public int getImageWidth(){
        return image.getWidth();
    }
    
    public int getImageHeight(){
        return image.getHeight();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image; //21:11
    }
}
