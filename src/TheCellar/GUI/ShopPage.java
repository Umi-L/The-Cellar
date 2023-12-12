package TheCellar.GUI;

import TheCellar.Business;
import TheCellar.Game;
import TheCellar.Main;
import TheCellar.GUI.Components.PurchaseArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
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
import javax.swing.UIManager;




public class ShopPage {
	private JFrame frame;
	private JTextArea textArea;
	private JLabel lblNewLabel_1; 
	private JButton addToCartButton;
	private JComboBox<String> selectedComboBox; 
	private JComboBox<String> equipment = new JComboBox<>();
	private JComboBox<String> food = new JComboBox<>();
	private JComboBox<String> knife = new JComboBox<>();
	private JComboBox<String> cleaner = new JComboBox<>();
	private Set<String> purchasedUpgrades = new HashSet<>();
	private Business PlayerBusiness;


	public static void showWindow() {

	}
	//Method to Set location of button relative to which combo box is currently being used
	private void setButtonLocation() {
		if (selectedComboBox != null && addToCartButton != null) {
			Rectangle comboBoxBounds = selectedComboBox.getBounds();
			addToCartButton.setBounds(comboBoxBounds.x + comboBoxBounds.width + 1, comboBoxBounds.y, 114, 30);
		}
	}
	//handle combo box selection
	private void handleComboBoxSelection() {
		if (selectedComboBox != null && addToCartButton != null) {
			Object selectedItem = selectedComboBox.getSelectedItem();

			if (selectedItem != null && !selectedItem.toString().isEmpty()) {
				setButtonLocation();
				addToCartButton.setVisible(true);
			} else {
				addToCartButton.setVisible(false);
			}
		}
	}
	//Method to hide other combo boxes when another upgrade type is clicked
	private void hideOtherComboBoxes(JComboBox<String> selectedComboBox) {
        if (equipment != null && equipment != selectedComboBox) {
            equipment.setVisible(false);
        }

        if (food != null && food != selectedComboBox) {
            food.setVisible(false);
        }

        if (knife != null && knife != selectedComboBox) {
            knife.setVisible(false);
        }

        if (cleaner != null && cleaner != selectedComboBox) {
            cleaner.setVisible(false);
        }

        addToCartButton.setVisible(false);
    }





	/**
	 * @wbp.parser.entryPoint
	 */
	public ShopPage() {
		
		
		this.PlayerBusiness = Main.game != null ? Main.game.PlayerBusiness : new Business();
		
		frame = new JFrame("");
		frame.getContentPane().setBackground(new Color(145, 145, 145));
		frame.setTitle("The Cellar");
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Resume TheCellar.Game");
		btnNewButton.setOpaque(true);
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 18, 29));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TheCellar.GUI.GamePage window2 = new TheCellar.GUI.GamePage();
				window2.showWindow();

			}
		});
		btnNewButton.setBounds(6, 378, 219, 38);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Shop");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel.setBounds(373, 0, 61, 30);
		frame.getContentPane().add(lblNewLabel);

		textArea = new JTextArea();
		textArea.setBackground(new Color(202, 202, 202));
		textArea.setBounds(510, 34, 273, 269);
		frame.getContentPane().add(textArea);

		lblNewLabel_1 = new JLabel("$" + Main.game.PlayerBusiness.getMoney());
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_1.setBounds(713, 375, 81, 38);
		frame.getContentPane().add(lblNewLabel_1);

		equipment = new JComboBox<String>();
		equipment.setBounds(203, 34, 178, 30);
		frame.getContentPane().add(equipment);
		equipment.addItem("");
		equipment.addItem("Hotplate $300");
		equipment.addItem("Stove Burner Upgrade $2700");
		equipment.addItem("Energy Efficient Appliances $4000");
		equipment.setVisible(false);

		addToCartButton = new JButton("Add to cart"); 
		addToCartButton.setBackground(new Color(225, 6, 0));
		addToCartButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		addToCartButton.setOpaque(true);
		addToCartButton.setBounds(383, 34, 114, 30);
		frame.getContentPane().add(addToCartButton);
		addToCartButton.setVisible(false);


		equipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedComboBox = equipment;
				handleComboBoxSelection();

			}
		});



		addToCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedComboBox != null) {
					Object selectedItem = selectedComboBox.getSelectedItem();

					if (selectedItem != null && !selectedItem.toString().isEmpty()) {
						// Check if the item is already in the cart
						if (textArea.getText().contains(selectedItem.toString())) {
							JOptionPane.showMessageDialog(frame, "Item already in the cart.");
						} else {
							// Check if the item is already owned
							if (purchasedUpgrades.contains(selectedItem.toString())) {
								JOptionPane.showMessageDialog(frame, "You already own this item.");
							} else {
								// Add the item to the cart and mark it as owned
								textArea.append(selectedItem + "\n" + "\n");
								purchasedUpgrades.add(selectedItem.toString());
								setButtonLocation();
								addToCartButton.setVisible(true);
								selectedComboBox.setSelectedIndex(0);
							}
						}
					}
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Equipment Upgrades");
		btnNewButton_1.setBackground(new Color(70, 70, 234));
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipment.setVisible(true);
				hideOtherComboBoxes(equipment);


			}
		});
		btnNewButton_1.setBounds(36, 34, 165, 30);
		frame.getContentPane().add(btnNewButton_1);

		food = new JComboBox<String>();
		food.setBounds(203, 76, 178, 30);
		frame.getContentPane().add(food);
		food.addItem("");
		food.addItem("Premium Meat Supplier $50000");
		food.addItem("Organic Farm Partnership $100000");
		food.addItem("Gourmet Recipe Book $500");
		food.addItem("Seasonal Menu Updates $5000");
		food.setVisible(false);

		food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedComboBox = food;
				handleComboBoxSelection();
			}
		});

		JButton btnNewButton_2 = new JButton("Food Upgrades");
		btnNewButton_2.setBackground(new Color(70, 70, 234));
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food.setVisible(true);
				hideOtherComboBoxes(food);

			}
		});
		btnNewButton_2.setBounds(36, 76, 165, 30);
		frame.getContentPane().add(btnNewButton_2);

		knife = new JComboBox<String>();
		knife.setBounds(203, 118, 178, 30);
		frame.getContentPane().add(knife);
		knife.addItem("");
		knife.addItem("Blade Upgrade $500");
		knife.addItem("Handle Upgrade $100");
		knife.addItem("Sharpner Upgrade $100");
		knife.setVisible(false);


		knife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectedComboBox = knife;
				handleComboBoxSelection();
			}
		});

		JButton btnNewButton_3 = new JButton("Knife Upgrades");
		btnNewButton_3.setBackground(new Color(70, 70, 234));
		btnNewButton_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_3.setOpaque(true);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				knife.setVisible(true);
				hideOtherComboBoxes(knife);



			}
		});
		btnNewButton_3.setBounds(36, 118, 165, 30);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Chef Upgrades");
		btnNewButton_4.setBackground(new Color(70, 70, 234));
		btnNewButton_4.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_4.setOpaque(true);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ChefUpgrades window3 = new TheCellar.GUI.ChefUpgrades();
				window3.showWindow();

			}
		});
		btnNewButton_4.setBounds(36, 233, 165, 30);
		btnNewButton_4.setVisible(true);
		frame.getContentPane().add(btnNewButton_4);

		cleaner = new JComboBox<String>();
		cleaner.setBounds(203, 160, 178, 30);
		frame.getContentPane().add(cleaner);
		cleaner.addItem("");
		cleaner.addItem("Industrial Grade Cleaning Supplies $2000");
		cleaner.addItem("Cleaning Robots $50000");
		cleaner.addItem("Eco Friendly Cleaning supplies $1200");
		cleaner.addItem("24/7 Cleaning Staff $100000");
		cleaner.setVisible(false);
		cleaner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectedComboBox = cleaner;
				handleComboBoxSelection();
			}
		});

		JButton btnNewButton_3_1 = new JButton("Cleaner Upgrades");
		btnNewButton_3_1.setBackground(new Color(70, 70, 234));
		btnNewButton_3_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_3_1.setOpaque(true);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleaner.setVisible(true);
				hideOtherComboBoxes(cleaner);

			}
		});
		btnNewButton_3_1.setBounds(36, 160, 165, 30);
		frame.getContentPane().add(btnNewButton_3_1);

		JLabel lblNewLabel_11 = new JLabel("Cart");
		lblNewLabel_11.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_11.setBounds(621, 7, 61, 23);
		frame.getContentPane().add(lblNewLabel_11);

		JButton btnNewButton_5 = new JButton("Purchase");
		btnNewButton_5.setBackground(new Color(225, 6, 0));
		btnNewButton_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_5.setOpaque(true);
		btnNewButton_5.setBounds(520, 315, 117, 29);
		frame.getContentPane().add(btnNewButton_5);

		JButton btnClearCart = new JButton("Clear Cart");
		btnClearCart.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnClearCart.setBackground(new Color(225, 6, 0));
		btnClearCart.setOpaque(true);
		btnClearCart.setBounds(649, 315, 117, 29);
		frame.getContentPane().add(btnClearCart);

		btnClearCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textArea.getText().trim().isEmpty()) {
		            JOptionPane.showMessageDialog(frame, "Your cart is already empty.");
		        } else {
		            int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to clear the cart?", "Clear Cart", JOptionPane.YES_NO_OPTION);
		            if (option == JOptionPane.YES_OPTION) {
		                textArea.setText("");
				
		        textArea.setText("");

				equipment.setSelectedIndex(0);
				food.setSelectedIndex(0);
				knife.setSelectedIndex(0);
				cleaner.setSelectedIndex(0);


				equipment.setVisible(false);
				food.setVisible(false);
				knife.setVisible(false);
				cleaner.setVisible(false);
				addToCartButton.setVisible(false);
			}
		    }
			}
		});

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if the cart is empty
				if (textArea.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Your cart is empty. Add items before purchasing.");
				} else {
			
			            int option = JOptionPane.showConfirmDialog(frame, "Confirm Purchase?", "Purchase", JOptionPane.YES_NO_OPTION);
			            if (option == JOptionPane.YES_OPTION) {
			               
					
					
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

							}
						}
					}

					// Check if the total cost is less than or equal to remainingBalance
					if (totalCost <= PlayerBusiness.getMoney()) {
					    // Deduct the total cost from the remaining balance
					    PlayerBusiness.setMoney(PlayerBusiness.getMoney() - totalCost);
					    
					    // Update the UI with the new remaining balance
					    lblNewLabel_1.setText("$" + PlayerBusiness.getMoney());

					    // Purchase details
					    String purchaseDetails = "Items Purchased:\n\n" + textArea.getText() +
					                             "\n\nRemaining Balance: $" + PlayerBusiness.getMoney();

						 
						 JOptionPane.showMessageDialog(frame, "Purchase successful!\n\n" + purchaseDetails);
						 
						// Clear the cart after a successful purchase
						textArea.setText("");
						
						// Reset JComboBox selection
						equipment.setSelectedIndex(0);
						food.setSelectedIndex(0);
						knife.setSelectedIndex(0);
						cleaner.setSelectedIndex(0);

						addToCartButton.setVisible(false);

						equipment.setVisible(false);
						food.setVisible(false);
						knife.setVisible(false);
						cleaner.setVisible(false);
					} else {
						// User has insufficient funds
						JOptionPane.showMessageDialog(frame, "Insufficient funds.");
						textArea.setText("");
						addToCartButton.setVisible(false);

						// Hide JComboBox components
						equipment.setVisible(false);
						food.setVisible(false);
						knife.setVisible(false);
						cleaner.setVisible(false);
					}
				}
			}
			}
		});

		JButton btnNewButton_6 = new JButton("?");
		btnNewButton_6.setOpaque(true);
		btnNewButton_6.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				JOptionPane.showMessageDialog(frame, "Hotplate: Increases speed (3% quality increase)" + "\n" + "Stove Burner Upgrade: Increases speed (10% quality increase, 50 s/d increase)" 
						+ "\n" + "Energy Efficient Appliances: Reduces utility cost");

			}
		});
		btnNewButton_6.setBounds(6, 37, 23, 24);
		frame.getContentPane().add(btnNewButton_6);

		JButton btnNewButton_6_1 = new JButton("?");
		btnNewButton_6_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_6_1.setOpaque(true);
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Premium Meat Supplier: 45% quality increase, 30 s/d increase" + "\n" + "Organic Farm Partnership: 35% quality increase, 30 s/d increase" + "\n" + "Gourmet Recipe Book: 50% quality increase, 20 s/d increase" + "\n"
						+ "Seasonal Menu Updates: 10 s/d increase ");

			}
		});
		btnNewButton_6_1.setBounds(6, 79, 23, 24);
		frame.getContentPane().add(btnNewButton_6_1);

		JButton btnNewButton_6_2 = new JButton("?");
		btnNewButton_6_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_6_2.setOpaque(true);
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Blade Upgrade: Increase Speed" + "\n" + "Handle Upgrade: Increase Comfort" + "\n" + "Sharpner Upgrade: Increase Speed");
			}
		});
		btnNewButton_6_2.setBounds(6, 121, 23, 24);
		frame.getContentPane().add(btnNewButton_6_2);

		JButton btnNewButton_6_3 = new JButton("?");
		btnNewButton_6_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_6_3.setOpaque(true);
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

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}	catch (Exception e) {

		}
		Main.game = new Game();
		new TheCellar.GUI.ShopPage();
		showWindow();
	

	}
}