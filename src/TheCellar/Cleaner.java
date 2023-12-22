package TheCellar;/*
 TheCellar.Cleaner
#Price: int
#Modifier: int
get&set for all fields
 */

import java.io.Serializable;

import TheCellar.Items.Cleaner.CleaningRobots;
import TheCellar.Items.Cleaner.EcoFriendlyCleaningSupplies;
import TheCellar.Items.Cleaner.IndustrialGradeCleaningSupplies;
import TheCellar.Items.Cleaner.CleaningStaff;



public class Cleaner  implements Serializable {
	protected String name;
    protected int price;
    protected double modifier;
    
    public static final Cleaner[] CleanerTypes = {
			new CleaningRobots(),
			new EcoFriendlyCleaningSupplies(),
			new IndustrialGradeCleaningSupplies(),
			new CleaningStaff(),
	};

	public Cleaner(String name, int price, double modifier) {
		this.name = name;
		this.price = price;
		this.modifier = modifier;
		
	}
	
	public Cleaner() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
		
	public String setName() {
		return name;
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
	
	public String toString() {
	    return getName();  
    }
}
