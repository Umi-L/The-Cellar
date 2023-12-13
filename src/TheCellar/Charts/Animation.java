package TheCellar.Charts;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Animation extends JPanel {
	
	private int  xMove = 0, yMove = 0;
	public Animation() {
		addKeyListener(new Inputs(this));
	}
	
	public void ChangexMove(int change) {
		this.xMove += change;
		if (yMove !=100) {
			repaint();
		}
	}
	
	public void ChangeyMove(int change) {
		this.yMove += change;
		if (yMove !=100) {
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        int x = 0;
        int y = 0;

        int padding = 25;
        int barPadding = 5;
        int numYLabels = 5;
        
		g2.fillRect(0 + xMove,0 + yMove, 100, 100);
	}
}
