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
	protected double qualityModifier;
	protected int SteaksPerDayIncrease;
	protected int upgradePrice;

	public static final Equipment[] EquipmentTypes = {
			new Hotplate(),
			new StoveBurnerUpgrade(),
			new EnergyEfficientAppliances(),
	};

	public Equipment(String name, int price, double modifier, int steaksPerDayIncrease, int upgradePrice) {
		this.name = name;
		this.price = price;
		this.qualityModifier = modifier;
		this.upgradePrice = upgradePrice;
		this.SteaksPerDayIncrease = steaksPerDayIncrease;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}

	public int getSteaksPerDayIncrease() {
		return SteaksPerDayIncrease;
	}
	
	public int getPrice() {
		return price;
		
	}
	
	public void setPrice(int price) {
		this.price = price;
		
	}
	
	public double getQualityModifier() {
		return qualityModifier;
		
	}
	
	public void setQualityModifier(int qualityModifier) {
		this.qualityModifier = qualityModifier;
		
	}
	
	public int getUpgradePrice() {
		return upgradePrice;
		
	}
	
	public void setUpgradePrice(int upgradePrice) {
		this.upgradePrice = upgradePrice;
	}
}
