package TheCellar.GUI;

import TheCellar.Game;
import TheCellar.Main;
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
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The Cellar");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 38));
		lblNewLabel.setBounds(72, 28, 219, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JButton newGame = new JButton("New Game");
		newGame.setFont(new Font("Arial", Font.PLAIN, 21));
		newGame.setForeground(new Color(0, 0, 0));
		newGame.setBackground(new Color(116, 116, 116));
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Main.game = new Game();
				Main.game.GenerateAI();
//				Main.game.clearPurchasedUpgrades();
				GamePage window2 = new GamePage();
				GamePage.showWindow();
			}
		});
		newGame.setBounds(60, 95, 219, 70);
		frame.getContentPane().add(newGame);
		
		JTextArea textArea = new JTextArea("");
		textArea.setFont(new Font("Arial", Font.PLAIN, 8));
		textArea.setBounds(385, 11, 350, 379);
		frame.getContentPane().add(textArea);
		textArea.setVisible(false);
		textArea.setWrapStyleWord(true);
		
		JButton exitButton = new JButton("X");
		exitButton.setBackground(new Color(116, 116, 116));
		exitButton.setFont(new Font("Arial Black", Font.BOLD, 10));
		exitButton.setVisible(false);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setBounds(100, 100, 350, 450);
				textArea.setVisible(false);
				exitButton.setVisible(false);
			}
		});
		exitButton.setBounds(331, 11, 48, 45);
		frame.getContentPane().add(exitButton);
	
		
		
		JButton btnNewButton_1 = new JButton("Instructions");
		btnNewButton_1.setBackground(new Color(116, 116, 116));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 21));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setBounds(100, 100, 800, 450);
				textArea.setVisible(true);
				exitButton.setVisible(true);
				
			
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
		btnNewButton_1.setBounds(60, 303, 219, 70);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Load Save");
		btnNewButton_2.setBackground(new Color(116, 116, 116));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 21));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.game = SaveLoadSystem.loadGame();
				Main.game.JustLoaded();
				frame.setVisible(false);
				GamePage window2 = new GamePage();
			}
		});

		btnNewButton_2.setBounds(60, 198, 219, 70);
		frame.getContentPane().add(btnNewButton_2);
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new StartMenuPage();
		// TODO Auto-generated method stub


			
		}
	}


