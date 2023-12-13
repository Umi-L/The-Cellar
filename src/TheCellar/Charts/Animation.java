package TheCellar.Charts;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.*;

public class Animation extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        int x = 0;
        int y = 0;

        int padding = 25;
        int barPadding = 5;
        int numYLabels = 5;
        
        g2.fillRect(100,100,100,100);
	}
}
