package TheCellar.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import TheCellar.Game;
import TheCellar.Main;
import TheCellar.AI.AI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ActionMap;
import javax.swing.AbstractAction;
import javax.swing.InputMap;

public class BankPage {
	private JFrame frame;
	private JTextField textField;
	
	public static void showWindow() {
		
	}
	
	private void showLoanStatusMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Loan Status", JOptionPane.INFORMATION_MESSAGE);
    }
	
	
	public BankPage() {
		frame = new JFrame("");
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		frame.setFocusable(true);

        // Add KeyBindings to listen for Escape key press
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

		
		JButton btnNewButton = new JButton("Resume TheCellar.Game");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 18, 29));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GamePage window2 = new GamePage();
				window2.showWindow();
		
		}
	});
	btnNewButton.setBounds(300, 346, 219, 70);
	frame.getContentPane().add(btnNewButton);
	
	JLabel lblNewLabel = new JLabel("Bank");
	lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
	lblNewLabel.setBounds(375, 6, 61, 23);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Request a loan");
	lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
	lblNewLabel_1.setBounds(339, 69, 162, 23);
	frame.getContentPane().add(lblNewLabel_1);
	
	textField = new JTextField();
	textField.setBounds(317, 93, 190, 39);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	
	JLabel lblNewLabel_2 = new JLabel("$");
	lblNewLabel_2.setBounds(288, 104, 17, 16);
	frame.getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("");
	lblNewLabel_3.setBounds(317, 133, 190, 16);
	frame.getContentPane().add(lblNewLabel_3);
	
	JButton btnNewButton_1 = new JButton("Request");

	btnNewButton_1.setBounds(509, 99, 117, 29);
	frame.getContentPane().add(btnNewButton_1);
	 btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             try {
                 int requestedLoan = Integer.parseInt(textField.getText());
                 if ((Main.game.PlayerBusiness.getProfit() - Main.game.PlayerBusiness.getExpenses()) > 0
                         && requestedLoan > 0) {
                     if (requestedLoan < Main.game.PlayerBusiness.getProfit() * (Main.game.random.nextInt(4) + 2)) {
                         Main.game.PlayerBusiness.TakeOutLoan(requestedLoan);

                         // Loan accepted message
                         showLoanStatusMessage("Loan accepted! You received $" + requestedLoan + " in your account.");
                     } else {
                         // Loan denied message
                         showLoanStatusMessage("Loan denied. The requested amount is too high.");
                     }
                 } else {
                     // Loan denied message
                     showLoanStatusMessage("Loan denied. Insufficient profit or invalid loan amount.");
                 }
             } catch (NumberFormatException ex) {
                 // Handle the case where the input is not a valid integer
                 showLoanStatusMessage("Invalid input. Please enter a valid loan amount.");
             }
         }
     });

	frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		showWindow();

		// TODO Auto-generated method stub


		Main.game = new Game();
		new BankPage().showWindow();
		// TODO Auto-generated method stub

	}
}
