
public class Mine extends Sprite{
	
    private final int BOARD_WIDTH = 800;
    private final int POSITION_MINE = 0;
	
	public Mine(int x, int y) {
		super(x, y);
		
		initMine();
	}
    
	private void initMine() {

        loadImage("Resources/mina.png");
        getImageDimensions();
    }

    public void plantMine() {
    	
    	x += POSITION_MINE;
    	
        if (x > BOARD_WIDTH)
            visible = false;
    }
}