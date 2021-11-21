/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac.adventure;

/**
 *
 * @author afagi
 */
import java.net.URL;
import javax.swing.ImageIcon;

public class ImagesLoader {
    private static ImagesLoader instance=null;

    private static final int MAX_IMAGES=4;
    public static final int BACKGROUND=0;
    public static final int BACKGROUND1=2;
    public static  final  int MARCO=1;
    public static  final  int MARCOP=3;
  
    private ImageIcon images[];

    private ImagesLoader(){
        String filenames[]= new String[]{"Fondo1.jpeg","Marco.png","newGame.jpeg","MarcoP.png"};        

        images = new ImageIcon[MAX_IMAGES];
        for(int i=0;i<MAX_IMAGES;i++){
            
            URL url = this.getClass().getResource("Images/"+filenames[i]);
            images[i] = new ImageIcon(url);
        }
    }

    public static ImagesLoader getInstance(){
        if(instance==null)
          instance = new ImagesLoader();

        return instance;
    
    }

    public ImageIcon getImage(int imageId){
        if(imageId<0 || imageId>=MAX_IMAGES)
            return null;
        
        return images[imageId];
    }
}