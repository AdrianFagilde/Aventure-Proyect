/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac.adventure;

import object.OBJ_Diamond;

/**
 *
 * @author afagi
 */
public class AssetSetter {
    
    GamePanel gp;
    
    
    public AssetSetter(GamePanel gp){
        
        this.gp = gp;
        
 
    }
    
    public void setObjct(){
        
        
        gp.obj[0] = new OBJ_Diamond();
        gp.obj[0].x = 5 * gp.tileSize;
        gp.obj[0].y = 9 * gp.tileSize; 
        gp.obj[1] = new OBJ_Diamond();
        gp.obj[1].x = 5 * gp.tileSize;
        gp.obj[1].y = 8 * gp.tileSize; 
        gp.obj[2] = new OBJ_Diamond();
        gp.obj[2].x = 5 * gp.tileSize;
        gp.obj[2].y = 7 * gp.tileSize; 
        gp.obj[3] = new OBJ_Diamond();
        gp.obj[3].x = 5 * gp.tileSize;
        gp.obj[3].y = 6 * gp.tileSize; 
        gp.obj[4] = new OBJ_Diamond();
        gp.obj[4].x = 5 * gp.tileSize;
        gp.obj[4].y = 5 * gp.tileSize;
        gp.obj[5] = new OBJ_Diamond();
        gp.obj[5].x = 6 * gp.tileSize;
        gp.obj[5].y = 5 * gp.tileSize;
        gp.obj[6] = new OBJ_Diamond();
        gp.obj[6].x = 7 * gp.tileSize;
        gp.obj[6].y = 5 * gp.tileSize;
        gp.obj[7] = new OBJ_Diamond();
        gp.obj[7].x = 8 * gp.tileSize;
        gp.obj[7].y = 5 * gp.tileSize;
        gp.obj[8] = new OBJ_Diamond();
        gp.obj[8].x = 9 * gp.tileSize;
        gp.obj[8].y = 5 * gp.tileSize;
        gp.obj[9] = new OBJ_Diamond();
        gp.obj[9].x = 10 * gp.tileSize;
        gp.obj[9].y = 5 * gp.tileSize;
        
        
        

    }
    
    
    public void updateObject(int level, boolean  change ){
        
        
        if(level == 1 && change == true){
            for (int i = 0; i < gp.obj.length; i++) {
                if (gp.obj[i]!= null) {
                    gp.obj[i].collision = false;
                }
                
            }
        
        gp.obj[0].x = 11 * gp.tileSize;
        gp.obj[0].y = 6 * gp.tileSize; 
        
        gp.obj[1].x = 12 * gp.tileSize;
        gp.obj[1].y = 6  * gp.tileSize; 
        
        gp.obj[2].x = 10 * gp.tileSize;
        gp.obj[2].y = 6 * gp.tileSize; 
        
        gp.obj[3].x = 9 * gp.tileSize;
        gp.obj[3].y = 6 * gp.tileSize; 
       
        gp.obj[4].x = 8 * gp.tileSize;
        gp.obj[4].y = 6 * gp.tileSize;
        
        gp.obj[5].x = 7 * gp.tileSize;
        gp.obj[5].y = 6 * gp.tileSize;
       
        gp.obj[6].x = 6 * gp.tileSize;
        gp.obj[6].y = 6 * gp.tileSize;
        
        gp.obj[7].x = 5 * gp.tileSize;
        gp.obj[7].y = 6 * gp.tileSize;
        
        gp.obj[8].x = 4 * gp.tileSize;
        gp.obj[8].y = 6 * gp.tileSize;
        
        gp.obj[9].x = 4 * gp.tileSize;
        gp.obj[9].y = 6 * gp.tileSize;
            
         gp.p.change = false;
        }
    
    }
    
    
    
   
}
