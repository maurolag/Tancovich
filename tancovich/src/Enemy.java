public class Enemy extends Sprite implements Entity {

    private final int INITIAL_X = 400;

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
        
        if(isVisible() && isAlive())
        {
        	x -= 1;
        }        
    } 
}