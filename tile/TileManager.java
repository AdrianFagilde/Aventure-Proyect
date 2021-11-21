/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tile;

import entity.Entity;
import entity.Player;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import pac.adventure.GamePanel;

/**
 *
 * @author afagi
 */
public class TileManager {
    
    GamePanel gp;
    Player p;
    public Tile[] tile;
    public int mapTileNums[][];
    public int levelMap;
    public  boolean llave;
    public boolean diamons;
    public String map;
    public int worldCol,worldRow;
    public boolean change;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        map = null;
        levelMap = 0;
        llave = false;
        diamons = false;
        change = false;
        worldCol = 0;
        worldRow = 0;
        mapTileNums = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
        
    }
    
    
    
    // funcion para carga el Tile
    public void getTileImage(){
        
        try {
            
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/alfombra2.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].collision = true;
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door.png"));
            tile[2].salida = true;
            tile[2].collision = true;
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/key.png"));
            tile[3].llave = true;
         
            
        } catch (Exception e) {
            
        }
    
    }
    
    
    
   // Funcion para cargar el mapa
    public void loadMap(){
        
        try {
                map = updateMap();
                InputStream mp = getClass().getResourceAsStream(map);
                BufferedReader br = new BufferedReader(new InputStreamReader(mp));
            
            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {                
                
                String nums[] = br.readLine().split(" ");
                
                while(col < gp.maxScreenCol){
                    int num = Integer.parseInt(nums[col]);
                    
                    
                    if(llave == true && num == 3){
                        mapTileNums[col][row] = 0;
                        
                        col++;
                    }else{
                    
                        mapTileNums[col][row] = num;
                        col++;
                    
                    }
                    
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
            
        } catch (Exception e) {
        }
    }
    
    
    
    public void draw(Graphics2D g2){
        
        int col  = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {            
            
            int tileNum = mapTileNums[col][row];
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            
            col++;
            x +=gp.tileSize;
            
            if(col == gp.maxScreenCol){
            
                col=0;
                x = 0;
                row++;
                y += gp.tileSize;
            }   
        }
    }
    
    
    public void checklevel(boolean  valor){
        if(valor == true){
            
            levelMap++;
            llave = false;
            change = true;
            loadMap();
        }
    }
    public void checkLlave(boolean valor){
        
        if(valor == true){
            llave = true;
            
            loadMap();
        
        }
    }
     
    
    
    public String updateMap(){
    String map = null;
    
        if(levelMap == 0){
             map = "/maps/map.txt";
             
        }
        if(levelMap == 1){
             map = "/maps/map1.txt";
//             gp.aSetter.updateObject(levelMap, change);
        
        }
        if(levelMap == 2){
             map = "/maps/map2.txt";
        
        }
    
        return map;
    
    }

    
    
   
    
    
}
