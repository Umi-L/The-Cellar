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
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Resume Game");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 18, 29));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(46, 44, 219, 42);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea("");
		textArea.setBounds(348, 6, 219, 260);
		frame.getContentPane().add(textArea);
		textArea.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Load Instructions");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(true);
				textArea.setText("GAME INSTRUCTIONS WILL GO HERE");
				
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
