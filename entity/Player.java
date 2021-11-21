/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import pac.adventure.GamePanel;
import pac.adventure.ImagesLoader;
import pac.adventure.KeyHandler;

/**
 *
 * @author afagi
 */
public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public boolean change;
    public int level ;
    
    public Player(GamePanel gp, KeyHandler KeyH){
    
        this.gp = gp;
        this.keyH = KeyH;
        change = false;
        level = 0;
        solidArea = new Rectangle();
        solidArea.x = 10;
        solidArea.y = 20;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 28;
        solidArea.height = 28; 
        
        setDefaultValue();
        getPlayerImage();
        
    }
    
    public void setDefaultValue(){
        
        x = gp.tileSize * 7;
        y = gp.tileSize * 11;
        speed = 4;
        direction = "down";
    
    }
    
    public void getPlayerImage(){
        
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            
            
        } catch (Exception e) {
        }
    
    }
    
    
    public void update(){
        
        if(keyH.upPressed == true || keyH.downPressed == true || 
                keyH.rightPressed == true || keyH.rightPressed == true || keyH.leftPressed == true){

        if(keyH.upPressed == true){
            
            direction = "up";
        }
        if(keyH.downPressed == true){
            
            direction = "down";
        }
        if(keyH.rightPressed == true){
            
            direction = "right";
        }
        if(keyH.leftPressed == true){
            
            direction = "left";
        }
        
            collisionOn = false;
            
            gp.cc.checkTile(this);
            
            int indexObj = gp.cc.checkObject(this, true);
            pickUpObject(indexObj);
            if(collisionOn == false){
            
                switch(direction){
                    case "up":
                        y -= speed;
                        break;
                    case "down":
                        y += speed;
                        break;
                    case "left":
                        x -= speed;
                        break;
                    case "right":
                        x += speed;
                        break;
                
                }
            }
            
            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
            }

        }

    }
    
    public void pickUpObject(int i){
    
        if(i != 999){
        
            gp.obj[i] = null;
        
        }
    }
    
    public boolean checkTileLevel(){
        boolean valor = false;
        if(keyH.upPressed == true || keyH.downPressed == true || 
                keyH.rightPressed == true || keyH.rightPressed == true || keyH.leftPressed == true){

            collisionLevel = false;
            gp.cc.checkPassLevel(this);
            if(collisionLevel == true){
               change = true;
               level++;
               valor = true;
               x = gp.tileSize * 7;
               y = gp.tileSize * 11;
                System.out.println(valor);
            }
    
        }
        return valor;
    }
    
    public  void draw(Graphics2D g2){
    
//        g2.setColor(Color.white);
//        
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

            BufferedImage image = null;
            
            switch(direction){
            
                case "up":
                    image = up1;
                    if(spriteNum == 1){
                        image = up1;
                    }
                    if(spriteNum == 2){
                        image = up2;
                    }
                    break;
                case "down":
                    image = down1;
                    if(spriteNum == 1){
                        image = down1;
                    }
                    if(spriteNum == 2){
                        image = down2;
                    }
                    break;
                case "right":
                    image = right1;
                    if(spriteNum == 1){
                        image = right1;
                    }
                    if(spriteNum == 2){
                        image = right2;
                    }
                    break;
                case "left":
                    image = left1;
                    if(spriteNum == 1){
                        image = left1;
                    }
                    if(spriteNum == 2){
                        image = left2;
                    }
                    break;
            }
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,null);
    }

}
