/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.userinterface;

import com.bach.gameobject.GameWorld;
import com.bach.gameobject.Megaman;
    import java.awt.event.KeyEvent;

/**
 *
 * @author HOANG XUAN BACH
 */
public class InputManger {

    private GameWorld gameWorld;
    
    public InputManger(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }
    
    
    
    public void processKeyPressed(int keyCode){
        
        switch(keyCode){
            
            case KeyEvent.VK_UP:
                break;
                
            case KeyEvent.VK_DOWN:
                break;
            
            case KeyEvent.VK_LEFT:
                gameWorld.megaman.setDirection(Megaman.DIR_LEFT);
                gameWorld.megaman.setSpeedX(-5);
                break;
                
            case KeyEvent.VK_RIGHT:
                gameWorld.megaman.setDirection(Megaman.DIR_RIGHT);  
                gameWorld.megaman.setSpeedX(5);
                break; 
                
            case KeyEvent.VK_ENTER:
                
                break;
                
            case KeyEvent.VK_SPACE:
                gameWorld.megaman.setSpeedY(-5);
                gameWorld.megaman.setPosY(gameWorld.megaman.getPosY() - 3);
                break;
            
            case KeyEvent.VK_A:
                
                break;
           
                
                
             
        }
    }
    
    
    public void processKeyReleased(int keyCode){
        
        switch(keyCode){
            
            case KeyEvent.VK_UP:
                
                break;
                
            case KeyEvent.VK_DOWN:
                
                break;
            
            case KeyEvent.VK_LEFT:
                gameWorld.megaman.setSpeedX(0);
                break;
                
            case KeyEvent.VK_RIGHT:
                gameWorld.megaman.setSpeedX(0);
                break;
                
            case KeyEvent.VK_ENTER:
                
                break;
                
            case KeyEvent.VK_SPACE:
                
                break;
            
            case KeyEvent.VK_A:
                
                break;
           
                
                
             
        }
    }
}
