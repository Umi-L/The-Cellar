package TheCellar.GUI;

import TheCellar.GUI.Components.PurchaseArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



public class ShopPage {
    private JFrame frame;
    private JTextArea textArea;
    private JLabel lblNewLabel_1; 
    private int remainingBalance = 10000; 
    private Set<String> purchasedUpgrades = new HashSet<>();
   
	
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
	
	textArea = new JTextArea();
	textArea.setBounds(510, 34, 273, 269);
	frame.getContentPane().add(textArea);
	
	lblNewLabel_1 = new JLabel("$" + remainingBalance);
    lblNewLabel_1.setBackground(new Color(192, 192, 192));
    lblNewLabel_1.setFont(new Font("SansSerif", Font.ITALIC, 18));
    lblNewLabel_1.setBounds(6, 378, 81, 38);
    frame.getContentPane().add(lblNewLabel_1);
	// ...

	JComboBox<String> equipment = new JComboBox<String>();
	equipment.setBounds(192, 34, 178, 30);
	frame.getContentPane().add(equipment);
	equipment.addItem("");
	equipment.addItem("Hotplate $300");
	equipment.addItem("Stove Burner Upgrade $2700");
	equipment.addItem("Energy Efficient Appliances $4000");
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
	btnNewButton_1.setBounds(31, 34, 165, 30);
	frame.getContentPane().add(btnNewButton_1);
	
	JComboBox<String> food = new JComboBox<String>();
	food.setBounds(192, 76, 178, 30);
	frame.getContentPane().add(food);
	food.addItem("");
	food.addItem("Premium Meat Supplier $50000");
	food.addItem("Organic Farm Partnership $100000");
	food.addItem("Gourmet Recipe Book $500");
	food.addItem("Seasonal Menu Updates $5000");
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
	btnNewButton_2.setBounds(31, 76, 165, 30);
	frame.getContentPane().add(btnNewButton_2);
	
	JComboBox<String> knife = new JComboBox<String>();
	knife.setBounds(192, 118, 178, 30);
	frame.getContentPane().add(knife);
	knife.addItem("");
	knife.addItem("Blade Upgrade $500");
	knife.addItem("Handle Upgrade $100");
	knife.addItem("Sharpner Upgrade $100");
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
	btnNewButton_3.setBounds(31, 118, 165, 30);
	frame.getContentPane().add(btnNewButton_3);

	
	
	JButton btnNewButton_4 = new JButton("Chef Upgrades");
	btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			ChefUpgrades window3 = new TheCellar.GUI.ChefUpgrades();
			window3.showWindow();
			
		}
	});
	btnNewButton_4.setBounds(172, 255, 174, 60);
	btnNewButton_4.setVisible(true);
	frame.getContentPane().add(btnNewButton_4);
	
	JComboBox<String> cleaner = new JComboBox<String>();
	cleaner.setBounds(192, 160, 178, 30);
	frame.getContentPane().add(cleaner);
	cleaner.addItem("");
	cleaner.addItem("Industrial Grade Cleaning Supplies $2000");
	cleaner.addItem("Cleaning Robots $50000");
	cleaner.addItem("Eco Friendly Cleaning supplies $1200");
	cleaner.addItem("24/7 Cleaning Staff $100000");
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
	btnNewButton_3_1.setBounds(31, 160, 165, 30);
	frame.getContentPane().add(btnNewButton_3_1);
	
	JLabel lblNewLabel_11 = new JLabel("Cart");
	lblNewLabel_11.setBounds(629, 11, 61, 16);
	frame.getContentPane().add(lblNewLabel_11);
	
	JLabel lblNewLabel_2 = new JLabel("Additional Upgrades");
	lblNewLabel_2.setBounds(192, 219, 136, 16);
	frame.getContentPane().add(lblNewLabel_2);
	
	JButton btnNewButton_5 = new JButton("Purchase");
	btnNewButton_5.setBounds(520, 305, 117, 29);
	frame.getContentPane().add(btnNewButton_5);
	
	JButton btnClearCart = new JButton("Clear Cart");
    btnClearCart.setBounds(649, 305, 117, 29);
    frame.getContentPane().add(btnClearCart);

    btnClearCart.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Clear the cart 
            textArea.setText("");
        }
    });



    btnNewButton_5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Check if the cart is empty
            if (textArea.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Your cart is empty. Add items before purchasing.");
            } else {
                // Calculate the total cost and process the purchase
                String[] cartItems = textArea.getText().split("\n");
                int totalCost = 0;

                for (String item : cartItems) {
                    // Assume each line in the cart represents an item with a cost at the end
                    String[] parts = item.split("\\$");
                    if (parts.length > 1) {
                        try {
                            int itemCost = Integer.parseInt(parts[1].trim());
                            totalCost += itemCost;
                        } catch (NumberFormatException ex) {
                            // Handle the case where the cost is not a valid integer
                        }
                    }
                }

                // Check if the total cost is less than or equal to remainingBalance
                if (totalCost <= remainingBalance) {
                    // Deduct the total cost from the remaining balance
                    remainingBalance -= totalCost;
                    lblNewLabel_1.setText("$" + remainingBalance);

                    // Clear the cart after a successful purchase
                    textArea.setText("");
                    JOptionPane.showMessageDialog(frame, "Purchase successful!");

                    // Reset JComboBox selection
                    equipment.setSelectedIndex(0);
                    food.setSelectedIndex(0);
                    knife.setSelectedIndex(0);
                    cleaner.setSelectedIndex(0);

                    // Hide "Add to cart" buttons
                    addToCartButton.setVisible(false);
                    addToCartButton1.setVisible(false);
                    addToCartButton2.setVisible(false);
                    addToCartButton4.setVisible(false);

                    // Hide JComboBox components
                    equipment.setVisible(false);
                    food.setVisible(false);
                    knife.setVisible(false);
                    cleaner.setVisible(false);
                } else {
                    // User has insufficient funds
                    JOptionPane.showMessageDialog(frame, "Insufficient funds.");

                    // Clear the cart
                    textArea.setText("");

                    // Hide "Add to cart" buttons
                    addToCartButton.setVisible(false);
                    addToCartButton1.setVisible(false);
                    addToCartButton2.setVisible(false);
                    addToCartButton4.setVisible(false);

                    // Hide JComboBox components
                    equipment.setVisible(false);
                    food.setVisible(false);
                    knife.setVisible(false);
                    cleaner.setVisible(false);
                }
            }
        }
    });
	
	JButton btnNewButton_6 = new JButton("?");
	btnNewButton_6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { 
		JOptionPane.showMessageDialog(frame, "Hotplate: Increases speed (3% quality increase)" + "\n" + "Stove Burner Upgrade: Increases speed (10% quality increase, 50 s/d increase)" 
	+ "\n" + "Energy Efficient Appliances: Reduces utility cost");
		
		}
	});
	btnNewButton_6.setBounds(6, 37, 23, 24);
	frame.getContentPane().add(btnNewButton_6);
	
	JButton btnNewButton_6_1 = new JButton("?");
	btnNewButton_6_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "Premium Meat Supplier: 45% quality increase, 30 s/d increase" + "\n" + "Organic Farm Partnership: 35% quality increase, 30 s/d increase" + "\n" + "Gourmet Recipe Book: 50% quality increase, 20 s/d increase" + "\n"
		+ "Seasonal Menu Updates: 10 s/d increase ");
			
		}
	});
	btnNewButton_6_1.setBounds(6, 79, 23, 24);
	frame.getContentPane().add(btnNewButton_6_1);
	
	JButton btnNewButton_6_2 = new JButton("?");
	btnNewButton_6_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "Blade Upgrade: Increase Speed" + "\n" + "Handle Upgrade: Increase Comfort" + "\n" + "Sharpner Upgrade: Increase Speed");
		}
	});
	btnNewButton_6_2.setBounds(6, 121, 23, 24);
	frame.getContentPane().add(btnNewButton_6_2);
	
	JButton btnNewButton_6_3 = new JButton("?");
	btnNewButton_6_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "Industrial Grade Cleaning Supplies: Cleanliness Increase 10% " + "\n" + "Cleaning Robots: Cleanliness Increase: 50% " + "\n" + "Eco Friendly Cleaning Supplies: Cleanliness Increase 15%" + "\n" + "24/7 cleaning staff: Cleanliness Increase 100%");
			

		}
	});
	btnNewButton_6_3.setBounds(6, 163, 23, 24);
	frame.getContentPane().add(btnNewButton_6_3);
	
	
	frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new TheCellar.GUI.ShopPage();
		showWindow();
		// TODO Auto-generated method stub

	}
}
