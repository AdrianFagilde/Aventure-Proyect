/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.GraphicAttribute;
import java.awt.image.BufferedImage;
import pac.adventure.GamePanel;

/**
 *
 * @author afagi
 */
public class SuperObject {
    
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public int  x,y;
    
    
    
    public void draw(Graphics2D g2, GamePanel gp){
            
            g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);

    }
}
