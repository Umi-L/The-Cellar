package TheCellar.Charts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Inputs implements KeyListener{
	
	private Animation animation;
	public Inputs(Animation animation) {
		this.animation = animation;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_W:
			animation.ChangeyMove(-5);
			break;
		case KeyEvent.VK_A:
			animation.ChangexMove(-5);
			break;
		case KeyEvent.VK_S:
			animation.ChangeyMove(+5);
			break;
		case KeyEvent.VK_D:
			animation.ChangexMove(+5);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
