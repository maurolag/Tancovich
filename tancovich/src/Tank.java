import java.util.ArrayList;
import java.util.List;

public class Tank extends Sprite implements Entity {

	private int id;
    private int forward;
    private List<Missile> missiles;
    private List<Mine> mines;
    private boolean fireControl = false;
    private boolean mineControl = false;
    
    private final int[][] tankControls = {
    		
            {37, 38, 39, 40, 32, 17}, 
            {65, 87, 68, 83, 70, 71}, 
            {100, 104, 102, 101, 106, 109},
            {74, 73, 76, 75, 44, 46}
    };

    public Tank(int id, int x, int y) {
        super(x, y);
        this.id = id;
        init();
    }

    public void init() {

        if(id == 1)
        {
        	loadImage("Resources/tankRed.png");
        }
        else if(id == 2)
        {
        	loadImage("Resources/tankBlue.png");
        }
        
        missiles = new ArrayList<>();
        mines = new ArrayList<>();
    }
    
    public void update() {
    	
    	checkControls();
    	
    	x = x + (int)(Math.sin(Math.toRadians(-r)) * forward);
        y = y + (int)(Math.cos(Math.toRadians(-r)) * forward);
        
        if(id == 1)
        {
        	loadImage("Resources/tankRed.png", r);
        }
        else if(id == 2)
        {
        	loadImage("Resources/tankBlue.png", r);
        }
    }
    
    public void checkControls()
    {
    	if (Keyboard.keydown[tankControls[id-1][0]]) //Izquierda
    	{
    		r -= 5;
    	}        	
    	if (Keyboard.keydown[tankControls[id-1][2]]) //Derecha
    	{
    		r += 5;
    	}    	
    	if(!Keyboard.keydown[tankControls[id-1][3]] && !Keyboard.keydown[tankControls[id-1][1]])
    	{
    		if(forward > 0) forward -= 1;
    	}
    	else
    	{
        	if (Keyboard.keydown[tankControls[id-1][1]]) //Velocidad
        	{
        		forward = 5;
        	}
        	if (Keyboard.keydown[tankControls[id-1][3]]) //Freno
        	{
        		forward = -5;
        	}
    	}    	
    	if (Keyboard.keydown[tankControls[id-1][4]] && !fireControl) {
        	fire();
        	fireControl = true;
        }
    	if(!Keyboard.keydown[tankControls[id-1][4]]) // Tiro
    	{
    		fireControl = false;
    	}        
        if (Keyboard.keydown[tankControls[id-1][5]] && !mineControl) {
        	plant();
        	mineControl = true;
        }
        if(!Keyboard.keydown[tankControls[id-1][5]]) // Mina
        {
        	mineControl = false;
        }
    }
    
    public void fire()
    {       
    	missiles.add(new Missile(x + width / 2, y + height / 2, r));
    }
    
    public void plant() {
    	mines.add(new Mine(x + width / 2, y + height /2));
    }
    
    public List<Missile> getMissiles() {
        return missiles;
    }
    
    public List<Mine> getMines() {
        return mines;
    }
}