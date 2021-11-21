/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac.adventure;

import entity.Entity;
import tile.TileManager;

/**
 *
 * @author afagi
 */
public class CollisionChecker {
    
    GamePanel gp;
    boolean llave = false;
    int x;
    int y;
    public CollisionChecker(GamePanel gp) {
        x = 0;
        y = 0;
        this.gp = gp;
    }
    
   // funciones para chequear los muros  
    public void checkTile(Entity entity){
        
        int entityLeftX = entity.x + entity.solidArea.x;
        int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.y + entity.solidArea.y;
        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;
        
        
        int entityLeftCol = entityLeftX/gp.tileSize;
        int entityRightCol = entityRightX/gp.tileSize;
        int entityTopRow = entityTopY/gp.tileSize;
        int entityBottomRow = entityBottomY/gp.tileSize;
        
        int tileNum1, tileNum2;
        
        
        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopY - entity.speed)/ gp.tileSize;
                tileNum1 = gp.tileM.mapTileNums[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNums[entityRightCol][entityTopRow];
//                System.out.println(entityLeftCol+"-"+entityTopRow);
//                System.out.println(entityRightCol+"-"+entityTopRow);
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true ) {
                    entity.collisionOn = true;
//                    System.out.println("true");
                }
                if (gp.tileM.tile[tileNum1].llave == true || gp.tileM.tile[tileNum2].llave == true ) {
                    entity.collisionLlave = true;
                    gp.tileM.tile[2].collision = false;
                    llave = true;                  
                }
                if (gp.tileM.tile[tileNum1].enemy == true || gp.tileM.tile[tileNum2].enemy == true ) {
                    entity.collisionEnemy = true;
                    
                    llave = true;                  
                }
                
                break;
            case "down":
                entityBottomRow = (entityBottomY - entity.speed)/ gp.tileSize;
                tileNum1 = gp.tileM.mapTileNums[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNums[entityRightCol][entityBottomRow];
//                System.out.println(entityLeftCol+"-"+entityBottomRow);
//                System.out.println(entityRightCol+"-"+entityBottomRow);
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true ) {
                    entity.collisionOn = true;
                    
                }
                if (gp.tileM.tile[tileNum1].llave == true || gp.tileM.tile[tileNum2].llave == true ) {
                    entity.collisionLlave = true;
                    gp.tileM.tile[2].collision = false;
                    llave = true;
  
                }
                if (gp.tileM.tile[tileNum1].enemy == true || gp.tileM.tile[tileNum2].enemy == true ) {
                    entity.collisionEnemy = true;
                    llave = true;                  
                }
                
                break;
            case "left":
                entityLeftCol = (entityLeftX - entity.speed)/ gp.tileSize;
                tileNum1 = gp.tileM.mapTileNums[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNums[entityLeftCol][entityBottomRow];
//                System.out.println(entityLeftCol+"-"+entityTopRow);
//                System.out.println(entityLeftCol+"-"+entityBottomRow);
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true ) {
                    entity.collisionOn = true;
                    
                }
                if (gp.tileM.tile[tileNum1].llave == true || gp.tileM.tile[tileNum2].llave == true ) {
                    entity.collisionLlave = true;
                    gp.tileM.tile[2].collision = false;
                    llave = true;                 
                }
                if (gp.tileM.tile[tileNum1].enemy == true || gp.tileM.tile[tileNum2].enemy == true ) {
                    entity.collisionEnemy = true;
                    llave = true;                  
                }
                
                break;
            case "right":
                entityRightCol = (entityRightX - entity.speed)/ gp.tileSize;
                tileNum1 = gp.tileM.mapTileNums[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNums[entityRightCol][entityBottomRow];
//                System.out.println(entityRightCol+"-"+entityTopRow);
//                System.out.println(entityRightCol+"-"+entityBottomRow);
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true ) {
                    entity.collisionOn = true;
                    
                }
                if (gp.tileM.tile[tileNum1].llave == true || gp.tileM.tile[tileNum2].llave == true ) {
                    entity.collisionLlave = true;
                    gp.tileM.tile[2].collision = false;
                    llave = true;                   
                }
                if (gp.tileM.tile[tileNum1].enemy == true || gp.tileM.tile[tileNum2].enemy == true ) {
                    entity.collisionEnemy = true;
                    llave = true;                  
                }
                
                break;
             default:
        }
    }
    
    
    public int checkObject(Entity entity,boolean player){
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {
            
            if(gp.obj[i] != null){
            entity.solidArea.x = entity.x + entity.solidArea.x;
            entity.solidArea.y = entity.y + entity.solidArea.y;
            
            gp.obj[i].solidArea.x = gp.obj[i].solidArea.x + gp.obj[i].x;
            gp.obj[i].solidArea.y = gp.obj[i].solidArea.y + gp.obj[i].y;
            
            switch(entity.direction){
            case "up":
                entity.solidArea.y -= entity.speed;
                if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                    if(gp.obj[i].collision == true){
                        entity.collisionOn = true;
                    }
                    if(player == true ){
                        index = i;
                    }
                    
                    System.out.println("collsion up");}
                break;
            case "down":
                entity.solidArea.y += entity.speed;
                if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                    if(gp.obj[i].collision == true){
                        entity.collisionOn = true;
                    }
                    if(player == true ){
                        index = i;
                    }
                    System.out.println("collsion down");}
                break;
            case "left":
                entity.solidArea.x -= entity.speed;
                if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                    if(gp.obj[i].collision == true){
                        entity.collisionOn = true;
                    }
                    if(player == true ){
                        index = i;
                    }
                    System.out.println("collsion left");}
                break;
            case "right":
                entity.solidArea.x += entity.speed;
                if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                    if(gp.obj[i].collision == true){
                        entity.collisionOn = true;
                    }
                    if(player == true ){
                        index = i;
                    }
                    System.out.println("collsion rigth");}
                break;
             default:      
            }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.obj[i].solidArea.x = entity.solidAreaDefaultX;
            gp.obj[i].solidArea.y = entity.solidAreaDefaultY;
            
            }
            
        }
        
        return index;
    
    
    }
    
    
//    public boolean checkTakeKey(){
//        boolean valor = false;
//        if(llave == true ){
//            valor = true;
//        
//        }
//        return valor;
//    }
    
    
    // funcion para chequear los nivele
    public boolean checkPassLevel(Entity entity){
        boolean valor = true;
        int entityLeftX = entity.x + entity.solidArea.x;
        int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.y + entity.solidArea.y;
        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;
        
        
        int entityLeftCol = entityLeftX/gp.tileSize;
        int entityRightCol = entityRightX/gp.tileSize;
        int entityTopRow = entityTopY/gp.tileSize;
        int entityBottomRow = entityBottomY/gp.tileSize;
        
        int tileNum1, tileNum2;
        
        
        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopY - entity.speed)/ gp.tileSize;
                tileNum1 = gp.tileM.mapTileNums[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNums[entityRightCol][entityTopRow];

                
                if ((gp.tileM.tile[tileNum1].salida == true || gp.tileM.tile[tileNum2].salida == true) && llave == true ) {
                    entity.collisionLevel = true;
                    entity.collisionLlave = false;
                
                    llave = false;

                }
                
                break;
             default:
        }
        return valor;
    }
    
   
}
