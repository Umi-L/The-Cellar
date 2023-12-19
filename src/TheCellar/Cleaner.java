package TheCellar;/*
 TheCellar.Cleaner
#Price: int
#Modifier: int
get&set for all fields
 */

import java.io.Serializable;

public class Cleaner  implements Serializable {
    protected int price;
    protected int modifier;

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
