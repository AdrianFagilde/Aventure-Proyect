/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac.adventure;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author afagi
 */
public class PACADVENTURE extends JFrame {

    public PACADVENTURE() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        super("PACADVENTURE");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cargarMusica();
        initComponents();
        this.addWindowListener(new WindowsEvents());
        
    }
    
    
    
    public void initComponents() {
        this.getContentPane().setLayout(null);
        
        Titulo = new JLabel();
        
        ImagesLoader images = ImagesLoader.getInstance();
        ImageIcon image =  images.getImage(ImagesLoader.MARCO);
        
        
        Marco = new JLabel();
        Marco.setText("ADVENTURE");
        Marco.setIcon(image);
        Marco.setHorizontalTextPosition(JLabel.CENTER);
        Marco.setFont(new java.awt.Font("Ariel", 0, 30));
        Marco.setForeground(new java.awt.Color(255, 255, 255));
        Marco.setBounds(360, 10, image.getIconWidth(), image.getIconHeight());
        
        this.getContentPane().add(Marco);
        
        
        
        newGame = new JButton("New Game");
        newGame.setBounds(20 , 600, 100, 50);
        newGame.setFocusable(false);
        newGame.setVisible(true);
        this.getContentPane().add(newGame);
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                
                try {
                    newGames(evt);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(PACADVENTURE.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PACADVENTURE.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(PACADVENTURE.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
        
        LoadGame = new JButton("Load Game");
        LoadGame.setBounds(150, 600, 100, 50);
        LoadGame.setFocusable(false);
        LoadGame.setVisible(true);
        this.getContentPane().add(LoadGame);
        LoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("LoadGame.....");
            }
        });
        
        
        image = images.getImage(ImagesLoader.BACKGROUND);
        background = new JLabel(image);
        background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getContentPane().add(background);
//        sound[0].start();
        
        setResizable(false);
    }
    
    
    public void newGames(java.awt.event.ActionEvent evt) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
                System.out.println("NewGame........");
                NewGame nuevo = new NewGame();
                
                this.setVisible(false);
                nuevo.setVisible(true);
//                sound[0].stop();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        PACADVENTURE pacadventure = new PACADVENTURE();
        pacadventure.setVisible(true);
        
        
    }
    
    
   // dimensiones 1200 - 720
    
    
    class WindowsEvents extends WindowAdapter {

        @Override
        public void windowOpened(WindowEvent e) {
            Insets inset = getInsets();
            setSize(1200 + inset.left + inset.right, 720 + inset.bottom + inset.top); //Adecuar el tamaño de la ventana a abrir tomando en cuenta 
            //las dimensiones de la imagen de fondo y de los 4 bordes
            setLocationRelativeTo(null); //Para centrar la ventana en la pantalla
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    
    public void cargarMusica() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
       
       sounds[0] = new Musicas("Music/inicio.wav");
       
       sound[0] = sounds[0].getCancion();
      
   }
    
    
    private JLabel Marco = new JLabel();
    
    private JButton newGame, LoadGame;
    private Musicas []sounds = new Musicas[1];
    private Clip []sound = new Clip[1];
    private JLabel background;
    private JLabel Titulo;

}
