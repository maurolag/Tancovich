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

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }
}