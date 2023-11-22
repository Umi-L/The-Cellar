import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

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
		btnNewButton.setBounds(46, 44, 219, 42);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea("");
		textArea.setBounds(321, 6, 453, 379);
		frame.getContentPane().add(textArea);
		textArea.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Load Instructions");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(true);
				textArea.setText("The Cellar is a tycoon style steak house management game where.\n"
						+ "you have to maintain your business and compete against other\n"
						+ "businesses.\n"
						+ "\n"
						+ "You can control how fast and how slow you want time occur by using \n"
						+ "slider"
						+ "\n"
						+ "\n"
						+ "To do this you must:\n"
						+ "\n"
						+ "Upgrade Equipment: Upgrade equipment by buying better equipment\n"
						+ "or upgrading old equipment in the shop."
						+ "\n"
						+ "This has the potential to increase the quality of your restaurant \n"
						+ "and your S/D"
						+ "\n"
						+ "Hire Employees: One way to upgrade your business quality and S/D\n "
						+ "is hiring employees that all have different levels of experience\n"
						+ " and skills. "
						+ "\n"
						+ "To do this, click the “Employee” button on the right hand side. \n"
						+ "Employees will be paid weekly."
						+ "\n"
						+ "\n"
						+ "Maintain Restaurant Cleanliness: Customers will not come to your \n"
						+ "restaurant if your cleanliness stat is less than 10%. To increase\n "
						+ "your restaurant cleanliness, you must hire cleaners by clicking\n"
						+ "the “Employee” button on the right hand side.\n"
						+ "\n"
						+ "\n"
						+ "Increase Food Quality: To increase food quality, you must click the\n "
						+ "“shop” on the right handside. The higher the quality of the food, "
						+ "the more likely customers will buy food for a higher price,\n"
						+ "increasing your profit \n"
						+ "\n"
						+ "In order to win, you must be the top company by net worth.\n "
						+ "You cannot win if you have any debt.\n"
						+ "\n"
						+ "If you are in debt for more than 4 weeks, you lose the game.\n"
						+ "\n"
						+ "You can pause the game at any time.");
				
			}
		});
		btnNewButton_1.setBounds(46, 127, 219, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Restart Game");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(46, 86, 219, 42);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save And Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBackground(new Color(255, 18, 29));
		btnNewButton_3.setBounds(46, 170, 219, 42);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("GAME PAUSED");
		lblNewLabel.setBounds(115, 6, 219, 32);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new pauseMenu();
		showWindow();
		
		// TODO Auto-generated method stub

	}
}
