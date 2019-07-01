import java.util.ArrayList;
import java.util.List;

public class Tank extends Sprite implements Entity {

	private int id;
    private int forward;
    private int health = 100;
    private int impacts = 0;
    private List<Missile> missiles;
    private List<Mine> mines;
    private boolean canForward = true;
    private boolean canBack = true;
    private boolean fireControl = false;
    private boolean mineControl = false;    

	private final int[][] tankControls = {
    		    		
            {37, 38, 39, 40, 32, 17}, 
            {65, 87, 68, 83, 70, 71},
            {74, 73, 76, 75, 79, 80},
    		{100, 104, 102, 101, 106, 109}            
            
    };

    public Tank(int id, int x, int y) {
        super(x, y);
        this.id = id;
        init();
    }
    
    public int getId() {
		return this.id;
	}
    
    public int getForward() {
		return forward;		
	}
	
	public void setForward(int forward) {
		this.forward = forward;
	}
	
	public boolean isCanForward() {
		return canForward;
	}
	
	public void setCanForward(boolean canForward) {
		this.canForward = canForward;
	}
	
	public boolean isCanBack() {
		return canBack;
	}
	
	public void setCanBack(boolean canBack) {
		this.canBack = canBack;
	}	

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
    
    public int getImpacts() {
		return impacts;
	}

	public void setImpacts(int impacts) {
		this.impacts = impacts;
	}

	public List<Missile> getMissiles() {
        return missiles;
    }
    
    public List<Mine> getMines() {
        return mines;
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
        
        if(isVisible())
        {
        	if(this.getHealth() > 0)
        	{
        		checkControls();
            	
            	x = x + (int)(Math.sin(Math.toRadians(-r)) * getForward());
                y = y + (int)(Math.cos(Math.toRadians(-r)) * getForward());
        		
        		if(id == 1)
                {
                	loadImage("Resources/tankRed.png", r);
                }
                else if(id == 2)
                {
                	loadImage("Resources/tankBlue.png", r);
                }
        	}
        	else
        	{
        		if(this.isAlive()) this.setAlive(false);
        		explodeSprite(30);
        	}
        }        
    }
    
    public void checkControls()
    {
    	if (Keyboard.keydown[tankControls[id-1][0]]) //Izquierda
    	{
    		if(forward >= 0) setR(getR()-5);
    		else setR(getR()+5);
    		
    	}
    	if (Keyboard.keydown[tankControls[id-1][2]]) //Derecha
    	{
    		if(forward >= 0) setR(getR()+5);
    		else setR(getR()-5);
    	}
    	if(!Keyboard.keydown[tankControls[id-1][3]] && !Keyboard.keydown[tankControls[id-1][1]])
    	{
    		setForward(0);
    	}
    	else
    	{
        	if (isCanForward() && Keyboard.keydown[tankControls[id-1][1]]) //Marcha adelante
        	{
        		setForward(5);
        	}
        	if (isCanBack() && Keyboard.keydown[tankControls[id-1][3]]) //Marcha atras
        	{
        		setForward(-5);
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
    	missiles.add(new Missile(x + width / 2, y + height / 2, r, getId()));
    }
    
    public void plant() {
    	mines.add(new Mine(x + width / 2, y + height /2));
    }
    
    public ArrayList<Integer> calculateNextPosition(boolean forward)
    {
    	ArrayList<Integer> nextPos = new ArrayList<Integer>();
    	nextPos.add(getX() + (int)(Math.sin(Math.toRadians(-getR())) * (forward ? 5 : -5)));
    	nextPos.add(getY() + (int)(Math.cos(Math.toRadians(-getR())) * (forward ? 5 : -5)));
    	return nextPos;
    }
}