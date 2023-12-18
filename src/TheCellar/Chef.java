package TheCellar;/*TheCellar.Chef (Abstract)
#Name: string
#Price: int
#Modifier: int
get&set for all fields
*/

import TheCellar.Items.Chefs.GradChef;
import TheCellar.Items.Chefs.RamsayChef;
import TheCellar.Items.Chefs.TeenChef;

public abstract class Chef {

	public static final Chef[] ChefTypes = {
			new TeenChef(),
			new GradChef(),
			new RamsayChef()
	};

	public Chef(String name, int price, double modifier) {
		this.name = name;
		this.price = price;
		this.modifier = modifier;
	}

	protected String name;
	protected int price;
	protected double modifier;
	
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
