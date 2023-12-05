package TheCellar.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class ChefUpgrades {
	private JFrame frame;

	public static void showWindow() {

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public ChefUpgrades() {

		frame = new JFrame("");
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 18, 29));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TheCellar.GUI.ShopPage window2 = new TheCellar.GUI.ShopPage();
				window2.showWindow();
			}

		});

		btnNewButton.setBounds(300, 346, 219, 70);
		frame.getContentPane().add(btnNewButton);

		JLabel titleLabel = new JLabel("Upgrade Chefs");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		titleLabel.setBounds(341, -10, 150, 44);
		frame.getContentPane().add(titleLabel);

		JLabel currentChefsLabel = new JLabel("Current Chefs:");
		currentChefsLabel.setBounds(17, 46, 124, 16);
		frame.getContentPane().add(currentChefsLabel);

		JLabel lblNewLabel_1 = new JLabel("Current Chefs:");
		lblNewLabel_1.setBounds(351, 46, 124, 16);
		frame.getContentPane().add(lblNewLabel_1);
		JLabel currentChefsLabel = new JLabel("Current Chefs:");
		currentChefsLabel.setBounds(17, 46, 124, 16);
		frame.getContentPane().add(currentChefsLabel);


		JButton btnNewButton_2 = new JButton("Upgrade");
		btnNewButton_2.setBounds(341, 74, 117, 29);
		btnNewButton_2.setVisible(false);	
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnNewButton_3 = new JButton("Train");
		btnNewButton_3.setBounds(585, 74, 117, 29);
		btnNewButton_3.setVisible(false);
		frame.getContentPane().add(btnNewButton_3);


		JButton btnNewButton_1 = new JButton("Teenage Chef");
		btnNewButton_1.setBounds(97, 74, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});


		JButton button = new JButton("Teenage Chef");
		button.setBounds(0, 67, 117, 29);
		frame.getContentPane().add(button);

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnNewButton_2.setVisible(true);
				btnNewButton_3.setVisible(true);
			}
		});

		JLabel lblNewLabel_2 = new JLabel("Click on a chef to upgrade or train chef");
		lblNewLabel_2.setBounds(17, 372, 284, 44);
		frame.getContentPane().add(lblNewLabel_2);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new TheCellar.GUI.chefUpgrades();
		showWindow();
	}
}