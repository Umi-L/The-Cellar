package TheCellar;// TheCellar.Equipment (Abstract)
// #Name: string
// #Price: int
// #Modifier: int
// #UpgradePrice: int
// get&set for all fields

import TheCellar.Items.Equipment.Hotplate;
import TheCellar.Items.Equipment.StoveBurnerUpgrade;
import TheCellar.Items.Equipment.Range;

import java.io.Serializable;


public abstract class Equipment extends Purchasable implements Serializable {

	public static final Equipment[] EquipmentTypes = {
			new Hotplate(),
			new StoveBurnerUpgrade(),
			new Range(),
	};

	public Equipment(String name, int price, double modifier, int steaksPerDayIncrease, int upgradePrice) {
		this.name = name;
		this.price = price;
		this.qualityModifier = modifier;
		this.upgradePrice = upgradePrice;
		this.steaksPerDayIncrease = steaksPerDayIncrease;
	}
}
