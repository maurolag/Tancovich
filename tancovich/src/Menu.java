import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Menu {
	
    private BufferedImage background;
    private JLabel label = new JLabel("");

    public JLabel getLabel() { 
    	return this.label;
    } 
    		
	public void render (Graphics g) { //Menu PORTADA 
		try {
        	background = ImageIO.read(getClass().getResourceAsStream("Resources/LOAD2.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    	g.drawImage(background, 0, 0, null);
	}
	
	public void render2 (Graphics g) { //Menu OPTIONS 
		try {
        	background = ImageIO.read(getClass().getResourceAsStream("Resources/MENU1(PASIVO).jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    	g.drawImage(background, 0, 0, null);
    	JLabel label = new JLabel("");
		label.setBounds(322, 217, 142, 48);
	}	
	
	public void render3 (Graphics g) { //Menu HELP 
		try {
        	background = ImageIO.read(getClass().getResourceAsStream("Resources/HOWTOPLAY.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    	g.drawImage(background, 0, 0, null);
	}
	
	public void render4 (Graphics g) {
		try {
        	background = ImageIO.read(getClass().getResourceAsStream("Resources/LOAD2.jpg")); //FALTA CREAR PANEL CREDITOS
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    	g.drawImage(background, 0, 0, null);
	}	

}
