/*Chef (Abstract)
#Name: string
#Price: int
#Modifier: int
get&set for all fields
*/

public abstract class Chef {

	protected String name;
	protected int price;
	protected int modifier;
	
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
	
	public void setModifier(int modifier) {
		this.modifier = modifier;
		
	}
	

}
