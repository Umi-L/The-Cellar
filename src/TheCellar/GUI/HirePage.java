package TheCellar.GUI;
import javax.swing.*;


import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import TheCellar.Chef;

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
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		 InputMap inputMap = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	        ActionMap actionMap = frame.getRootPane().getActionMap();

	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "resumeGame");
	        actionMap.put("resumeGame", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frame.setVisible(false);
	                GamePage window2 = new GamePage();
	                window2.showWindow();
	            }
	        });

		
		//RESUME BUTTON
		JButton resumeButton = new JButton("Resume");
		resumeButton.setFont(new Font("Dialog", Font.PLAIN, 36));
		resumeButton.setForeground(new Color(0, 0, 0));
		resumeButton.setBackground(new Color(255, 18, 29));
		resumeButton.setBounds(300, 346, 219, 70);
		frame.getContentPane().add(resumeButton);
		
		resumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GamePage window2 = new GamePage();
				window2.showWindow();
			}
		});
		
		//TITLE PAGE LABEL
		JLabel lblNewLabel = new JLabel("HIRING PAGE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(281, 10, 204, 23);
		frame.getContentPane().add(lblNewLabel);
		
		//CHEFS LABEL
		JLabel chefsLabel = new JLabel("CHEFS");
		chefsLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		chefsLabel.setBounds(557, 54, 61, 16);
		frame.getContentPane().add(chefsLabel);
		
		//CLEANERS LABEL
		JLabel cleanersLabel = new JLabel("CLEANERS");
		cleanersLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		cleanersLabel.setBounds(568, 228, 78, 16);
		frame.getContentPane().add(cleanersLabel);
		
		//TEEN HIRE BUTTON
		JButton teenHireButton = new JButton("Hire");
		teenHireButton.setBounds(479, 94, 61, 17);
		frame.getContentPane().add(teenHireButton);
		
		//TEEN LABEL BUTTON
		JLabel teenLabel = new JLabel("Teenage Chef ($500/week)");
		teenLabel.setBounds(557, 96, 255, 13);
		frame.getContentPane().add(teenLabel);
		
		//GRAD LABEL
		JLabel gradLabel = new JLabel("Culinary School Grad ($2,000/week)");
		gradLabel.setBounds(557, 138, 255, 13);
		frame.getContentPane().add(gradLabel);
		
		//CURRENT CHEF LABEL
		JLabel currentChefs = new JLabel("Gordon Ramsay ($10,000/week)");
		currentChefs.setBounds(557, 176, 255, 13);
		frame.getContentPane().add(currentChefs);
		
		//NETWOTH LABEL
		JLabel networthLabel = new JLabel("Current Networth:");
		networthLabel.setBounds(10, 20, 120, 13);
		frame.getContentPane().add(networthLabel);
		
		//GRAD HIRE BUTTON
		JButton gradHireButton = new JButton("Hire");
		gradHireButton.setBounds(479, 136, 61, 17);
		frame.getContentPane().add(gradHireButton);
		
		//RAMSAY HIRE BUTTON
		JButton ramsayHireButton = new JButton("Hire");
		ramsayHireButton.setBounds(479, 174, 61, 17);
		frame.getContentPane().add(ramsayHireButton);
		
		//S/D LABEL
		JLabel SDLabel = new JLabel("Current S/D: ");
		SDLabel.setBounds(10, 10, 120, 13);
		frame.getContentPane().add(SDLabel);
	
		//CLEANER HIRE BUTTON
		JButton cleanerHireButton = new JButton("Hire");
		cleanerHireButton.setBounds(479, 260, 61, 17);
		frame.getContentPane().add(cleanerHireButton);
		
		//CLEANER LABEL
		JLabel cleanerButton = new JLabel("Cleaner ($1,200/week)");
		cleanerButton.setBounds(578, 262, 174, 13);
		frame.getContentPane().add(cleanerButton);
		
		//CURRENT CHEFS LABEL
		JLabel currentChefsLabel = new JLabel("CURRENT CHEFS");
		currentChefsLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		currentChefsLabel.setBounds(24, 56, 157, 13);
		frame.getContentPane().add(currentChefsLabel);
		
		//CHEF LIST
		JList chefList = new JList();
		chefList.setBounds(34, 79, 180, 160);
		frame.getContentPane().add(chefList);
		
		//CUURENT CLEANES LABEL
		JLabel currentCleanersLabel = new JLabel("CURRENT CLEANERS");
		currentCleanersLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		currentCleanersLabel.setBounds(24, 261, 157, 13);
		frame.getContentPane().add(currentCleanersLabel);
		
		//CLEANERS LIST
		JList cleanerList = new JList();
		cleanerList.setBounds(34, 282, 180, 110);
		frame.getContentPane().add(cleanerList);
		
		JButton btnNewButton = new JButton("?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jFrame = new JFrame();
				 JOptionPane.showMessageDialog(jFrame, "Benefits of Teenage Chef Include: ...");
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
	
	
		//ACTION LISTENERS
		
		//RESUME BUTTON
		resumeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //execute when resume button clicked
					frame.setVisible(false); //set frame to invisible
					GamePage window2 = new GamePage(); //
					window2.showWindow();
			
				}
			});
		
		//HIRE TEENAGER CHEF BUTTON
		teenHireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //execute when hire teen button pressed
				//Chef o = new Chef();

			}	
		});
		
		//HIRE CULINARY GRAD BUTTON
		gradHireButton.addActionListener(new ActionListener() { //execute when hire grad button pressed
			public void actionPerformed(ActionEvent e) { 
			}
		});
		
		//HIRE GORDAN RAMSAY BUTTON
		ramsayHireButton.addActionListener(new ActionListener() { //execute when hire ramsay button pressed
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//HIRE CLEANER BUTTON
		cleanerHireButton.addActionListener(new ActionListener() { //execute when hire cleaner button pressed
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.setVisible(true);
	
	}
	
	
	public static void main(String[] args) {

		new HirePage();
		showWindow();

		// TODO Auto-generated method stub



		new HirePage().showWindow();
		// TODO Auto-generated method stub

	}
}

