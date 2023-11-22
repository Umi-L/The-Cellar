import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class startMenu {
	private JFrame frame;
	
	
	public startMenu() {
		frame = new JFrame("");
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start New Game");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 18, 29));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(46, 44, 219, 70);
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
		btnNewButton_1.setBounds(46, 184, 219, 70);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Load Save Game");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(46, 112, 219, 70);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("The Cellar");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(86, 0, 206, 56);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new startMenu();
		// TODO Auto-generated method stub


			
		}
	}


