package TheCellar.Charts;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import TheCellar.GUI.GamePage;
import TheCellar.GUI.PauseMenuPage;

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
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			try {
				GamePage.frame.setVisible(false);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PauseMenuPage pause = new TheCellar.GUI.PauseMenuPage();
		}
		
	}
	
}
