import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Tank extends Sprite {

    private int dx;
    private int dy;
    private int dr;
    private List<Missile> missiles;

    public Tank(int x, int y) {
        super(x, y);
        initCraft();
    }

    private void initCraft() {

        missiles = new ArrayList<>();
        loadImage("Resources/tank_bigRed.png");
    	getImageDimensions();
    	rotateImageByDegrees(45);
    }
    
    public void move() {

        x += dx;
        y += dy;
        r += dr;

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
        	r -= 10;
        	loadImage("Resources/tank_bigRed.png");
        	getImageDimensions();
        	rotateImageByDegrees(r);
            //dx = -1;
            
            /*loadImage("Resources/tank_bigRedLeft.png");
            getImageDimensions();
            image = rotateImageByDegrees(image, 45);*/
        }

        if (key == KeyEvent.VK_RIGHT) {
        	r += 10;
        	loadImage("Resources/tank_bigRed.png");
        	getImageDimensions();
        	rotateImageByDegrees(r);
        	
            //dx = 1;
            
            /*
            */
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
            
            //loadImage("Resources/tank_bigRedUp.png");
            //getImageDimensions();
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
            
            //loadImage("Resources/tank_bigRedDown.png");
            //getImageDimensions();
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