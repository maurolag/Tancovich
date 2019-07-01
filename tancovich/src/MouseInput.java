import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MouseInput extends MouseAdapter {

	Board board;
	
	
	public MouseInput(Board board) {
		this.board = board;
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		board.mouseEntered(e);
	}

	public void mouseExited(MouseEvent e) {
				
	}

	public void mousePressed(MouseEvent e) { //Mouse Action
		
	board.mousePressed(e);
	
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
