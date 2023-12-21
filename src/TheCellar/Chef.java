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

public abstract class Chef implements Serializable {

	public static final Chef[] ChefTypes = {
			new TeenChef(),
			new GradChef(),
			new RamsayChef()
	};


	public Chef(String name, int price, double modifier, int SteaksPerDayIncrease) {
		this.name = name;
		this.price = price;
		this.modifier = modifier;
		this.SteaksPerDayIncrease = SteaksPerDayIncrease;
	}

	protected String name;
	protected int price;
	protected double modifier;
	public int SteaksPerDayIncrease;



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

	public double getModifier() {
		return modifier;
	}
	
	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
}
