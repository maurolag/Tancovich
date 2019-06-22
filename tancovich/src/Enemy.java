public class Enemy extends Sprite implements Entity {

    private final int INITIAL_X = 400;
    private boolean alive = true;
    private int explosionCounter = 0;
    
    private int[][] explosionTimer = 
    	{
    		{1, 6},
    		{7, 12},
    		{13, 18},
    		{19, 24},
    		{25, 30}
    	};

    public Enemy(int x, int y) {
        super(x, y);
        init();
    }

    public void init() {

        loadImage("Resources/tankBlue.png");
        getImageDimensions();
    }
    
    public void destroyEnemy() {
        
    	alive = false;
    }

    public void update() {

        if (x < 0) {
            x = INITIAL_X;
        }
        
        if(this.isVisible())
        {
        	if(isAlive())
            {
            	x -= 1;
            }
            else
            {
            	for(int i = 0; i < explosionTimer.length; i++)
            	{
            		if(isBetween(explosionCounter,explosionTimer[i][0],explosionTimer[i][1]))
            		{
            			loadImage("Resources/explosion"+(i+1)+".png");
            			explosionCounter++;
            		}
            	}
            	explosionCounter++;
                if(explosionCounter >= 30)
                {
                	this.setVisible(false);
                }            	
            }
        }        
    }
    
    public boolean isBetween(int x, int lower, int upper) {
    	return lower <= x && x <= upper;
    }

	public boolean isAlive() {
		return alive;
	}   
}