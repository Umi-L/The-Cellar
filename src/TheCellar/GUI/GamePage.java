package TheCellar.GUI;

import TheCellar.Business;
import TheCellar.Main;
import TheCellar.TickListener;
import TheCellar.Charts.Animation;
import TheCellar.Charts.BarGraph;
import TheCellar.Charts.LineGraph;
import TheCellar.Charts.PieChart;
import TheCellar.Main;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.border.CompoundBorder;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import javax.swing.ActionMap;
import javax.swing.InputMap;


// window builder class that creates the gui
// was mainly auto generated by eclipse
public class GamePage {
	public static JFrame frame;
	public boolean textListenerEnabled = true;
	
	public static void showWindow() {
		
		
	}
	
	public GamePage() {
		// set title
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setTitle("The Cellar");
		frame.pack();

		// set close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 950, 500);
		frame.getContentPane().setLayout(null);
		
//		JPanel Animation = new Animation();
//		Animation.setBorder(new CompoundBorder());
//		Animation.setBackground(new Color(248, 248, 248));
//		Animation.setBounds(101, 11, 732, 312);
//		frame.getContentPane().add(Animation);
		
		JSlider slider = new JSlider();
		slider.setBounds(14, 384, 151, 26);
		frame.getContentPane().add(slider);
		slider.addChangeListener(e -> {
			if (textListenerEnabled) {
				System.out.println("Slider value: " + slider.getValue());

				float percent = slider.getValue() / 100.0f;
				int min = Main.game.GameSpeedMin;
				int max = Main.game.GameSpeedMax;
				int range = max - min;
				int value = (int) (min + range * percent);

				Main.game.SetGameSpeed(value);
			}
		});
		
		JLabel timeLabel = new JLabel("Game Speed\r\n");
		timeLabel.setBounds(54, 369, 81, 14);
		frame.getContentPane().add(timeLabel);
		
		
		JLabel money = new JLabel("Net Worth: ");
		money.setFont(new Font("SansSerif", Font.ITALIC, 18));
		money.setBounds(720, 8, 100, 38);
		frame.getContentPane().add(money);
		
		JLabel debt = new JLabel("Debt: ");
		debt.setFont(new Font("SansSerif", Font.ITALIC, 18));
		debt.setBounds(720, 25, 100, 38);
		frame.getContentPane().add(debt);
		
		JLabel moneyLabel = new JLabel(String.valueOf(Main.game.PlayerBusiness.getMoney()));
		moneyLabel.setBackground(new Color(192, 192, 192));
		moneyLabel.setFont(new Font("SansSerif", Font.ITALIC, 18));
		moneyLabel.setBounds(820, 8, 81, 38);
		frame.getContentPane().add(moneyLabel);
		
		JLabel debtLabel = new JLabel(String.valueOf(Main.game.PlayerBusiness.getDebt()));
		debtLabel.setFont(new Font("SansSerif", Font.ITALIC, 18));
		debtLabel.setBounds(770, 25, 81, 38);
		frame.getContentPane().add(debtLabel);

		PieChart pieChart = new PieChart();
		pieChart.setBounds(100, 10, 300, 200);
		frame.getContentPane().add(pieChart);

		LineGraph lineGraph = new LineGraph("time", "company value");
		lineGraph.setBounds(633, 331, 200, 122);
		frame.getContentPane().add(lineGraph);

		BarGraph barGraph = new BarGraph("value");
		barGraph.setBounds(175, 331, 200, 122);
		frame.getContentPane().add(barGraph);

		ArrayList<Double> goingRateValues = new ArrayList<>();
		Main.game.addTickListener(new TickListener() {
			@Override
			public void onTick() {
				ArrayList<String> labels = new ArrayList<>();
				ArrayList<Double> netWorthValues = new ArrayList<>();

				// add ai businesses
				for (int i = 0; i < Main.game.AIBusinesses.size(); i++) {
					Business b = Main.game.AIBusinesses.get(i);
					labels.add(b.getName());
					netWorthValues.add((double)b.GetNetWorth());
				}

				// add player business
				labels.add(Main.game.PlayerBusiness.getName());
				netWorthValues.add((double)Main.game.PlayerBusiness.GetNetWorth());

				goingRateValues.add((double)Main.game.getGoingRate());

				// if more than 10 values, remove the first one
				if (goingRateValues.size() > 10) {
					goingRateValues.remove(0);
				}

				pieChart.Update(labels, netWorthValues);
				barGraph.Update(labels, netWorthValues);
				lineGraph.Update(goingRateValues);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(11, 9, 81, 311);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton pauseButton = new JButton("Pause");
		pauseButton.setBounds(6, 5, 69, 45);
		panel_1.add(pauseButton);
		pauseButton.setFont(new Font("Arial", Font.BOLD, 12));
		pauseButton.setBackground(new Color(128, 128, 128));
		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PauseMenuPage pause = new TheCellar.GUI.PauseMenuPage();	}
		});
		
		Button bankButton = new Button("Bank");
		bankButton.setBounds(6, 75, 69, 65);
		panel_1.add(bankButton);
		bankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TheCellar.GUI.BankPage bank = new TheCellar.GUI.BankPage();
				bank.showWindow();
			}
		});
		bankButton.setFont(new Font("SansSerif", Font.BOLD, 18));
		bankButton.setBackground(new Color(248, 242, 22));
		
		Button shopButton = new Button("Shop");
		shopButton.setBounds(7, 154, 69, 65);
		panel_1.add(shopButton);
		shopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				TheCellar.GUI.ShopPage shop = new ShopPage();
				shop.showWindow();
			}
		});
		shopButton.setFont(new Font("SansSerif", Font.BOLD, 18));
		shopButton.setBackground(new Color(0, 255, 255));
		
		
				
				Button hireButton = new Button("Hire");
				hireButton.setBounds(6, 236, 69, 65);
				panel_1.add(hireButton);
				hireButton.setFont(new Font("SansSerif", Font.BOLD, 18));
				hireButton.setBackground(new Color(255, 0, 255));
				hireButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						TheCellar.GUI.HirePage chefs = new HirePage();
						chefs.showWindow();	
				}
				});
		//Animation.requestFocusInWindow();
		
		frame.setFocusable(true);

		InputMap inputMap = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = frame.getRootPane().getActionMap();

		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "pauseMenu");
		actionMap.put("pauseMenu", new AbstractAction() {
		   
		    public void actionPerformed(ActionEvent e) {
		        PauseMenuPage pause = new PauseMenuPage();
		        pause.showWindow();
		    }
		});
		
		Main.game.addTickListener(new TickListener() {
			public void onTick() {
				moneyLabel.setText(String.valueOf(Main.game.PlayerBusiness.getMoney()));
			}
		});
		
		
		frame.setVisible(true);
	}
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		
		
	}
		
		public static void main(String[] args) {
			new GamePage();
			showWindow();
			
			
	}
}

