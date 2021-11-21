/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac.adventure;


import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;

import java.io.File;

/**
 *
 * @author afagi
 */
public class Musicas  {
    URL url;
    AudioInputStream flujo;
    AudioFormat format;
    DataLine.Info info;
    Clip reprod;
    
    public Musicas(String song)throws UnsupportedAudioFileException, 
                            IOException, LineUnavailableException{
      url = getClass().getResource(song);
      flujo = AudioSystem.getAudioInputStream(url);
      format = flujo.getFormat();
      
      info= new DataLine.Info (Clip.class, format, (int) (flujo.getFrameLength () * format.getFrameSize ()));
        
      reprod = (Clip)AudioSystem.getLine(info);
      reprod.open(flujo);
        
      
      
        
    }
    
    public Clip getCancion() throws IOException{
        
        
        
        return reprod;
    };
    
}