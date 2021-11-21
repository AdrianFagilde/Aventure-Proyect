/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author afagi
 */
public class Entity {
    
    public int x,y;
    public  int speed;
    public BufferedImage  up1,up2,down1,down2,left1,left2,right1,right2;
    public String direction = null;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea;
    public int solidAreaDefaultX,solidAreaDefaultY;
    public boolean  collisionOn = false;
    public boolean  collisionLevel = false;
    public boolean collisionLlave = false;
    public boolean collisionEnemy = false;
    public boolean collisionDiamond = false;
    
}
