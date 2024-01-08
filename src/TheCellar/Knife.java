package TheCellar;// TheCellar.Knife (Abstract)
// #Name: string
// #Price: int
// #Modifier: int
// #UpgradePrice: int
// get&set for all fields



import TheCellar.Items.Knives.PlasticKnives;
import TheCellar.Items.Knives.Machete;
import TheCellar.Items.Knives.Katana;



import java.io.Serializable;

public abstract class Knife extends Purchasable implements Serializable {

    public static final Knife[] KnifeTypes = {
    		new PlasticKnives(),
    		new Machete(),
    		new Katana(),
	};

	public Knife(String name, int price, double modifier, int SteaksPerDayIncrease, int upgradePrice) {
		this.name = name;
		this.price = price;
		this.qualityModifier = modifier;
		this.upgradePrice = upgradePrice;
		this.steaksPerDayIncrease = SteaksPerDayIncrease;
	}
}


