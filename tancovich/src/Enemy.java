import java.util.ArrayList;
import java.util.List;
import java.awt.Image;

public class Enemy extends Sprite {

    private final int INITIAL_X = 400;

    public Enemy(int x, int y) {
        super(x, y);

        initEnemy();
    }

    private void initEnemy() {

        loadImage("src/Resources/tank_blue.png");
        getImageDimensions();
    }
    
    public void destroyEnemy() {
        
		loadImage("src/Resources/explosion2.png");
		getImageDimensions();
    	
    	List<Image> explosion = new ArrayList<Image>();

    		loadImage("src/Resources/explosion1.png");
    		explosion.add(getImage());
    		getImageDimensions();

    		loadImage("src/Resources/explosion2.png");
    		explosion.add(getImage());
    		getImageDimensions();

    		loadImage("src/Resources/explosion3.png");
    		explosion.add(getImage());
    		getImageDimensions();

    		loadImage("src/Resources/explosion4.png");
    		explosion.add(getImage());
    		getImageDimensions();

    		loadImage("src/Resources/explosion5.png");
    		explosion.add(getImage());
    		getImageDimensions();

    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }
}