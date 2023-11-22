import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class pauseMenu {
	private JFrame frame;
	
	public static void showWindow() {
		
	}

	public pauseMenu() {
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
		btnNewButton.setBounds(116, 127, 219, 42);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea("");
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		textArea.setBounds(451, 19, 297, 379);
		frame.getContentPane().add(textArea);
		textArea.setVisible(false);
		textArea.setWrapStyleWord(true);
	
		
		
		JButton btnNewButton_1 = new JButton("Load Instructions");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(true);
				
			
				textArea.setText(" The Cellar is a tycoon style steak house management game where.\n"
						+ " you have to maintain your business and compete against other\n"
						+ " businesses.\n"
						+ "\n"
						+ " You can control how fast and how slow you want time occur by using \n"
						+ " slider"
						+ "\n"
						+ "\n"
						+ " To do this you must:\n"
						+ "\n"
						+ " Upgrade Equipment: Upgrade equipment by buying better equipment\n"
						+ " or upgrading old equipment in the shop."
						+ "\n"
						+ " This has the potential to increase the quality of your restaurant \n"
						+ " and your S/D"
						+ "\n"
						+ "\n"
						+ " Hire Employees: One way to upgrade your business quality and S/D\n "
						+ " is hiring employees that all have different levels of experience\n"
						+ " and skills. "
						+ "\n"
						+ " To do this, click the “Employee” button on the right hand side. \n"
						+ " Employees will be paid weekly."
						+ "\n"
						+ "\n"
						+ " Maintain Restaurant Cleanliness: Customers will not come to your \n"
						+ " restaurant if your cleanliness stat is less than 10%. To increase\n "
						+ " your restaurant cleanliness, you must hire cleaners by clicking\n"
						+ " the “Employee” button on the right hand side.\n"
						+ "\n"
						+ " Increase Food Quality: To increase food quality, you must click the\n "
						+ " “shop” on the right handside. \n"
						+ " The higher the quality of the food, "
						+ " the more likely customers will\n"
						+ " buy food for a higher price,\n"
						+ " increasing your profit \n"
						+ "\n"
						+ " In order to win, you must be the top company by net worth.\n"
						+ " You cannot win if you have any debt.\n"
						+ "\n"
						+ " If you are in debt for more than 4 weeks, you lose the game.\n"
						+ "\n"
						+ " You can pause the game at any time.");
				
			}
		});
		btnNewButton_1.setBounds(116, 215, 219, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Are you sure?");
		lblNewLabel_1.setBounds(347, 171, 97, 16);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JButton btnNewButton_4 = new JButton("Yes");
		btnNewButton_4.setVisible(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new GamePage();
			}
		});
		btnNewButton_4.setBounds(339, 199, 52, 16);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("No");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setVisible(false);
				btnNewButton_4.setVisible(false);
				btnNewButton_4_1.setVisible(false);
			}
		});
		btnNewButton_4_1.setVisible(false);
		btnNewButton_4_1.setBounds(392, 199, 52, 16);
		frame.getContentPane().add(btnNewButton_4_1);
		
		
		
		JButton btnNewButton_2 = new JButton("Restart Game");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setVisible(true);
				btnNewButton_4.setVisible(true);
				btnNewButton_4_1.setVisible(true);
				
				
			
				
			}
		});
		btnNewButton_2.setBounds(116, 171, 219, 42);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save And Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBackground(new Color(255, 18, 29));
		btnNewButton_3.setBounds(116, 258, 219, 42);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("GAME PAUSED");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(143, 93, 219, 32);
		frame.getContentPane().add(lblNewLabel);
	
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new pauseMenu();
		showWindow();
		
		// TODO Auto-generated method stub

	}
}
