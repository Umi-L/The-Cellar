package TheCellar.GUI;

import TheCellar.Main;
import TheCellar.SaveLoadSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class GameOverPage {
	private JFrame frame;
	public GameOverPage() {
		frame = new JFrame("");
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	
	
	JButton Quit = new JButton("Quit");
	Quit.setForeground(new Color(0, 0, 0));
	Quit.setBackground(new Color(255, 18, 29));
	Quit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SaveLoadSystem.saveGame(Main.game);
			System.exit(0);
		}
	});
	Quit.setForeground(Color.BLACK);
	Quit.setBackground(new Color(255, 18, 29));
	Quit.setBounds(116, 258, 219, 42);
	frame.getContentPane().add(Quit);
	
	JButton Restart = new JButton("Restart");
	Restart.setForeground(new Color(0, 0, 0));
	Restart.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new GamePage();
		}
	});
	Restart.setBounds(116, 171, 219, 42);
	frame.getContentPane().add(Restart);
	}
	public static void main(String[] args) {
		new GameOverPage();
		
		// TODO Auto-generated method stub

	}
}
