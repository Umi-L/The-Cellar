package TheCellar;/*
 TheCellar.Cleaner
#Price: int
#Modifier: int
get&set for all fields
 */

import java.io.Serializable;

public class Cleaner  implements Serializable {
	protected String name = "Cleaner";
    protected int price = 1200;
    protected double clenlinessModifier = .15;

	public String getName() {
		return name;
	}

    public int getPrice() {
        return price;

    }

    public void setPrice(int price) {
        this.price = price;

    }

    public double getModifier() {
        return clenlinessModifier;

    }
	
	public String toString() {
	    return getName();  
    }
}
