package TheCellar;// TheCellar.Knife (Abstract)
// #Name: string
// #Price: int
// #Modifier: int
// #UpgradePrice: int
// get&set for all fields


import TheCellar.Items.Knife.BladeUpgrade;
import TheCellar.Items.Knife.HandleUpgrade;
import TheCellar.Items.Knife.SharpnerUpgrade;
import TheCellar.Items.Knives.PlasticKnives;

import java.io.Serializable;

public abstract class Knife implements Serializable {
    protected String name;
    protected int price;
    protected double modifier;
    protected int upgradePrice;

    public static final Knife[] KnifeTypes = {
    		new BladeUpgrade(),
    		new HandleUpgrade(),
    		new SharpnerUpgrade(),
    		new PlasticKnives(),


	};

	public Knife(String name, int price, double modifier, int upgradePrice) {
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
	
	public void setModifier(double modifier) {
		this.modifier = modifier;
		
	}
	
	public int getUpgradePrice() {
		return upgradePrice;
		
	}
	
	public void setUpgradePrice(int upgradePrice) {
		this.upgradePrice = upgradePrice;
	}
}


