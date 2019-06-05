import java.awt.EventQueue;

public class Main {

  public static void main(String[] args) {

      EventQueue.invokeLater(() -> {
          CollisionEx ex = new CollisionEx();
          ex.setVisible(true);
      });
  }
}
