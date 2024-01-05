package TheCellar.GUI;

import TheCellar.Business;
import TheCellar.Cleaner;
import TheCellar.Equipment;
import TheCellar.Food;
import TheCellar.Game;
import TheCellar.Knife;
import TheCellar.Main;


import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class ShopPage {
	private JFrame frame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JLabel moneyLabel; 
	private JButton addToCartButton;
	private JComboBox<?> selectedComboBox;
	private JComboBox<Object> equipment = new JComboBox<>();
	private JComboBox<Object> food = new JComboBox<>();
	private JComboBox<Object> knife = new JComboBox<>();
	private static Set<Object> purchasedUpgrades = new HashSet<>();
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
	//method to load purchased upgrades
	private static void loadPurchasedUpgrades() {
	    try (BufferedReader reader = new BufferedReader(new FileReader("purchasedUpgrades.csv"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            purchasedUpgrades.add(line);
	        }
	        System.out.println("Loaded Purchased Upgrades: " + purchasedUpgrades);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	    // Method to save purchased upgrades 
	private static void savePurchasedUpgrades() {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("purchasedUpgrades.csv"))) {
	        for (Object upgrade : purchasedUpgrades) {
	            writer.write(upgrade.toString());
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	//handle combo box selection and set location of add to cart button
	private void handleComboBoxSelection() {
	    if (selectedComboBox != null && addToCartButton != null) {
	        Object selectedItem = selectedComboBox.getSelectedItem();

	        if (selectedItem != null && !selectedItem.toString().isEmpty()) {
	            // Convert item name to lowercase for case-insensitive comparison
	            String itemName = selectedItem.toString().toLowerCase();

	            if (purchasedUpgrades.contains(itemName)) {
	                JOptionPane.showMessageDialog(frame, "You already own this item.");
	            } else {
	                setButtonLocation();
	                addToCartButton.setVisible(true);
	            }
	        } else {
	            addToCartButton.setVisible(false);
	        }
	    }
	}
	//Method to hide other combo boxes when another upgrade type is clicked
	private void hideOtherComboBoxes(JComboBox<Object> selectedComboBox) {
		if (equipment != null && equipment != selectedComboBox) {
			equipment.setVisible(false);
		}

		if (food != null && food != selectedComboBox) {
			food.setVisible(false);
		}

		if (knife != null && knife != selectedComboBox) {
			knife.setVisible(false);
		}

		addToCartButton.setVisible(false);
	}

	private Object getSelectedItem() {
		if (selectedComboBox != null) {
			int selectedIndex = selectedComboBox.getSelectedIndex();
			if (selectedIndex >= 0) {
				return selectedComboBox.getItemAt(selectedIndex);
			}
		}
		return null;
	}

	private int getPrice(Object selectedItem) {
		if (selectedItem instanceof Equipment) {
			return ((Equipment) selectedItem).getPrice();
		} else if (selectedItem instanceof Food) {
			return ((Food) selectedItem).getPrice();
		} else if (selectedItem instanceof Knife) {
			return ((Knife) selectedItem).getPrice();
		} else {

			return 0;
		}
	}
	
	private void processPurchase() {
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
	                // Handle the exception if necessary
	            }
	        }
	    }

	    // Check if the total cost is less than or equal to remainingBalance
	    if (totalCost <= PlayerBusiness.money) {
	        // Deduct the total cost from the remaining balance
	        PlayerBusiness.money -= totalCost;

	        // Update the UI with the new remaining balance
	        moneyLabel.setText("$" + PlayerBusiness.money);

	        // Purchase details
	        String purchaseDetails = "Items Purchased:\n\n" + textArea.getText() +
	                "\n\nRemaining Balance: $" + PlayerBusiness.money;

	        // Save purchased upgrades
	        for (String item : cartItems) {
	            String itemName = item.split(" - ")[0].toLowerCase();  // Convert to lowercase
	            purchasedUpgrades.add(itemName);
	        }
	        savePurchasedUpgrades();

	        JOptionPane.showMessageDialog(frame, "Purchase successful!\n\n" + purchaseDetails);

	        // Clear the cart after a successful purchase
	        textArea.setText("");

	        // Reset JComboBox selection
	        equipment.setSelectedIndex(0);
	        food.setSelectedIndex(0);
	        knife.setSelectedIndex(0);
	      

	        addToCartButton.setVisible(false);

	        equipment.setVisible(false);
	        food.setVisible(false);
	        knife.setVisible(false);
	       
	    } else {
	        // User has insufficient funds
	        JOptionPane.showMessageDialog(frame, "Insufficient funds.");
	        textArea.setText("");
	        addToCartButton.setVisible(false);

	        // Hide JComboBox components
	        equipment.setVisible(false);
	        food.setVisible(false);
	        knife.setVisible(false);
	       
	        
	        
	    }
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public ShopPage() {
		
		
        loadPurchasedUpgrades();

		this.PlayerBusiness = Main.game != null ? Main.game.PlayerBusiness : new Business();

		frame = new JFrame("");
		frame.getContentPane().setBackground(new Color(145, 145, 145));
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

		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(510, 34, 273, 269);
		frame.getContentPane().add(scrollPane);

		moneyLabel = new JLabel("$" + Main.game.PlayerBusiness.money);
		moneyLabel.setBackground(new Color(192, 192, 192));
		moneyLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		moneyLabel.setBounds(649, 375, 145, 38);
		frame.getContentPane().add(moneyLabel);

		addToCartButton = new JButton("Add to cart"); 
		addToCartButton.setBackground(new Color(225, 6, 0));
		addToCartButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		addToCartButton.setOpaque(true);
		addToCartButton.setBounds(383, 34, 114, 30);
		frame.getContentPane().add(addToCartButton);
		addToCartButton.setVisible(false);

		addToCartButton = new JButton("Add to cart"); 
		addToCartButton.setBackground(new Color(225, 6, 0));
		addToCartButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		addToCartButton.setOpaque(true);
		addToCartButton.setBounds(383, 34, 114, 30);
		frame.getContentPane().add(addToCartButton);
		addToCartButton.setVisible(false);

		addToCartButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (selectedComboBox != null) {
		            Object selectedItem = getSelectedItem();

		            if (selectedItem != null && !selectedItem.toString().isEmpty()) {
		                // Check if the item is already in the cart
		                if (textArea.getText().contains(selectedItem.toString())) {
		                    JOptionPane.showMessageDialog(frame, "Item already in the cart.");
		                } else {
		                    // Check if the item is already owned
		                    if (purchasedUpgrades.contains(selectedItem)) {
		                        JOptionPane.showMessageDialog(frame, "You already own this item.");
		                    } else {
		                        int itemCost = getPrice(selectedItem);

		                        if (itemCost > 0 && itemCost <= PlayerBusiness.money) {
		                            // Add the item to the cart
		                            textArea.append(selectedItem + " - $" + itemCost + "\n");
		                            setButtonLocation();
		                            addToCartButton.setVisible(true);
		                            selectedComboBox.setSelectedIndex(0);
		                        } else {
		                            // User has insufficient funds
		                            JOptionPane.showMessageDialog(frame, "Insufficient funds.");
		                        }
		                    }
		                }
		            }
		        }
		    }
		});
		equipment = new JComboBox<Object>();
		equipment.setBounds(203, 34, 178, 30);
		frame.getContentPane().add(equipment);
		equipment.addItem("");

		for (Equipment currentEquipment : Equipment.EquipmentTypes) {
			equipment.addItem(currentEquipment); 
		}

		equipment.setVisible(false);

		equipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedComboBox = equipment;
				handleComboBoxSelection();

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

		food = new JComboBox<Object>();
		food.setBounds(203, 76, 178, 30);
		frame.getContentPane().add(food);
		food.addItem("");

		for (Food currentFood : Food.FoodTypes) {
			food.addItem(currentFood); 
		}
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

		knife = new JComboBox<Object>();
		knife.setBounds(203, 118, 178, 30);
		frame.getContentPane().add(knife);
		knife.addItem("");
		for (Knife currentKnife : Knife.KnifeTypes) {
			knife.addItem(currentKnife); 
		}
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
						


						equipment.setVisible(false);
						food.setVisible(false);
						knife.setVisible(false);
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
	                    // Process the purchase
	                    processPurchase();
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