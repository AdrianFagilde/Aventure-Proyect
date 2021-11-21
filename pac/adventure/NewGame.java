/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac.adventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author afagi
 */
public class NewGame extends JFrame{
    
    public NewGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super("New Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initComponents();
        this.addWindowListener(new WindowsEvents());
        
    }
    
    public void initComponents() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.getContentPane().setLayout(null);
        ImagesLoader images = ImagesLoader.getInstance();
        ImageIcon image =  images.getImage(ImagesLoader.MARCOP);
        
        
        
        sound.start();
        
        
        subtitulo = new JLabel("New Game");
        subtitulo.setBounds(240, 10, image.getIconWidth(), image.getIconHeight());
        subtitulo.setIcon(image);
        subtitulo.setHorizontalTextPosition(JLabel.CENTER);
        subtitulo.setFont(new java.awt.Font("Ariel", 0, 20));
        subtitulo.setForeground(new java.awt.Color(255, 255, 255));
        this.getContentPane().add(subtitulo);
        
        
        
        entrada = new JPanel();
        entrada.setBounds(240, 130, 250, 280);
        entrada.setBackground(new Color(255,51,102,100));
        entrada.setLayout(null);
        this.getContentPane().add(entrada);
        
        subtitulo1 = new JLabel("TU NOMBRE:");
        subtitulo1.setFont(new java.awt.Font("Ariel", 0, 20));
        subtitulo1.setForeground(new java.awt.Color(255, 255, 255));
        subtitulo1.setBounds(50, 70, 150, 25);
        entrada.add(subtitulo1);
        
        
        nickName = new JTextField();
        nickName.setVisible(true);
        nickName.setBounds(50  , 100, 150, 50);
        nickName.setFont(new java.awt.Font("Ariel", 0, 15));
        nickName.setBackground(new Color(0, 0, 0));
        nickName.setForeground(Color.WHITE);
        entrada.add(nickName);
        
        
        starGame = new JButton("StarGame");
        starGame.setVisible(true);
        starGame.setBounds(25, 200, 200, 30);
        starGame.setFont(new java.awt.Font("Ariel", 0, 15));
        entrada.add(starGame);
        starGame.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                starGameAction();
                
                
            }
        
        
        
        
        });
        
        
        
        image = images.getImage(ImagesLoader.BACKGROUND1);
        background = new JLabel(image);
        background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getContentPane().add(background);
        
        setResizable(false);
    }
    
    
    
    public void starGameAction(){
        
        this.setVisible(false);
        Game game = new Game();
        
        game.setVisible(true);
        sound.stop();
    
    }
    
    
    class WindowsEvents extends WindowAdapter {

        @Override
        public void windowOpened(WindowEvent e) {
            Insets inset = getInsets();
            setSize(752 + inset.left + inset.right, 434 + inset.bottom + inset.top); //Adecuar el tamaño de la ventana a abrir tomando en cuenta 
            //las dimensiones de la imagen de fondo y de los 4 bordes
            setLocationRelativeTo(null); //Para centrar la ventana en la pantalla
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    
    
    
    
    
    private Musicas sounds = new Musicas("Music/inicio.wav");
    private Clip sound = sounds.getCancion();
    private JLabel background;
    private JLabel subtitulo;
    private JPanel entrada;
    private JTextField nickName;
    private JLabel subtitulo1;
    private JButton starGame;
    
}
