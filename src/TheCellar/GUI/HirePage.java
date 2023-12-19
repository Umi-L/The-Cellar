package TheCellar.GUI;
import javax.swing.*;


import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import TheCellar.Business;

import TheCellar.Chef;
import TheCellar.Cleaner;
import TheCellar.Equipment;
import TheCellar.Game;
import TheCellar.Main;

public class HirePage  {
	
	private JFrame frame;
	private Business PlayerBusiness;
	
	public static void showWindow() {
		
	}

	public HirePage() {
		
		this.PlayerBusiness = Main.game != null ? Main.game.PlayerBusiness : new Business(); //fix null error		
		
		frame = new JFrame("");
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		frame.setFocusable(true);
		
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
		resumeButton.setFont(new Font("Dialog", Font.PLAIN, 17));
		resumeButton.setForeground(new Color(0, 0, 0));
		resumeButton.setBackground(new Color(255, 18, 29));
		resumeButton.setBounds(10, 353, 165, 50);
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
		chefsLabel.setBounds(24, 53, 61, 16);
		frame.getContentPane().add(chefsLabel);
		
		//CLEANERS LABEL
		JLabel cleanersLabel = new JLabel("CLEANERS");
		cleanersLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		cleanersLabel.setBounds(25, 187, 78, 16);
		frame.getContentPane().add(cleanersLabel);
		
		//TEEN HIRE BUTTON
		JButton teenHireButton = new JButton("Hire");
		teenHireButton.setBounds(67, 79, 61, 17);
		frame.getContentPane().add(teenHireButton);
		
		//TEEN LABEL BUTTON
		JLabel teenLabel = new JLabel("Teenage Chef ($500/week)");
		teenLabel.setBounds(142, 81, 255, 13);
		frame.getContentPane().add(teenLabel);
		
		//GRAD LABEL
		JLabel gradLabel = new JLabel("Culinary School Grad ($2,000/week)");
		gradLabel.setBounds(142, 107, 255, 13);
		frame.getContentPane().add(gradLabel);
		
		//CURRENT CHEF LABEL
		JLabel currentChefs = new JLabel("Gordon Ramsay ($10,000/week)");
		currentChefs.setBounds(142, 142, 255, 13);
		frame.getContentPane().add(currentChefs);
		
		//NETWOTH LABEL
		JLabel networthLabel = new JLabel("Current Networth: " +  Main.game.PlayerBusiness.getMoney());
		networthLabel.setBounds(10, 20, 276, 13);
		frame.getContentPane().add(networthLabel);
		
		//GRAD HIRE BUTTON
		JButton gradHireButton = new JButton("Hire");
		gradHireButton.setBounds(67, 105, 61, 17);
		frame.getContentPane().add(gradHireButton);
		
		//RAMSAY HIRE BUTTON
		JButton ramsayHireButton = new JButton("Hire");
		ramsayHireButton.setBounds(67, 140, 61, 17);
		frame.getContentPane().add(ramsayHireButton);
		
		//S/D LABEL
		JLabel SDLabel = new JLabel("Current S/D: " + Main.game.PlayerBusiness.getSteaks());
		SDLabel.setBounds(10, 10, 285, 13);
		frame.getContentPane().add(SDLabel);
	
		//CLEANER HIRE BUTTON
		JButton cleanerHireButton = new JButton("Hire");
		cleanerHireButton.setBounds(67, 213, 61, 17);
		frame.getContentPane().add(cleanerHireButton);
		
		//CLEANER LABEL
		JLabel cleanerButton = new JLabel("Cleaner ($1,200/week)");
		cleanerButton.setBounds(149, 215, 174, 13);
		frame.getContentPane().add(cleanerButton);
		
		//CURRENT CHEFS LABEL
		JLabel currentChefsLabel = new JLabel("CURRENT CHEFS");
		currentChefsLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		currentChefsLabel.setBounds(487, 55, 157, 13);
		frame.getContentPane().add(currentChefsLabel);
		
		//CUURENT CLEANES LABEL
		JLabel currentCleanersLabel = new JLabel("CURRENT CLEANERS");
		currentCleanersLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		currentCleanersLabel.setBounds(487, 253, 157, 13);
		frame.getContentPane().add(currentCleanersLabel);
		
		for (Chef currentChef : Chef.ChefTypes) {

			String str = currentChef.getName();


			equipment.addItem(str);
		}
		

		
		
		JButton teenBenefits = new JButton("?");
		teenBenefits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jFrame = new JFrame();
				 JOptionPane.showMessageDialog(jFrame, "Benefits of Teenage Chef Include:"
				 		+ " +3% Quality  "
				 		+ "+0 S/D Increase");
			}
		});
		teenBenefits.setBounds(24, 79, 37, 17);
		frame.getContentPane().add(teenBenefits);
		
		JButton gradBenefits = new JButton("?");
		gradBenefits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "Benefits of Culinary Grad Include:"
				 		+ " +10% Quality  "
				 		+ "+40 S/D Increase");
			}
		});
		gradBenefits.setBounds(24, 105, 37, 17);
		frame.getContentPane().add(gradBenefits);
		
		JButton ramsayBenefits = new JButton("?");
		ramsayBenefits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "Benefits of Gordan Ramsay Include:"
				 		+ " +40% Quality  "
				 		+ "+100 S/D Increase");
			}
		});
		ramsayBenefits.setBounds(24, 140, 37, 17);
		frame.getContentPane().add(ramsayBenefits);
		
		JButton cleanerBenefits = new JButton("?");
		cleanerBenefits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, "Benefits of Cleaners Include:"
				 		+ " +15% Cleaniness ");
			}
		});
		cleanerBenefits.setBounds(24, 213, 37, 17);
		frame.getContentPane().add(cleanerBenefits);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(497, 75, 233, 151);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(497, 275, 233, 115);
		frame.getContentPane().add(textArea_1);
	
	
		//ACTION LISTENERS
		
		//RESUME BUTTON
		resumeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { //execute when resume button clicked
					frame.setVisible(false); //set frame to invisible
					GamePage window2 = new GamePage(); 
					window2.showWindow(); //show pop up
				}
			});
		
		//HIRE TEENAGER CHEF BUTTON
		teenHireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //execute when hire teen button pressed
				//Chef o = new Chef();
				 String name = JOptionPane.showInputDialog("Enter the employee's name: ");
				 System.out.println("name: " + name);

			}	
		});
		
		//HIRE CULINARY GRAD BUTTON
		gradHireButton.addActionListener(new ActionListener() { //execute when hire grad button pressed
			public void actionPerformed(ActionEvent e) { 
				 String name = JOptionPane.showInputDialog("Enter the employee's name: ");
				 System.out.println("name: " + name);

			}
		});
		
		//HIRE GORDAN RAMSAY BUTTON
		ramsayHireButton.addActionListener(new ActionListener() { //execute when hire ramsay button pressed
			public void actionPerformed(ActionEvent e) {
				 String name = JOptionPane.showInputDialog("Enter the employee's name: ");
				 System.out.println("name: " + name);

				 }
			});
		
		//HIRE CLEANER BUTTON
		cleanerHireButton.addActionListener(new ActionListener() { //execute when hire cleaner button pressed
			public void actionPerformed(ActionEvent e) {
				 String name = JOptionPane.showInputDialog("Enter the employee's name: ");
				 System.out.println("name: " + name);

			}
		});
		frame.setVisible(true);
	
	}
	
	
	public static void main(String[] args) {

		new HirePage();
		showWindow();

		// TODO Auto-generated method stub


		Main.game = new Game();
		new HirePage().showWindow();
		// TODO Auto-generated method stub

	}
}

