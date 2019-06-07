import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Tank extends Sprite {

    private int dx;
    private int dy;
    private List<Missile> missiles;

    public Tank(int x, int y) {
        super(x, y);
        initCraft();
    }

    private void initCraft() {

        missiles = new ArrayList<>();
        //loadImage("Resources/tank_bigRedDown.png");
        initGraph();        
    }
    
    public void drawTank() {    	
        //loadImage("Resources/tank_bigRedDown.png");
        //getImageDimensions();
    	initGraph();
    	
    }
    
    public void initGraph() {
    	
    	loadImage("Resources/tank_bigRedDown.png");
    	getImageDimensions();
    	this.g2d = (Graphics2D) image.getGraphics();
    	g2d.setColor(Color.black);
    }
    
    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            
            loadImage("Resources/tank_bigRedLeft.png");
            getImageDimensions();
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            
            loadImage("Resources/tank_bigRedRight.png");
            getImageDimensions();
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
            
            loadImage("Resources/tank_bigRedUp.png");
            getImageDimensions();
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
            
            loadImage("Resources/tank_bigRedDown.png");
            getImageDimensions();
        }
        
        if (key == KeyEvent.VK_SPACE) {
        	fire(e);
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
    public void fire(KeyEvent e)
    {       
    	missiles.add(new Missile(x + width, y + height / 2));
    }
}