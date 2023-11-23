package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShopPage {
	private JFrame frame;
	
	public static void showWindow() {
		
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public ShopPage() {
		frame = new JFrame("");
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Resume Game");
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
	
	JLabel lblNewLabel = new JLabel("Shop");
	lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
	lblNewLabel.setBounds(373, 6, 61, 30);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("EQUIPMENT UPGRADES");
	lblNewLabel_1.setBounds(6, 45, 144, 16);
	frame.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("FOOD UPGRADES");
	lblNewLabel_2.setBounds(357, 45, 133, 16);
	frame.getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("KNIFE UPGRADES");
	lblNewLabel_3.setBounds(658, 45, 117, 16);
	frame.getContentPane().add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("CHEF UPGRADES");
	lblNewLabel_4.setBounds(6, 205, 133, 16);
	frame.getContentPane().add(lblNewLabel_4);
	
	frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new BankPage();
		showWindow();
		// TODO Auto-generated method stub

	}
}
