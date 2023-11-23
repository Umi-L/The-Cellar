package TheCellar.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HirePage {
	private JFrame frame;
	
	public static void showWindow() {
		
	}
	
	public HirePage() {
		frame = new JFrame("");
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Resume TheCellar.Game");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 18, 29));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GamePage window2 = new GamePage();
				window2.showWindow();
		
		}
	});
	btnNewButton.setBounds(300, 346, 219, 70);
	frame.getContentPane().add(btnNewButton);
	
	JLabel lblNewLabel = new JLabel("Hire");
	lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
	lblNewLabel.setBounds(375, 6, 78, 23);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("CHEFS");
	lblNewLabel_1.setBounds(6, 41, 61, 16);
	frame.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("CLEANERS");
	lblNewLabel_2.setBounds(6, 182, 78, 16);
	frame.getContentPane().add(lblNewLabel_2);
	
	frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new HirePage();
		showWindow();
		// TODO Auto-generated method stub

	}
}

