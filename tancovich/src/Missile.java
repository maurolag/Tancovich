public class Missile extends Sprite implements Entity {

    private final int BOARD_WIDTH = 800;
    private final int BOARD_HEIGHT = 600;
    private final int MISSILE_SPEED = 10;
    private int bounce = 0;
    private int shooterId;
    private int damage;

    public Missile(int x, int y, int r, int shooter) {
        super(x, y, r);
        setDamage();
        setShooterId(shooter);
        init();
    }

    public void init() {
    	
    	if(shooterId == 1) {
    		loadImage("Resources/bulletRed.png", 180+r);
    	}else {
    		loadImage("Resources/bulletBlue.png", 180+r);
    	}
        
    }

    public void update() {

    	x = x + (int)(Math.sin(Math.toRadians(-r)) * MISSILE_SPEED);
        y = y + (int)(Math.cos(Math.toRadians(-r)) * MISSILE_SPEED);

        if (x < 0 || x > BOARD_WIDTH - this.width)
        {
        	r = -r;
        	bounce++;
        }
        
        if (y < 0 || y > BOARD_HEIGHT - this.height)
        {
        	r = 180-r;
        	bounce++;
        }
        
        if(bounce >= 3)
        {
        	this.visible = false;
        }
        
        if(shooterId == 1) {
    		loadImage("Resources/bulletRed.png", 180+r);
    	}else {
    		loadImage("Resources/bulletBlue.png", 180+r);
    	}
    }
    public void boxRebound (int xBox, int yBox, int heightBox, int widthBox) {
    	
    	if (x > xBox - 7 && x < xBox + widthBox - 5 && y < yBox  || x > xBox - 10 && x < xBox + widthBox -5  && y < yBox + heightBox) {
    		r = 180 - r;
    		bounce++;
	}        	
    	else{
    		r = -r;
    		bounce++;
    	}
    }

	public int getBounce() {
		return bounce;
	}

	public void setBounce(int bounce) {
		this.bounce = bounce;
	}

	public int getShooterId() {
		return shooterId;
	}

	public void setShooterId(int shooterId) {
		this.shooterId = shooterId;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage() {
		this.damage = randomWithRange(18, 32);
	}
	
	int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
    
}
