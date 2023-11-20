// Equipment (Abstract)
// #Name: string
// #Price: int
// #Modifier: int
// #UpgradePrice: int
// get&set for all fields

public abstract class Equipment {
	protected String name;
	protected int price;
	protected int modifier;
	protected int upgradePrice;

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
	
	public int getModifier() {
		return modifier;
		
	}
	
	public void setModifier() {
		this.modifier = modifier;
		
	}
	
	public int getUpgradePrice() {
		return upgradePrice;
		
	}
	
	public void setUpgradePrice() {
		this.upgradePrice = upgradePrice;
	}
}
