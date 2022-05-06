/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bach.effect;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
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
        if(currentFrame >=0 && currentFrame < frameImages.size())
            this.currentFrame = currentFrame;
        else this.currentFrame = 0;
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
    
    public void setIgnoreFrame(int id){
        if(id >= 0 && id <= ignoreFrames.size())
            ignoreFrames.set(id, true);
    }
    
    public void unIgnoreFrame(int id){
        if(id >= 0 && id < ignoreFrames.size())
            ignoreFrames.set(id, false);
    }
    
    public void reset(){
        currentFrame = 0;
        beginTime = 0;
        
        for(int i = 0; i < ignoreFrames.size(); i++){
            ignoreFrames.set(i, false);
        }
    }
    
    // Thêm một image vào animation
    public void add(FrameImage frameImage, double timeToNextFrame){
        
        ignoreFrames.add(false);
        frameImages.add(frameImage);
        delayFrames.add(timeToNextFrame);
    }
    
    // Get Current Image
    public BufferedImage getCurrentImage(){
        return frameImages.get(currentFrame).getImage();
    }
    
    // currentTime là thời gian hiện tại của hệ thống
    public void Update(long currentTime){
        
        if(beginTime == 0) beginTime = currentTime;
        else{
            
            if(currentTime - beginTime > delayFrames.get(currentFrame)){
                nextFrame();
                beginTime = currentTime;
            }
        }
    }
    
    private void nextFrame(){
        
        if(currentFrame >= frameImages.size() - 1){
            if(isRepeated)  currentFrame = 0;
        }
        else currentFrame++;
        
        if(ignoreFrames.get(currentFrame)) nextFrame();
    }
    
    public boolean isLastFrame(){
        if(currentFrame == frameImages.size() - 1)
            return true;
        else return false;
    }
    
    // lật ngược các tấm hình
    public void flipAllImage(){
        
        for(int i = 0; i < frameImages.size(); i++){
            
            // Lật ngược hình tìm hiểu thêm sau
            BufferedImage image = frameImages.get(i).getImage();
            
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-image.getWidth(), 0);
            
            AffineTransformOp op = new AffineTransformOp(
                    tx,
                    AffineTransformOp.TYPE_BILINEAR
            );
            image = op.filter(image, null);
            
            frameImages.get(i).setImage(image);
            
        }
    }
    
    public void draw(Graphics2D g2, int x, int y){
        
        BufferedImage image = getCurrentImage();
        
        g2.drawImage(image, x - image.getWidth()/2, y - image.getHeight()/2, null);
        
        if(drawRectFrame)
            g2.drawRect(x - image.getWidth()/2, x - image.getWidth()/2, image.getWidth(), image.getHeight());
    }

    
}

