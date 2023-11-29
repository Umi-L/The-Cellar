package TheCellar.GUI;

import TheCellar.SaveLoadSystem;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class StartMenuPage {
	private JFrame frame;
	
	
	public StartMenuPage() {
		frame = new JFrame("");
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start New TheCellar.Game");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 18, 29));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GamePage window2 = new GamePage();
				window2.showWindow();
			}
		});
		btnNewButton.setBounds(104, 118, 219, 70);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea("");
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		textArea.setBounds(451, 19, 323, 379);
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
						+ " Upgrade TheCellar.Equipment: Upgrade equipment by buying better equipment\n"
						+ " or upgrading old equipment in the shop."
						+ "\n"
						+ " This has the potential to increase the quality of your restaurant \n"
						+ " and your S/D"
						+ "\n"
						+ "\n"
						+ " Hire Employees: One way to upgrade your business quality and S/D\n "
						+ "is hiring employees that all have different levels of experience\n"
						+ " and skills. "
						+ "\n"
						+ " To do this, click the “Employee” button on the right hand side. \n"
						+ " Employees will be paid weekly."
						+ "\n"
						+ "\n"
						+ " Maintain Restaurant Cleanliness: Customers will not come to your \n"
						+ " restaurant if your cleanliness stat is less than 10%. To increase\n "
						+ "your restaurant cleanliness, you must hire cleaners by clicking\n"
						+ " the “Employee” button on the right hand side.\n"
						+ "\n"
						+ " Increase TheCellar.Food Quality: To increase food quality, you must click the\n "
						+ "“shop” on the right handside. \n"
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
		btnNewButton_1.setBounds(104, 276, 219, 70);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Load Save TheCellar.Game");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveLoadSystem.loadGame();
			}
		});

		btnNewButton_2.setBounds(104, 194, 219, 70);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("The Cellar");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(146, 41, 206, 56);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new StartMenuPage();
		// TODO Auto-generated method stub


			
		}
	}


