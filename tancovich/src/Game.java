<<<<<<< HEAD:tancovich/src/Game.java
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Game extends JFrame {

	private static final long serialVersionUID = 1L;

	public Game() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setResizable(false);
        pack();

        setTitle("Tancovich");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Game game = new Game();
            game.setVisible(true);
        });
    }
=======
import java.awt.EventQueue;
import javax.swing.JFrame;

public class CollisionEx extends JFrame {

	private static final long serialVersionUID = 1L;

	public CollisionEx() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setResizable(false);
        pack();

        setTitle("Collision");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            CollisionEx ex = new CollisionEx();
            ex.setVisible(true);
        });
    }
>>>>>>> refs/remotes/origin/master:tancovich/src/CollisionEx.java
}