import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// window builder class that creates the gui
// was mainly auto generated by eclipse
public class WindowBuilder extends JFrame {
	public boolean textListenerEnabled = true;

	/**
	 * Create the frame.
	 */
	public WindowBuilder() {
		// set title
		setTitle("Palindrome Checker");

		// set close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		getContentPane().setLayout(null);
		
		Button button = new Button("Bank");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("SansSerif", Font.BOLD, 18));
		button.setBackground(new Color(248, 242, 22));
		button.setBounds(693, 54, 81, 81);
		getContentPane().add(button);
		
		JButton btnNewButton = new JButton("Pause Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(6, 5, 119, 41);
		getContentPane().add(btnNewButton);
		
		JSlider slider = new JSlider();
		slider.setBounds(10, 374, 200, 26);
		getContentPane().add(slider);
		
		JLabel lblNewLabel = new JLabel("Game Speed");
		lblNewLabel.setBounds(80, 359, 81, 14);
		getContentPane().add(lblNewLabel);
		
		Button button_1 = new Button("Shop");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		button_1.setBackground(new Color(0, 255, 255));
		button_1.setBounds(693, 141, 81, 81);
		getContentPane().add(button_1);
		
		JLabel lblNewLabel_1 = new JLabel("$10,000");
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(697, 8, 81, 38);
		getContentPane().add(lblNewLabel_1);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(192, 192, 192));
		canvas.setBounds(0, 54, 125, 289);
		getContentPane().add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(Color.LIGHT_GRAY);
		canvas_1.setBounds(131, 0, 556, 343);
		getContentPane().add(canvas_1);
		
		Button button_1_1 = new Button("Chefs");
		button_1_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		button_1_1.setBackground(new Color(255, 0, 255));
		button_1_1.setBounds(693, 228, 81, 81);
		getContentPane().add(button_1_1);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
