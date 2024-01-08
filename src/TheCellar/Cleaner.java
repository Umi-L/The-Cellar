package TheCellar;/*
 TheCellar.Cleaner
#Price: int
#Modifier: int
get&set for all fields
 */

import java.io.Serializable;

public class Cleaner extends Purchasable implements Serializable {
    public Cleaner() {
    	this.name = "Cleaner";
    	this.price = 1200;
    	this.cleanlinessModifier = .15;
    }
}
