package TheCellar.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class chefTraining {
	private JFrame frame;
	
	public static void showWindow() {
		
	}

		
		public chefTraining() {
			
			frame = new JFrame("");
			frame.setTitle("The Cellar");
			frame.setBounds(100, 100, 800, 450);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JButton btnNewButton = new JButton("Back");
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBackground(new Color(255, 18, 29));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					TheCellar.GUI.ShopPage window2 = new TheCellar.GUI.ShopPage();
					window2.showWindow();
	}

});
			btnNewButton.setBounds(300, 346, 219, 70);
			frame.getContentPane().add(btnNewButton);
			
		frame.setVisible(true);
			
		}
		
		
		public static void main(String[] args) {
			showWindow();
	}
}