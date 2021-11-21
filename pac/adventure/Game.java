/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac.adventure;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class Game  extends JFrame{

    public Game()  {
        
        super("Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initComponents();
        this.addWindowListener(new WindowsEvents());
        
    }
    
    
    public void initComponents() {

//        this.getContentPane().setLayout(null);
        this.setResizable(false);
        
        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);

        this.setLocationRelativeTo(null);
        
        
        gamePanel.setupGame();
        gamePanel.starGameThread();

    }
    
    
    
   
    
    class WindowsEvents extends WindowAdapter {

        @Override
        public void windowOpened(WindowEvent e) {
            Insets inset = getInsets();
            setSize(0 + inset.left + inset.right, 0 + inset.bottom + inset.top); //Adecuar el tamaño de la ventana a abrir tomando en cuenta 
            //las dimensiones de la imagen de fondo y de los 4 bordes
            pack();
            setLocationRelativeTo(null); //Para centrar la ventana en la pantalla
            
            
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    
    
    
    
}
