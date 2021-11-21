/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac.adventure;

import entity.Enemy;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import object.SuperObject;
import tile.TileManager;

/**
 *
 * @author afagi
 */
public class GamePanel  extends JPanel implements  Runnable{
    
    
    //screen settings
    private final int originalTileSize =16; // 16x16 tile
    private final int scale = 3;
    public int level = 1;
    
    public final int tileSize  = originalTileSize * scale;// 48x48 tile 
    public final int maxScreenCol =  16;
    public final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixeles
    final int screenHeight = tileSize * maxScreenRow; // 510 pixeles
    
    
    
    public TileManager tileM = new TileManager(this);
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player p = new Player(this,keyH);
    public Enemy e = new Enemy(this);
    public AssetSetter  aSetter = new AssetSetter(this);
    public CollisionChecker cc =  new CollisionChecker(this);
    public SuperObject obj[] = new SuperObject[10];
    
    
    int FPS = 60;
//    int playerX = 100;
//    int playerY = 100;
//    int playerSpeed = 4;
    
    
    
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        
    }
    
    
    
    public void setupGame(){
    
        aSetter.setObjct();
    }
    
    public  void starGameThread(){
    
        gameThread = new Thread(this);
        
        gameThread.start();
    
    }

    
    
    @Override
    public void run(){
        
            double drawInterval = 1000000000/FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            long timer = 0;
            int drawCount = 0;
            
        
        while(gameThread != null){
        
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime)/ drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            
            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
               
            }
            
            if(timer >= 1000000000){

                drawCount = 0;
                timer = 0;
            
            }
        }
    }
    
    
    
    public  void update(){
        
        
        p.update();
        boolean pass = p.checkTileLevel();

        tileM.checkLlave(p.collisionLlave);
        
        tileM.checklevel(pass);
        
    
    
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
       // tileManager
        tileM.draw(g2);
        
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
            
        }
        
       
        e.draw(g2);
       //player 
        p.draw(g2);
        
        g2.dispose();
    
    }
    
    
    
    
    
    
}
