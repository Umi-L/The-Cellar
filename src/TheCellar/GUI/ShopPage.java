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
import javax.swing.JTextArea;

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
	
	JTextArea textArea = new JTextArea();
	textArea.setBounds(506, 40, 273, 275);
	frame.getContentPane().add(textArea);
	
	JLabel lblNewLabel_1 = new JLabel("$10,000");
	lblNewLabel_1.setBackground(new Color(192, 192, 192));
	lblNewLabel_1.setFont(new Font("SansSerif", Font.ITALIC, 18));
	lblNewLabel_1.setBounds(6, 378, 81, 38);
	frame.getContentPane().add(lblNewLabel_1);
	

	JComboBox<String> equipment = new JComboBox<String>();
	equipment.setBounds(192, 34, 178, 30);
	frame.getContentPane().add(equipment);
	equipment.addItem("");
	equipment.addItem("Hotplate (Increases Speed)");
	equipment.addItem("Stove Burner Upgrade (Increases Speed)");
	equipment.addItem("Energy Efficient Appliances (Reduces utility cost)");
	equipment.setVisible(false);
	
	JButton addToCartButton = new JButton("Add to cart");
	addToCartButton.setBounds(373, 34, 114, 30);
	frame.getContentPane().add(addToCartButton);
	addToCartButton.setVisible(false);
	
	equipment.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object selectedItem = equipment.getSelectedItem();
			
			if(selectedItem != null && !selectedItem.toString().isEmpty()) {
				addToCartButton.setVisible(true);
			} else {
				addToCartButton.setVisible(false);
			}
			

			
		}
	});
	
	addToCartButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String selectedEquipment = equipment.getSelectedItem().toString();
			textArea.append( selectedEquipment + "\n" + "\n");
			
		}
		
		});
	

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
	btnNewButton_1.setBounds(6, 34, 174, 30);
	frame.getContentPane().add(btnNewButton_1);
	
	JComboBox<String> food = new JComboBox<String>();
	food.setBounds(192, 76, 178, 30);
	frame.getContentPane().add(food);
	food.addItem("");
	food.addItem("Premium Meat Supplier");
	food.addItem("Organic Farm Partnership");
	food.addItem("Gourmet Recipe Book");
	food.addItem("Seasonal Menu Updates");
	food.setVisible(false);
	
	JButton addToCartButton1 = new JButton("Add to cart");
	addToCartButton1.setBounds(372, 76, 114, 30);
	frame.getContentPane().add(addToCartButton1);
	addToCartButton1.setVisible(false);
	
	food.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object selectedItem = food.getSelectedItem();
			
			if(selectedItem != null && !selectedItem.toString().isEmpty()) {
				addToCartButton1.setVisible(true);
			} else {
				addToCartButton1.setVisible(false);
			}
			

			
		}
	});
	
	addToCartButton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String selectedEquipment = food.getSelectedItem().toString();
			textArea.append( selectedEquipment + "\n" + "\n");
		}
		
		});
	
	
	JButton btnNewButton_2 = new JButton("Food Upgrades");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		food.setVisible(true);
		}
	});
	btnNewButton_2.setBounds(6, 76, 174, 30);
	frame.getContentPane().add(btnNewButton_2);
	
	JComboBox<String> knife = new JComboBox<String>();
	knife.setBounds(192, 118, 178, 30);
	frame.getContentPane().add(knife);
	knife.addItem("");
	knife.addItem("Blade Upgrade");
	knife.addItem("handle Upgrade");
	knife.addItem("Sharpner Upgrade");
	knife.setVisible(false);
	
	JButton addToCartButton2 = new JButton("Add to cart");
	addToCartButton2.setBounds(373, 118, 114, 30);
	frame.getContentPane().add(addToCartButton2);
	addToCartButton2.setVisible(false);
	
	knife.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object selectedItem = knife.getSelectedItem();
			
			if(selectedItem != null && !selectedItem.toString().isEmpty()) {
				addToCartButton2.setVisible(true);
			} else {
				addToCartButton2.setVisible(false);
			}
			

			
		}
	});
	
	addToCartButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String selectedEquipment = knife.getSelectedItem().toString();
			textArea.append( selectedEquipment + "\n" + "\n");
			
		}
		
		});
	
	JButton btnNewButton_3 = new JButton("Knife Upgrades");
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			knife.setVisible(true);
	
			
		}
	});
	btnNewButton_3.setBounds(6, 118, 174, 30);
	frame.getContentPane().add(btnNewButton_3);

	
	
	JButton btnNewButton_4 = new JButton("Chef Upgrades");
	btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			chefUpgrades window3 = new TheCellar.GUI.chefUpgrades();
			window3.showWindow();
			
		}
	});
	btnNewButton_4.setBounds(66, 230, 174, 60);
	btnNewButton_4.setVisible(true);
	frame.getContentPane().add(btnNewButton_4);
	
	JComboBox<String> cleaner = new JComboBox<String>();
	cleaner.setBounds(192, 160, 178, 30);
	frame.getContentPane().add(cleaner);
	cleaner.addItem("");
	cleaner.addItem("Industrial Grade Cleaning Supplies");
	cleaner.addItem("Cleaning Robots");
	cleaner.addItem("Eco Friendly Cleaning supplies");
	cleaner.addItem("24/7 Cleaning Staff");
	cleaner.setVisible(false);
	
	JButton addToCartButton4 = new JButton("Add to cart");
	addToCartButton4.setBounds(373, 160, 114, 30);
	frame.getContentPane().add(addToCartButton4);
	addToCartButton4.setVisible(false);
	
	cleaner.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Object selectedItem = cleaner.getSelectedItem();
			
			if(selectedItem != null && !selectedItem.toString().isEmpty()) {
				addToCartButton4.setVisible(true);
			} else {
				addToCartButton4.setVisible(false);
			}
			

			
		}
	});
	
	addToCartButton4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String selectedEquipment = cleaner.getSelectedItem().toString();
			textArea.append( selectedEquipment + "\n");
			
		}
		
		});
	
	
	JButton btnNewButton_3_1 = new JButton("Cleaner Upgrades");
	btnNewButton_3_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			cleaner.setVisible(true);
		}
	});
	btnNewButton_3_1.setBounds(6, 160, 174, 30);
	frame.getContentPane().add(btnNewButton_3_1);
	
	JLabel lblNewLabel_11 = new JLabel("Cart");
	lblNewLabel_11.setBounds(629, 11, 61, 16);
	frame.getContentPane().add(lblNewLabel_11);
	
	
	JButton btnNewButton_5 = new JButton("Purchase");
	btnNewButton_5.setBounds(590, 327, 117, 29);
	frame.getContentPane().add(btnNewButton_5);
	
	JButton btnNewButton_4_1 = new JButton("Chef Training");
	btnNewButton_4_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			TheCellar.GUI.chefTraining window4 = new TheCellar.GUI.chefTraining();
			window4.showWindow();
		}
	});
	btnNewButton_4_1.setBounds(252, 230, 174, 60);
	frame.getContentPane().add(btnNewButton_4_1);
	
	JLabel lblNewLabel_2 = new JLabel("Additional Upgrades");
	lblNewLabel_2.setBounds(192, 202, 136, 16);
	frame.getContentPane().add(lblNewLabel_2);
	
	
	frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new TheCellar.GUI.ShopPage();
		showWindow();
		// TODO Auto-generated method stub

	}
}
