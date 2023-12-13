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
	private JLabel moneyLabel; 
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
	//Method to Set location of add to cart button relative to which combo box is currently being used
	private void setButtonLocation() {
		if (selectedComboBox != null && addToCartButton != null) {
			Rectangle comboBoxBounds = selectedComboBox.getBounds();
			addToCartButton.setBounds(comboBoxBounds.x + comboBoxBounds.width + 1, comboBoxBounds.y, 114, 30);
		}
	}
	//handle combo box selection and set location of add to cart button
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
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JButton btnResume = new JButton("Resume TheCellar.Game");
		btnResume.setOpaque(true);
		btnResume.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnResume.setForeground(new Color(0, 0, 0));
		btnResume.setBackground(new Color(255, 18, 29));
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TheCellar.GUI.GamePage window2 = new TheCellar.GUI.GamePage();
				window2.showWindow();

			}
		});
		btnResume.setBounds(6, 378, 219, 38);
		frame.getContentPane().add(btnResume);

		JLabel lblShop = new JLabel("Shop");
		lblShop.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblShop.setBounds(373, 0, 61, 30);
		frame.getContentPane().add(lblShop);

		textArea = new JTextArea();
		textArea.setBackground(new Color(202, 202, 202));
		textArea.setBounds(510, 34, 273, 269);
		frame.getContentPane().add(textArea);

		moneyLabel = new JLabel("$" + Main.game.PlayerBusiness.getMoney());
		moneyLabel.setBackground(new Color(192, 192, 192));
		moneyLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		moneyLabel.setBounds(713, 375, 81, 38);
		frame.getContentPane().add(moneyLabel);

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

		JButton btnEquipment = new JButton("Equipment Upgrades");
		btnEquipment.setBackground(new Color(70, 70, 234));
		btnEquipment.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEquipment.setOpaque(true);
		btnEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipment.setVisible(true);
				hideOtherComboBoxes(equipment);


			}
		});
		btnEquipment.setBounds(36, 34, 165, 30);
		frame.getContentPane().add(btnEquipment);

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

		JButton btnFood = new JButton("Food Upgrades");
		btnFood.setBackground(new Color(70, 70, 234));
		btnFood.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnFood.setOpaque(true);
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food.setVisible(true);
				hideOtherComboBoxes(food);

			}
		});
		btnFood.setBounds(36, 76, 165, 30);
		frame.getContentPane().add(btnFood);

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

		JButton btnKnife = new JButton("Knife Upgrades");
		btnKnife.setBackground(new Color(70, 70, 234));
		btnKnife.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnKnife.setOpaque(true);
		btnKnife.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				knife.setVisible(true);
				hideOtherComboBoxes(knife);



			}
		});
		btnKnife.setBounds(36, 118, 165, 30);
		frame.getContentPane().add(btnKnife);

		JButton btnChef = new JButton("Chef Upgrades");
		btnChef.setBackground(new Color(70, 70, 234));
		btnChef.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnChef.setOpaque(true);
		btnChef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ChefUpgrades window3 = new TheCellar.GUI.ChefUpgrades();
				window3.showWindow();

			}
		});
		btnChef.setBounds(36, 233, 165, 30);
		btnChef.setVisible(true);
		frame.getContentPane().add(btnChef);

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

		JButton btnCleaner = new JButton("Cleaner Upgrades");
		btnCleaner.setBackground(new Color(70, 70, 234));
		btnCleaner.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCleaner.setOpaque(true);
		btnCleaner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleaner.setVisible(true);
				hideOtherComboBoxes(cleaner);

			}
		});
		btnCleaner.setBounds(36, 160, 165, 30);
		frame.getContentPane().add(btnCleaner);

		JLabel lblCart = new JLabel("Cart");
		lblCart.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblCart.setBounds(621, 7, 61, 23);
		frame.getContentPane().add(lblCart);

		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBackground(new Color(225, 6, 0));
		btnPurchase.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnPurchase.setOpaque(true);
		btnPurchase.setBounds(520, 315, 117, 29);
		frame.getContentPane().add(btnPurchase);

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

		btnPurchase.addActionListener(new ActionListener() {
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
					    moneyLabel.setText("$" + PlayerBusiness.getMoney());

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

		JButton equipmentHelp = new JButton("?");
		equipmentHelp.setOpaque(true);
		equipmentHelp.setFont(new Font("SansSerif", Font.BOLD, 12));
		equipmentHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				JOptionPane.showMessageDialog(frame, "Hotplate: Increases speed (3% quality increase)" + "\n" + "Stove Burner Upgrade: Increases speed (10% quality increase, 50 s/d increase)" 
						+ "\n" + "Energy Efficient Appliances: Reduces utility cost");

			}
		});
		equipmentHelp.setBounds(6, 37, 23, 24);
		frame.getContentPane().add(equipmentHelp);

		JButton foodHelp = new JButton("?");
		foodHelp.setFont(new Font("SansSerif", Font.BOLD, 12));
		foodHelp.setOpaque(true);
		foodHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Premium Meat Supplier: 45% quality increase, 30 s/d increase" + "\n" + "Organic Farm Partnership: 35% quality increase, 30 s/d increase" + "\n" + "Gourmet Recipe Book: 50% quality increase, 20 s/d increase" + "\n"
						+ "Seasonal Menu Updates: 10 s/d increase ");

			}
		});
		foodHelp.setBounds(6, 79, 23, 24);
		frame.getContentPane().add(foodHelp);

		JButton knifeHelp = new JButton("?");
		knifeHelp.setFont(new Font("SansSerif", Font.BOLD, 12));
		knifeHelp.setOpaque(true);
		knifeHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Blade Upgrade: Increase Speed" + "\n" + "Handle Upgrade: Increase Comfort" + "\n" + "Sharpner Upgrade: Increase Speed");
			}
		});
		knifeHelp.setBounds(6, 121, 23, 24);
		frame.getContentPane().add(knifeHelp);

		JButton cleanerHelp = new JButton("?");
		cleanerHelp.setFont(new Font("SansSerif", Font.BOLD, 12));
		cleanerHelp.setOpaque(true);
		cleanerHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Industrial Grade Cleaning Supplies: Cleanliness Increase 10% " + "\n" + "Cleaning Robots: Cleanliness Increase: 50% " + "\n" + "Eco Friendly Cleaning Supplies: Cleanliness Increase 15%" + "\n" + "24/7 cleaning staff: Cleanliness Increase 100%");


			}
		});
		cleanerHelp.setBounds(6, 163, 23, 24);
		frame.getContentPane().add(cleanerHelp);


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