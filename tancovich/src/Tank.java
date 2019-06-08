import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Tank extends Sprite {

    private int forward;
    private List<Missile> missiles;

    public Tank(int x, int y) {
        super(x, y);
        initCraft();
    }

    private void initCraft() {

        missiles = new ArrayList<>();
        loadImage("Resources/tank_bigRed.png");
    	getImageDimensions();
    }
    
    public void move() {

    	x = (int)(x + (Math.sin(Math.toRadians(-r)) * forward));
        y = (int)(y + (Math.cos(Math.toRadians(-r)) * forward));
    	/*x
        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }*/
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
        	r -= 5;
        	loadImage("Resources/tank_bigRed.png");
        	getImageDimensions();
        	rotateImageByDegrees(r);
        }

        if (key == KeyEvent.VK_RIGHT) {
        	r += 5;
        	loadImage("Resources/tank_bigRed.png");
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
}