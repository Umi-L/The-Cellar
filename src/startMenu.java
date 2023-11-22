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
	private JPanel panel;
	
	public startMenu() {
		frame = new JFrame("");
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start New Game");
		btnNewButton.setForeground(new Color(234, 31, 17));
		btnNewButton.setBackground(new Color(255, 18, 29));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(46, 44, 219, 70);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 6, 219, 260);
		frame.getContentPane().add(scrollPane);
		scrollPane.setVisible(false);
		
		JTextArea textArea = new JTextArea("");
		
		JButton btnNewButton_1 = new JButton("Load Instructions");
		btnNewButton_1.setForeground(new Color(196, 40, 38));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(true);
				scrollPane.add(textArea);
				textArea.setText("");
		
			}
		});
		btnNewButton_1.setBounds(46, 184, 219, 70);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Load Save Game");
		btnNewButton_2.setForeground(new Color(214, 39, 20));
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


