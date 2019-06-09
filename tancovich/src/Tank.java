import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Tank extends Sprite {

    private int forward;
    private List<Missile> missiles;
    private List <Mine> mines;

    public Tank(int x, int y) {
        super(x, y);
        initCraft();
    }

    private void initCraft() {

        missiles = new ArrayList<>();
        mines = new ArrayList<Mine>();
        
        loadImage("Resources/tankRed.png");
    	  getImageDimensions();

    }
    
    public void move() {

    	x = (int)(x + (Math.sin(Math.toRadians(-r)) * forward));
        y = (int)(y + (Math.cos(Math.toRadians(-r)) * forward));
    }

    public List<Missile> getMissiles() {
        return missiles;
    }
    
    public List<Mine> getMines(){
    	return mines;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
        	r -= 5;
        	loadImage("Resources/tankRed.png");
        	getImageDimensions();
        	rotateImageByDegrees(r);
        }

        if (key == KeyEvent.VK_RIGHT) {
        	r += 5;
        	loadImage("Resources/tankRed.png");
        	getImageDimensions();
        	rotateImageByDegrees(r);
        }

        if (key == KeyEvent.VK_UP) {
            forward = 5;
        }

        if (key == KeyEvent.VK_DOWN) {
            forward = -5;
        }
        
        if (key == KeyEvent.VK_SPACE) {
        	fire(e);
        }
        
        if (key == KeyEvent.VK_C) {
        	plantMines(e);
        }
        
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

        }

        if (key == KeyEvent.VK_RIGHT) {

        }

        if (key == KeyEvent.VK_UP) {
            forward = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            forward = 0;
        }
    }
    
    public void fire(KeyEvent e)
    {       
    	missiles.add(new Missile(x + width, y + height / 2));
    }
    
    public void plantMines (KeyEvent e) {
    	mines.add(new Mine(x + width, y + height /2));
    }
}