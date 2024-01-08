package TheCellar;/*TheCellar.Chef (Abstract)
#Name: string
#Price: int
#Modifier: int
get&set for all fields
*/

import TheCellar.Items.Chefs.GradChef;
import TheCellar.Items.Chefs.RamsayChef;
import TheCellar.Items.Chefs.TeenChef;

import java.io.Serializable;

public abstract class Chef extends Purchasable implements Serializable {

	public static final Chef[] ChefTypes = {
			new TeenChef(),
			new GradChef(),
			new RamsayChef()
	};


	public Chef(String name, int price, double modifier, int SteaksPerDayIncrease) {
		this.name = name;
		this.price = price;
		this.qualityModifier = modifier;
		this.steaksPerDayIncrease = SteaksPerDayIncrease;
	}
}
