package TheCellar;/*TheCellar.Chef (Abstract)
#Name: string
#Price: int
#Modifier: int
get&set for all fields
*/

public class Chef {

	protected String name;
	protected int price;
	protected int modifier;
	
	int teenCount;
	int gradCount;
	int ramsayCount; 
	
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
