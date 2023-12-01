package TheCellar.GUI;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JToggleButton;

public class HirePage {
	private JFrame frame;
	
	public static void showWindow() {
		
	}
	
	public HirePage() {
		frame = new JFrame("");
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton resumeButton = new JButton("Resume");
		resumeButton.setFont(new Font("Dialog", Font.PLAIN, 36));
		resumeButton.setForeground(new Color(0, 0, 0));
		resumeButton.setBackground(new Color(255, 18, 29));
		resumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.setVisible(false);
				//GamePage window2 = new GamePage();
				//window2.showWindow();
		
		}
	});
	resumeButton.setBounds(300, 346, 219, 70);
	frame.getContentPane().add(resumeButton);
	
	JLabel lblNewLabel = new JLabel("HIRING PAGE");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
	lblNewLabel.setBounds(281, 10, 204, 23);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel chefsLabel = new JLabel("CHEFS");
	chefsLabel.setFont(new Font("Dialog", Font.BOLD, 12));
	chefsLabel.setBounds(557, 54, 61, 16);
	frame.getContentPane().add(chefsLabel);
	
	JLabel cleanersLabel = new JLabel("CLEANERS");
	cleanersLabel.setFont(new Font("Dialog", Font.BOLD, 12));
	cleanersLabel.setBounds(568, 228, 78, 16);
	frame.getContentPane().add(cleanersLabel);
	
	JButton teenHireButton = new JButton("Hire");
	teenHireButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	teenHireButton.setBounds(479, 94, 61, 17);
	frame.getContentPane().add(teenHireButton);
	
	JLabel teenLabel = new JLabel("Teenage Chef ($500/week)");
	teenLabel.setBounds(557, 96, 255, 13);
	frame.getContentPane().add(teenLabel);
	
	JLabel gradLabel = new JLabel("Culinary School Grad ($2,000/week)");
	gradLabel.setBounds(557, 138, 255, 13);
	frame.getContentPane().add(gradLabel);
	
	JLabel currentChefs = new JLabel("Gordon Ramsay ($10,000/week)");
	currentChefs.setBounds(557, 176, 255, 13);
	frame.getContentPane().add(currentChefs);
	
	JLabel networthLabel = new JLabel("Current Networth:");
	networthLabel.setBounds(10, 20, 120, 13);
	frame.getContentPane().add(networthLabel);
	
	JButton gradHireButton = new JButton("Hire");
	gradHireButton.setBounds(479, 136, 61, 17);
	frame.getContentPane().add(gradHireButton);
	
	JButton ramsayHireButton = new JButton("Hire");
	ramsayHireButton.setBounds(479, 174, 61, 17);
	frame.getContentPane().add(ramsayHireButton);
	
	JLabel SDLabel = new JLabel("Current S/D: ");
	SDLabel.setBounds(10, 10, 120, 13);
	frame.getContentPane().add(SDLabel);
	
	JButton cleanerHireButton = new JButton("Hire");
	cleanerHireButton.setBounds(479, 260, 61, 17);
	frame.getContentPane().add(cleanerHireButton);
	
	JLabel cleanerButton = new JLabel("Cleaner ($1,200/week)");
	cleanerButton.setBounds(578, 262, 174, 13);
	frame.getContentPane().add(cleanerButton);
	
	JLabel lblNewLabel_1 = new JLabel("CURRENT CHEFS");
	lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
	lblNewLabel_1.setBounds(24, 56, 157, 13);
	frame.getContentPane().add(lblNewLabel_1);
	
	JList list = new JList();
	list.setBounds(34, 79, 180, 160);
	frame.getContentPane().add(list);
	
	JLabel lblNewLabel_1_1 = new JLabel("CURRENT CLEANERS");
	lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
	lblNewLabel_1_1.setBounds(24, 261, 157, 13);
	frame.getContentPane().add(lblNewLabel_1_1);
	
	JList list_1 = new JList();
	list_1.setBounds(34, 282, 180, 110);
	frame.getContentPane().add(list_1);
	
	JButton btnNewButton = new JButton("?");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 JFrame jFrame = new JFrame();
			 JOptionPane.showMessageDialog(jFrame, "Hello there! How are you today?");
		}
	});
	btnNewButton.setBounds(435, 94, 37, 17);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("?");
	btnNewButton_1.setBounds(435, 136, 37, 17);
	frame.getContentPane().add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("?");
	btnNewButton_2.setBounds(435, 174, 37, 17);
	frame.getContentPane().add(btnNewButton_2);
	
	JButton btnNewButton_3 = new JButton("?");
	btnNewButton_3.setBounds(435, 260, 37, 17);
	frame.getContentPane().add(btnNewButton_3);
	
	frame.setVisible(true);
	
	}
	
	
	public static void main(String[] args) {
		new HirePage();
		showWindow();

	}
}

