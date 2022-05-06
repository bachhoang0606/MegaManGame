/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.gameobject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author HOANG XUAN BACH
 */
public class Megaman {
    
    private float posX;
    private float posY;
    
    private float width;
    private float height;
    // Trọng lượng để tính độ nặng
    private float mass;

    // Vận tốc theo phương ngang và dọc
    private float speedX;
    private float speedY;
    
    // Xác định chiều nhân vật
    public static int DIR_LEFT;
    public static int DIR_RIGHT;
    // Chiều hướng
    private int direction;
    
    GameWorld gameWorld;
    
    public Megaman(float posX, float posY, float width, float height, float mass, GameWorld gameWorld) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.mass = mass;
        this.gameWorld = gameWorld;
    }

    // Rectangle trả về đối tượng hình chữ nhật
    // Collision nghĩa là va chạm
    // Phương thức có sự va chạm với map
    public Rectangle getBoundForCollisionWithMap(){
        Rectangle bound = new Rectangle();
        bound.x = (int) (getPosX() - (getWidth()/2));
        bound.y = (int) (getPosY() - (getHeight()/2));
        bound.width = (int) getWidth();
        bound.height = (int) getHeight();
        return bound;
    }
    
    public void update(){
        setPosX(getPosX() + speedX);
        setPosY(getPosY() + speedY);
        
        Rectangle futureRect = getBoundForCollisionWithMap();
        futureRect.y += getSpeedY();
        Rectangle rectLand = gameWorld.physcalMap.haveCollisionWithLand(futureRect);
        
        if(rectLand!=null)  setPosY(rectLand.y - getHeight()/2);
        else {
            //setSpeedY(getSpeedY() + speedY);
            setSpeedY(getSpeedY() + mass);
        }
    }
    
    public void draw(Graphics2D g2){
        g2.setColor(Color.red);
        // Tâm ở chính giữa nhân vật
        g2.fillRect((int) (posX - getWidth()/2), (int) (posY - getHeight()/2), (int) width, (int) height);
    }
    
    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
}
