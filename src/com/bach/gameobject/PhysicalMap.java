/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.gameobject;

import com.bach.effect.CacheDataLoader;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author HOANG XUAN BACH
 */
public class PhysicalMap extends GameObject{
    
    public int[][] phys_map; 
    
    // Độ lớn một khung vuông
    private int titleSize;
    
    // Tọa độ physcalMap
    public float posX, posY;
    
    public PhysicalMap(float x, float y){
        this.posX = x;
        this.posY = y;
        this.titleSize = 30;
        phys_map = CacheDataLoader.getInstance().getPhysicalMap();
    } 
    
    public void draw(Graphics2D g2){
        
        g2.setColor(Color.GRAY);
        for(int i = 0; i < phys_map.length; i++)
            for(int j = 0; j < phys_map[0].length; j++)
                if(phys_map[i][j]!=0) g2.fillRect(
                                                    (int) posX + j*titleSize,
                                                    (int) posY + i*titleSize, 
                                                    titleSize, 
                                                    titleSize
                                                );
    }
    
    // Có va chạm với vùng đất
    public Rectangle haveCollisionWithLand(Rectangle rect){
        
        int posX1 = rect.x/titleSize;
        posX1 -= 2;
        int posX2 = (rect.x + rect.width)/titleSize;
        posX2 += 2;
        
        int posY = (rect.y + rect.height)/titleSize;
        
        if(posX1 < 0) posX1 = 0;
        
        if(posX2 >= phys_map[0].length) posX2 = phys_map[0].length - 1;
        for(int y = 0; y < phys_map.length; y++)
            for(int x = 0; x < phys_map[0].length; x++){
                
                if(phys_map[y][x] == 1){
                    Rectangle r = new Rectangle(
                                                
                                                (int) posX + x*titleSize,
                                                (int) posY + y*titleSize,
                                                titleSize,
                                                titleSize
                                            );
                    if(rect.intersects(r))
                        return r;
                }
            }
        return null;
    }
}
