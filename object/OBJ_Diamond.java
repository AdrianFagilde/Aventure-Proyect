/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import pac.adventure.GamePanel;

/**
 *
 * @author afagi
 */
public class OBJ_Diamond extends SuperObject{
        
    
    
        public OBJ_Diamond(){
        
            name = "diamond";
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/objects/diamond.png"));
            } catch (Exception e) {
            }
        
        }
        
        
        
        
        
        
        
        
    
}
