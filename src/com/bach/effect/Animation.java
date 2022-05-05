/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.effect;

import java.util.ArrayList;

/**
 *
 * @author HOANG XUAN BACH
 */
public class Animation {
    
    private String name;
    
    // kiểm tra trạng thái có cho lặp lại hay không
    private boolean isRepeated;
    
    // bản chất là mảng đối tượng
    private ArrayList<FrameImage> frameImages;
    
    // Chỉ frame hiện tại trên màn hình
    private int currentFrame;
    
    // Có thể loại bỏ một số khung hình không lặp lại
    private ArrayList<Boolean> ignoreFrames;
    
    // Mảng chứa thời gian delay giữa các frame
    private ArrayList<Double> delayFrames;
    
    private long beginTime;
    
    // Biến cho vẽ khung hình giúp cho quá trình phát triển dễ nhìn hơn
    private boolean drawRectFrame;
    
    public Animation(){
        delayFrames = new ArrayList<Double>();
        
        beginTime = 0;
        
        currentFrame = 0;
        
        ignoreFrames = new ArrayList<Boolean>();
        
        frameImages = new ArrayList<FrameImage>();
        
        drawRectFrame = false;
        
        isRepeated = true;
    }
    
    public Animation(Animation animation){
        beginTime = animation.beginTime;
        currentFrame = animation.currentFrame;
        drawRectFrame = animation.drawRectFrame;
        isRepeated = animation.isRepeated;
        
        delayFrames = new ArrayList<Double>();
        for(Double d : animation.delayFrames){
            delayFrames.add(d);
        }
        
        ignoreFrames = new ArrayList<Boolean>();
        for(Boolean b : animation.ignoreFrames){
            ignoreFrames.add(b);
        }
        
        frameImages = new ArrayList<FrameImage>();
        for(FrameImage f : animation.frameImages){
            frameImages.add(f);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsRepeated() {
        return isRepeated;
    }

    public void setIsRepeated(boolean isRepeated) {
        this.isRepeated = isRepeated;
    }

    public ArrayList<FrameImage> getFrameImages() {
        return frameImages;
    }

    public void setFrameImages(ArrayList<FrameImage> frameImages) {
        this.frameImages = frameImages;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public ArrayList<Boolean> getIgnoreFrames() {
        return ignoreFrames;
    }

    public void setIgnoreFrames(ArrayList<Boolean> ignoreFrames) {
        this.ignoreFrames = ignoreFrames;
    }

    public ArrayList<Double> getDelayFrames() {
        return delayFrames;
    }

    public void setDelayFrames(ArrayList<Double> delayFrames) {
        this.delayFrames = delayFrames;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public boolean getDrawRectFrame() {
        return drawRectFrame;
    }

    public void setDrawRectFrame(boolean drawRectFrame) {
        this.drawRectFrame = drawRectFrame;
    }
    
    public boolean isIgnoreFrame(int id){
        return ignoreFrames.get(id);
    }
}
