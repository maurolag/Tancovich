import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Tank extends Sprite {

	private int id;
    private int forward;
    private List<Missile> missiles;
    private List<Mine> mines;

    public Tank(int id, int x, int y) {
        super(x, y);
        this.id = id;
        initCraft();
    }

    private void initCraft() {

        missiles = new ArrayList<>();
        mines = new ArrayList<>();
        if(id == 1)
        {
        	loadImage("Resources/tankRed.png");
        }
        else if(id == 2)
        {
        	loadImage("Resources/tankBlue.png");
        }
    	getImageDimensions();
    }
    
    public void move() {

    	if(id == 1)
    	{
    		if (Keyboard.keydown[37])
        	{
        		r -= 5;
        	}        	
        	if (Keyboard.keydown[39])
        	{
        		r += 5;
        	}
        	
        	if(!Keyboard.keydown[40] && !Keyboard.keydown[38])
        	{
        		forward = 0;
        	}
        	else
        	{
	        	if (Keyboard.keydown[38])
	        	{
	        		forward = 5;
	        	}
	        	if (Keyboard.keydown[40])
	        	{
	        		forward = -5;
	        	}
        	}
        	
        	if (Keyboard.keydown[32]) {
            	fire();
            }
            
            if (Keyboard.keydown[67]) {
            	plantMines();
            }
    	}
    	else if(id == 2)
    	{
    		if (Keyboard.keydown[65])
        	{
        		r -= 5;
        	}        	
        	if (Keyboard.keydown[68])
        	{
        		r += 5;
        	}
        	
        	if(!Keyboard.keydown[87] && !Keyboard.keydown[83])
        	{
        		forward = 0;
        	}
        	else
        	{
	        	if (Keyboard.keydown[87])
	        	{
	        		forward = 5;
	        	}
	        	if (Keyboard.keydown[83])
	        	{
	        		forward = -5;
	        	}
        	}
    		
    		if (Keyboard.keydown[70]) {
            	fire();
            }
            
            if (Keyboard.keydown[71]) {
            	plantMines();
            }
    	}
    	
    	
    	x = (int)(x + (Math.sin(Math.toRadians(-r)) * forward));
        y = (int)(y + (Math.cos(Math.toRadians(-r)) * forward));
        
        if(id == 1)
        {
        	loadImage("Resources/tankRed.png");
        	getImageDimensions();
        	rotateImageByDegrees(r);
        }
        else if(id == 2)
        {
        	loadImage("Resources/tankBlue.png");
        	getImageDimensions();
        	rotateImageByDegrees(r);
        }
    }

    public List<Missile> getMissiles() {
        return missiles;
    }
    
    public List<Mine> getMines() {
        return mines;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if(id == 1)
        {
            if (key == KeyEvent.VK_LEFT) {
            	r -= 5;
            }

            if (key == KeyEvent.VK_RIGHT) {
            	r += 5;
            }

            if (key == KeyEvent.VK_UP) {
                forward = 5;
            }

            if (key == KeyEvent.VK_DOWN) {
                forward = -5;
            }
            
            if (key == KeyEvent.VK_SPACE) {
            	fire();
            }            
            if (key == KeyEvent.VK_C) {
            	plantMines();
            }
        }
        else if(id == 2)
        {
        	if (key == KeyEvent.VK_A) {
            	r -= 5;
            }

            if (key == KeyEvent.VK_D) {
            	r += 5;
            }

            if (key == KeyEvent.VK_W) {
                forward = 5;
            }

            if (key == KeyEvent.VK_S) {
                forward = -5;
            }
            
            if (key == KeyEvent.VK_F) {
            	fire();
            }
            
            if (key == KeyEvent.VK_G) {
            	plantMines();
            }
        }
    }
    
    public void fire()
    {       
    	missiles.add(new Missile(x + width / 2, y + height / 2, this.r));
    }
    
    public void plantMines() {
    	mines.add(new Mine(x + width / 2, y + height /2));
    }
}