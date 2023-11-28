package TheCellar.GUI;

import TheCellar.GUI.Components.PurchaseArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShopPage {
	private JFrame frame;
	
	public static void showWindow() {
		
	}
	

	/**
	 * @wbp.parser.entryPoint
	 */
	public ShopPage() {
		frame = new JFrame("");
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Resume TheCellar.Game");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 18, 29));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TheCellar.GUI.GamePage window2 = new TheCellar.GUI.GamePage();
				window2.showWindow();
		
		}
	});
	btnNewButton.setBounds(300, 346, 219, 70);
	frame.getContentPane().add(btnNewButton);
	
	JLabel lblNewLabel = new JLabel("Shop");
	lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
	lblNewLabel.setBounds(373, 0, 61, 30);
	frame.getContentPane().add(lblNewLabel);
	

	JComboBox<String> equipment = new JComboBox<String>();
	equipment.setBounds(192, 34, 178, 30);
	frame.getContentPane().add(equipment);
	equipment.addItem("");
	equipment.addItem("Hotplate");
	equipment.addItem("Stove Burner Upgrade");
	equipment.addItem("Energy Efficient Appliances");
	equipment.setVisible(false);

//	PurchaseArea equipment1 = new PurchaseArea("Knife", 100, "a knife :D");
//	equipment1.setBounds(6, 73, 144, 100);
//	frame.getContentPane().add(equipment1);
//>>>>>>> 2125552314a6276d3977fd705982be492d2c8bba
	
	JButton btnNewButton_1 = new JButton("Equipment Upgrades");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			equipment.setVisible(true);
			
		}
	});
	btnNewButton_1.setBounds(6, 19, 174, 60);
	frame.getContentPane().add(btnNewButton_1);
	
	JComboBox<String> food = new JComboBox<String>();
	food.setBounds(192, 98, 178, 30);
	frame.getContentPane().add(food);
	food.addItem("");
	food.addItem("Premium Meat Supplier");
	food.addItem("Organic Farm Partnership");
	food.addItem("Gourmet Recipe Book");
	food.addItem("Seasonal Menu Updates");
	food.setVisible(false);
	
	
	
	JButton btnNewButton_2 = new JButton("Food Upgrades");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		food.setVisible(true);
		}
	});
	btnNewButton_2.setBounds(6, 83, 174, 60);
	frame.getContentPane().add(btnNewButton_2);
	
	JComboBox<String> knife = new JComboBox<String>();
	knife.setBounds(192, 225, 178, 30);
	frame.getContentPane().add(knife);
	knife.addItem("");
	knife.addItem("Blade Upgrade");
	knife.addItem("handle Upgrade");
	knife.addItem("Sharpner Upgrade");
	knife.setVisible(false);
	
	JButton btnNewButton_3 = new JButton("Knife Upgrades");
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			knife.setVisible(true);
	
			
		}
	});
	btnNewButton_3.setBounds(6, 210, 174, 60);
	frame.getContentPane().add(btnNewButton_3);
	
	JComboBox<String> chef = new JComboBox<String>();
	chef.setBounds(192, 160, 178, 30);
	frame.getContentPane().add(chef);
	chef.addItem("");
	chef.addItem("Culinary School Graduate");
	chef.addItem("Chef training program");
	chef.addItem("Master Chef Certification");
	chef.setVisible(false);
	
	
	JButton btnNewButton_4 = new JButton("Chef Upgrades");
	btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			chef.setVisible(true);
		}
	});
	btnNewButton_4.setBounds(6, 145, 174, 60);
	frame.getContentPane().add(btnNewButton_4);
	
	JComboBox<String> cleaner = new JComboBox<String>();
	cleaner.setBounds(192, 285, 178, 30);
	frame.getContentPane().add(cleaner);
	cleaner.addItem("");
	cleaner.addItem("Industrial Grade Cleaning Supplies");
	cleaner.addItem("Cleaning Robots");
	cleaner.addItem("Eco Friendly Cleaning supplies");
	cleaner.addItem("24/7 Cleaning Staff");
	cleaner.setVisible(false);
	
	JButton btnNewButton_3_1 = new JButton("Cleaner Upgrades");
	btnNewButton_3_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			cleaner.setVisible(true);
		}
	});
	btnNewButton_3_1.setBounds(6, 273, 174, 60);
	frame.getContentPane().add(btnNewButton_3_1);
	
	

	
	
	frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new TheCellar.GUI.BankPage();
		showWindow();
		// TODO Auto-generated method stub

	}
}
