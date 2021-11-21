/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import pac.adventure.GamePanel;

/**
 *
 * @author afagi
 */
public class Enemy extends Entity{
    GamePanel gp;

    public Enemy(GamePanel gp) {
        this.gp = gp;
        
        solidArea = new Rectangle();
        solidArea.x = 10;
        solidArea.y = 20;
        solidArea.width = 28;
        solidArea.height = 28; 
        setDefaultValue();
        getPlayerImage();
    }
    
    public void setDefaultValue(){
        
        x = gp.tileSize * 1;
        y = gp.tileSize * 8;
        speed = 4;
        
    
    }
    
    public void getPlayerImage(){
        
        try {
            
            down2 = ImageIO.read(getClass().getResourceAsStream("/tiles/enemy.png"));
   
        } catch (Exception e) {
        }
        
        
    }
    public void update(){
        
        
    }
    
    public  void draw(Graphics2D g2){
    
            BufferedImage image = null;
            image = down2;
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,null);
    }
    
    
}
