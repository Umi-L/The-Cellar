package TheCellar;// TheCellar.Equipment (Abstract)
// #Name: string
// #Price: int
// #Modifier: int
// #UpgradePrice: int
// get&set for all fields

import TheCellar.Items.Equipment.Hotplate;
import TheCellar.Items.Equipment.StoveBurnerUpgrade;
import TheCellar.Items.Equipment.EnergyEfficientAppliances;

import java.io.Serializable;


public abstract class Equipment implements Serializable {
	protected String name;
	protected int price;
	protected double modifier;
	protected int upgradePrice;

	public static final Equipment[] EquipmentTypes = {
			new Hotplate(),
			new StoveBurnerUpgrade(),
			new EnergyEfficientAppliances(),
	};

	public Equipment(String name, int price, double modifier, int upgradePrice) {
		this.name = name;
		this.price = price;
		this.modifier = modifier;
		this.upgradePrice = upgradePrice;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	public int getPrice() {
		return price;
		
	}
	
	public void setPrice(int price) {
		this.price = price;
		
	}
	
	public double getModifier() {
		return modifier;
		
	}
	
	public void setModifier(int modifier) {
		this.modifier = modifier;
		
	}
	
	public int getUpgradePrice() {
		return upgradePrice;
		
	}
	
	public void setUpgradePrice(int upgradePrice) {
		this.upgradePrice = upgradePrice;
	}
}
