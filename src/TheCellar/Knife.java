package TheCellar;// TheCellar.Knife (Abstract)
// #Name: string
// #Price: int
// #Modifier: int
// #UpgradePrice: int
// get&set for all fields


import TheCellar.Items.Knives.BladeUpgrade;
import TheCellar.Items.Knives.HandleUpgrade;
import TheCellar.Items.Knives.SharpnerUpgrade;
import TheCellar.Items.Knives.PlasticKnives;

import java.io.Serializable;

public abstract class Knife implements Serializable {
    protected String name;
    protected int price;
    protected double QualityModifier;
	protected int SteaksPerDayIncrease;
    protected int upgradePrice;

    public static final Knife[] KnifeTypes = {
    		new BladeUpgrade(),
    		new HandleUpgrade(),
    		new SharpnerUpgrade(),
    		new PlasticKnives(),
	};

	public Knife(String name, int price, double modifier, int SteaksPerDayIncrease, int upgradePrice) {
		this.name = name;
		this.price = price;
		this.QualityModifier = modifier;
		this.upgradePrice = upgradePrice;
		this.SteaksPerDayIncrease = SteaksPerDayIncrease;
	}


	public int getSteaksPerDayIncrease() {
		return SteaksPerDayIncrease;
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
	
	public double getQualityModifier() {
		return QualityModifier;
	}
	
	public void setQualityModifier(double qualityModifier) {
		this.QualityModifier = qualityModifier;
		
	}
	
	public int getUpgradePrice() {
		return upgradePrice;
		
	}
	
	public void setUpgradePrice(int upgradePrice) {
		this.upgradePrice = upgradePrice;
	}
}


